package com.java.controller;

import com.java.entity.KycgPo;
import com.java.entity.MyFileUpload;
import com.java.entity.commons.BaseMessage;
import com.java.entity.commons.BaseQuery;
import com.java.entity.commons.BaseResult;
import com.java.entity.user.User;
import com.java.service.KycgService;
import com.java.service.MyFileService;
import com.sun.deploy.net.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/file")
public class MyFileController {
    private static Logger logger = LoggerFactory.getLogger(MyFileController.class);

    @Autowired
    private MyFileService myFileService;

    @RequestMapping(value = "/selectByKey",method = RequestMethod.GET)
    public MyFileUpload selectXmsbByPrimaryKey(String wjlsh){
        MyFileUpload fileUpload = new MyFileUpload();
        try {
            if(wjlsh == null || wjlsh.equals("")){
                throw new Exception("传入参数不合法");
            }
            fileUpload = myFileService.selectXmsbByPrimaryKey(wjlsh);
        }catch (Exception e){
            logger.error("查询文件失败");
            e.printStackTrace();
        }
        return fileUpload;
    }

    @RequestMapping(value = "/deleteByKey",method = RequestMethod.GET)
    public BaseMessage deleteByPrimaryKey(String wjlsh){
        BaseMessage message = new BaseMessage();
        try {
            if(wjlsh == null || wjlsh.equals("")){
                message.setMessage("传入参数不合法");
                return message;
            }
            myFileService.deleteByPrimaryKey(wjlsh);
        }catch (Exception e){
            logger.error("文件据失败",e);
           message.setMessage("文件据失败");
        }
        message.setMessage("删除该条数据成功");
        return message;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public BaseMessage add(HttpServletRequest request, KycgPo kycgPo, @RequestParam(value = "file", required = false)CommonsMultipartFile[]  files){
        BaseMessage message = new BaseMessage();
        try {
            if(kycgPo == null){
                message.setMessage("传入参数不合法");
                return message;
            }
            String uuid = UUID.randomUUID().toString().replace("-","");
            kycgPo.setCglsh(uuid);
            //上传文件保存位置
            String pathString =  request.getSession().getServletContext().getRealPath("/upload/");
            //判断文件夹是否存在
            File file=new File(pathString);
            if(!file.isDirectory())
            {
                //创建文件夹
                file.mkdirs();
                logger.info("创建文件夹："+ pathString);
            }
            //批量上传
            List<MyFileUpload> listfie = new ArrayList<MyFileUpload>();
            String wjlshs = "";
            for(int i = 0;i<files.length;i++){
                MyFileUpload fileUpload = new MyFileUpload();
                String fileName = files[i].getOriginalFilename();
                String path = pathString+"/"+fileName;
                logger.info("fileName："+path);
                File newFile=new File(path);
                //上传日志
                files[i].transferTo(newFile);
                String wjlsh = UUID.randomUUID().toString().replace("-","");
                fileUpload.setWjlsh(wjlsh);
                fileUpload.setWjmc(fileName);
                String hzm = fileName.substring(fileName.indexOf(".")+1).toUpperCase();
                fileUpload.setHzm(hzm);
                fileUpload.setWjlj(path);
                if(hzm.equals("BPM")||hzm.equals("JPG")||hzm.equals("JPEG")||hzm.equals("GIF")||hzm.equals("PNG")||hzm.equals("PSD")){
                    fileUpload.setWjlx("0");
                }
                else if(hzm.equals("WAV")||hzm.equals("MP3")||hzm.equals("AIFF")||hzm.equals("AU")){
                    fileUpload.setWjlx("1");
                }
                else if(hzm.equals("AVI")||hzm.equals("MP4")||hzm.equals("RMVB")||hzm.equals("MID")||hzm.equals("FLASH")){
                    fileUpload.setWjlx("2");
                }else {
                    fileUpload.setWjlx("3");
                }
                fileUpload.setCglsh(kycgPo.getCglsh());
                fileUpload.setCgmc(kycgPo.getCgmc());
                listfie.add(fileUpload);
                wjlshs = wjlshs+","+wjlsh;
            }
            myFileService.insertByBatch(listfie);
            //业务数据
            User user = (User) request.getSession().getAttribute("LoginMoldel");

        }catch (Exception e){
            logger.error("成果上传失败",e);
            message.setMessage("成果上传失败");
        }
        message.setMessage("成果上传成功");
        return message;
    }

    @RequestMapping(value = "/getMyFilePageInfo",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult<MyFileUpload> getMyFilePageInfo(BaseQuery query){
        BaseResult<MyFileUpload> result = new BaseResult<MyFileUpload>();
        try {
            if(query == null){
                throw new Exception("传入参数不合法");
            }
            result = myFileService.getPageInfo(query);
        }catch (Exception e){
            logger.error("科研成果列表查询失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/downFile",method = RequestMethod.GET)
    public void downFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String wjlsh = request.getParameter("wjlsh");
        MyFileUpload fileUpload = myFileService.selectXmsbByPrimaryKey(wjlsh);
        String fileName = fileUpload.getWjmc();
        String path = fileUpload.getWjlj();
        File file = new File(path);
        logger.info("-------下载文件");
        // 构建FastDFS客户端
        // 通过FastDFS客户端获取文件流
        byte[] fileBytes = getBytes(path);
        // 根据PubFile生成文件名（带后缀格式）
        if (fileBytes == null || fileBytes.length <= 0) {
            return;
        }
        // 设置文件名编码为UTF-8，处理中文乱码
        fileName = URLEncoder.encode(fileName, "UTF-8");
        // 设置返回内容类型为multipart/form-data
        response.setContentType("multipart/form-data");
        // 设置文件头并将类型设置为附件，并将正确的文件名返回
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
        OutputStream output = null;
        ByteArrayInputStream fis = null;
        try {
            // 构建输出流
            output = response.getOutputStream();
            if (null != fileBytes) {
                // 构建文件流的ByteArrayInputStream
                fis = new ByteArrayInputStream(fileBytes);
                if (null != fis) {
                    byte[] b = new byte[1024];
                    int i = 0;
                    // 输出流到前端
                    while ((i = fis.read(b)) > 0) {
                        output.write(b, 0, i);
                    }
                }
            }
            // 刷新流
            output.flush();
        } catch (Exception e) {
            throw e;
        } finally {
            // 关闭ByteArrayInputStream
            if (fis != null) {
                fis.close();
            }
            // 关闭输出流
            if (output != null) {
                output.close();
            }
        }
    }


    public  byte[] getBytes(String filePath){

        byte[] buffer = null;

        try {

            File file = new File(filePath);

            FileInputStream fis = new FileInputStream(file);

            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);

            byte[] b = new byte[1000];

            int n;

            while ((n = fis.read(b)) != -1) {

                bos.write(b, 0, n);

            }

            fis.close();

            bos.close();

            buffer = bos.toByteArray();

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return buffer;

    }


}
