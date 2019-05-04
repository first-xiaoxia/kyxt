package com.java.controller;

import com.java.entity.KyjfPo;
import com.java.entity.commons.BaseMessage;
import com.java.entity.commons.BaseQuery;
import com.java.entity.commons.BaseResult;
import com.java.entity.kyxm.XmsbPo;
import com.java.entity.user.User;
import com.java.service.KyjfService;
import com.java.service.XmsbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


@RestController
@RequestMapping("/kyjf")
public class KyjfController {

    private static Logger logger = LoggerFactory.getLogger(KyjfController.class);

    @Autowired
    private KyjfService kyjfService;

    @RequestMapping(value = "/selectByKey",method = RequestMethod.GET)
    public KyjfPo selectXmsbByPrimaryKey(String xmlsh){
        KyjfPo kyjfPo = new KyjfPo();
        try {
            if(xmlsh == null || xmlsh.equals("")){
                throw new Exception("传入参数不合法");
            }
            kyjfPo = kyjfService.selectXmsbByPrimaryKey(xmlsh);
        }catch (Exception e){
            logger.error("查询科研经费失败");
            e.printStackTrace();
        }
        return kyjfPo;
    }

    @RequestMapping(value = "/deleteByKey",method = RequestMethod.GET)
    public BaseMessage deleteByPrimaryKey(String jflsh){
        BaseMessage message = new BaseMessage();
        try {
            if(jflsh == null || jflsh.equals("")){
                message.setMessage("传入参数不合法");
                return message;
            }
            kyjfService.deleteByPrimaryKey(jflsh);
        }catch (Exception e){
            logger.error("删除经费数据失败",e);
           message.setMessage("删除经费数据失败");
        }
        message.setMessage("删除该条数据成功");
        return message;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public BaseMessage add(HttpServletRequest request,KyjfPo kyjfPo){
        BaseMessage message = new BaseMessage();
        try {
            if(kyjfPo == null){
                throw new Exception("传入参数不合法");
            }
            User user = (User) request.getSession().getAttribute("LoginMoldel");
            kyjfPo.setCjr(user.getYhmc());
            String uuid = UUID.randomUUID().toString().replace("-","");
            SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String cjsj = simpleDate.format(new Date());
            kyjfPo.setCjsj(cjsj);
            kyjfPo.setJflsh(uuid);
            kyjfPo.setShzt("0");
            kyjfService.insertKyjf(kyjfPo);
            message.setMessage("经费申请成功");
        }catch (Exception e){
            logger.error("经费申请失败",e);
            message.setMessage("经费申请失败");
        }
        return message;
    }


    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public BaseMessage update(KyjfPo kyjfPo){
        BaseMessage message = new BaseMessage();
        try {
            if(kyjfPo == null){
                message.setMessage("传入参数不合法");
                return message;
            }
            kyjfService.updateByPrimaryKeySelective(kyjfPo);
            message.setMessage("修改成功");
        }catch (Exception e){
            logger.error("项目申报修改失敗",e);
            message.setMessage("该项目修改失败");
        }
        return message;
    }

    @RequestMapping(value = "/updatesh",method = RequestMethod.POST)
    public BaseMessage updatesh(HttpServletRequest request,KyjfPo kyjfPo){
        BaseMessage message = new BaseMessage();
        try {
            if(kyjfPo == null){
                message.setMessage("传入参数不合法");
                return message;
            }
            if (kyjfPo.getShly() != null && !kyjfPo.getShly().equals("")) {
                SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String shsj = simpleDate.format(new Date());
                kyjfPo.setShsj(shsj);
                User user = (User) request.getSession().getAttribute("LoginMoldel");
                kyjfPo.setSpr(user.getYhmc());
            }
            kyjfService.updateByPrimaryKeySelective(kyjfPo);
            message.setMessage("经费修改成功");
        }catch (Exception e){
            logger.error("经费修改失敗",e);
            message.setMessage("经费修改失敗");
        }
        return message;
    }

    @RequestMapping(value = "/getKyjfPageInfo",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult<KyjfPo> getKyjfPageInfo(BaseQuery query){
        BaseResult<KyjfPo> result = new BaseResult<KyjfPo>();
        try {
            if(query == null){
                throw new Exception("传入参数不合法");
            }
            result = kyjfService.getKymxPageInfo(query);
        }catch (Exception e){
            logger.error("科研项目列表查询失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/getKyjfShPageInfo",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult<KyjfPo> getKyjfShPageInfo(BaseQuery query){
        BaseResult<KyjfPo> result = new BaseResult<KyjfPo>();
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
            result = kyjfService.getKymxPageInfo(query);
        }catch (Exception e){
            logger.error("科研项目列表查询失败");
            e.printStackTrace();
        }
        return result;
    }





}
