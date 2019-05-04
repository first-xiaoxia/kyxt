package com.java.controller;

import com.java.entity.KycgPo;
import com.java.entity.KyjfPo;
import com.java.entity.MyFileUpload;
import com.java.entity.commons.BaseMessage;
import com.java.entity.commons.BaseQuery;
import com.java.entity.commons.BaseResult;
import com.java.entity.user.User;
import com.java.entity.vo.XmcgglVo;
import com.java.service.KycgService;
import com.java.service.KyjfService;
import com.java.service.MyFileService;
import com.java.service.XmcgglService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/kycg")
public class KycgController {
    private final String tupians="BPM,JPEG,GIF,PNG,PSD";
    private final String yinpins="WAV,MP3,AIFF,AU";
    private final String shipins="AVI,MP4,RMVB,MID,FLASH";
    private static Logger logger = LoggerFactory.getLogger(KycgController.class);

    @Autowired
    private KycgService kycgService;

    @Autowired
    private MyFileService myFileService;

    @Autowired
    private XmcgglService xmcgglService;

    @RequestMapping(value = "/selectByKey",method = RequestMethod.GET)
    public KycgPo selectXmsbByPrimaryKey(String xmlsh){
        KycgPo kycgPo = new KycgPo();
        try {
            if(xmlsh == null || xmlsh.equals("")){
                throw new Exception("传入参数不合法");
            }
            kycgPo = kycgService.selectXmsbByPrimaryKey(xmlsh);
        }catch (Exception e){
            logger.error("查询科研成果失败");
            e.printStackTrace();
        }
        return kycgPo;
    }

    @RequestMapping(value = "/deleteByKey",method = RequestMethod.GET)
    public BaseMessage deleteByPrimaryKey(String cglsh){
        BaseMessage message = new BaseMessage();
        try {
            if(cglsh == null || cglsh.equals("")){
                message.setMessage("传入参数不合法");
                return message;
            }
            kycgService.deleteByPrimaryKey(cglsh);
        }catch (Exception e){
            logger.error("删除成果数据失败",e);
           message.setMessage("删除成果数据失败");
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
            //文件上传
            String pathString =  request.getSession().getServletContext().getRealPath("/upload/");
            uploadFile(pathString,kycgPo,files);
            //业务数据
            User user = (User) request.getSession().getAttribute("LoginMoldel");
            kycgPo.setCjr(user.getYhmc());
            SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String cjsj = simpleDate.format(new Date());
            kycgPo.setCjsj(cjsj);
            kycgPo.setShzt("0");
            kycgService.insertKyjf(kycgPo);
        }catch (Exception e){
            logger.error("成果上传失败",e);
            message.setMessage("成果上传失败");
        }
        message.setMessage("成果上传成功");
        return message;
    }


    @RequestMapping(value = "/update",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public BaseMessage update(HttpServletRequest request, KycgPo kycgPo, @RequestParam(value = "file1", required = false)CommonsMultipartFile[]  files){
        BaseMessage message = new BaseMessage();
        try {
            if(kycgPo == null){
                message.setMessage("传入参数不合法");
                return message;
            }
            //文件上传
            String pathString =  request.getSession().getServletContext().getRealPath("/upload/");
            uploadFile(pathString,kycgPo,files);
            //业务数据修改
            kycgService.updateByPrimaryKeySelective(kycgPo);
            message.setMessage("修改成功");
        }catch (Exception e){
            logger.error("科研成果修改失敗",e);
            message.setMessage("科研成果修改失敗");
        }
        return message;
    }

    @RequestMapping(value = "/updatesh",method = RequestMethod.POST)
    public BaseMessage updatesh(HttpServletRequest request,KycgPo kycgPo){
        BaseMessage message = new BaseMessage();
        try {
            if(kycgPo == null){
                message.setMessage("传入参数不合法");
                return message;
            }
            if (kycgPo.getShly() != null && !kycgPo.getShly().equals("")) {
                SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String shsj = simpleDate.format(new Date());
                kycgPo.setShsj(shsj);
                User user = (User) request.getSession().getAttribute("LoginMoldel");
                kycgPo.setSpr(user.getYhmc());
            }
            kycgService.updateByPrimaryKeySelective(kycgPo);
            message.setMessage("成果审核成功");
        }catch (Exception e){
            logger.error("成果审核失败",e);
            message.setMessage("成果审核失败");
        }
        return message;
    }

    @RequestMapping(value = "/getKyjfPageInfo",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult<KycgPo> getKyjfPageInfo(BaseQuery query){
        BaseResult<KycgPo> result = new BaseResult<KycgPo>();
        try {
            if(query == null){
                throw new Exception("传入参数不合法");
            }
            if ("-1".equals(query.getShzt())) {
                query.setShzt(null);
            }
            result = kycgService.getKymxPageInfo(query);
        }catch (Exception e){
            logger.error("科研成果列表查询失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/getKyjfShPageInfo",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult<KycgPo> getKyjfShPageInfo(BaseQuery query){
        BaseResult<KycgPo> result = new BaseResult<KycgPo>();
        try {
            if(query == null){
                throw new Exception("传入参数不合法");
            }
            if (query.getShzt() == null) {
                query.setShzt("0");
            }
            if ("-1".equals(query.getShzt())) {
                query.setShzt(null);
            }
            result = kycgService.getKymxPageInfo(query);
        }catch (Exception e){
            logger.error("科研成果列表查询失败");
            e.printStackTrace();
        }
        return result;
    }


    private void uploadFile(String pathString,KycgPo kycgPo,CommonsMultipartFile[]  files) throws Exception {
        //上传文件保存位置
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
            if (!newFile.exists()) {
                files[i].transferTo(newFile);
            }
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
        }
        if (listfie != null && listfie.size()>0) {
            myFileService.insertByBatch(listfie);
        }
    }


    @RequestMapping(value = "/getCgListByCjr",method = RequestMethod.POST)
    @ResponseBody
    public List<KycgPo> getCgListByCjr(HttpServletRequest request,String xmlsh){
        BaseQuery query = new BaseQuery();
        User user = (User) request.getSession().getAttribute("LoginMoldel");
        query.setCjr(user.getYhmc());
        query.setPage(0);
        query.setRows(100);
        List<KycgPo> list = kycgService.getCgListByCjr(query);
        query.setXmlsh(xmlsh);
        BaseResult<XmcgglVo> result = xmcgglService.getPageInfo(query);
        if (list == null || list.size()<=0) {
            list = new ArrayList<KycgPo>();
        }
        return list;
    }

}
