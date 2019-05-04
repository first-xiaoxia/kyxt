package com.java.controller;

import com.java.entity.KhbzPo;
import com.java.entity.KycgPo;
import com.java.entity.XmcgglPo;
import com.java.entity.commons.BaseMessage;
import com.java.entity.commons.BaseQuery;
import com.java.entity.commons.BaseResult;
import com.java.entity.kyxm.XmsbPo;
import com.java.entity.user.User;
import com.java.entity.vo.XmcgglVo;
import com.java.service.KhbzService;
import com.java.service.KycgService;
import com.java.service.XmcgglService;
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
@RequestMapping("/xmcggl")
public class XmcgglController {
    private  Logger logger = LoggerFactory.getLogger(XmcgglController.class);

    @Autowired
    private XmcgglService xmcgglService;

    @Autowired
    private KycgService kycgService;

    @Autowired
    private XmsbService xmsbService;

    @RequestMapping(value = "/deleteByKey",method = RequestMethod.GET)
    public BaseMessage deleteByPrimaryKey(String bh){
        BaseMessage message = new BaseMessage();
        try {
            if(bh == null || bh.equals("")){
                message.setMessage("传入参数不合法");
                return message;
            }
            xmcgglService.deleteByPrimaryKey(bh);
        }catch (Exception e){
            logger.error("删除数据失败",e);
           message.setMessage("删除数据失败");
        }
        message.setMessage("删除该条数据成功");
        return message;
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public BaseMessage add(String xmlsh,String cglsh){
        BaseMessage message = new BaseMessage();
        try {
            if(xmlsh == null || xmlsh.equals("") || xmlsh == null || xmlsh.equals("") ){
                message.setMessage("传入参数不合法");
                return message;
            }
            String uuid = UUID.randomUUID().toString().replace("-","");
            XmcgglPo xmcgglPo = new XmcgglPo();
            xmcgglPo.setBh(uuid);
            xmcgglPo.setCglsh(cglsh);
            xmcgglPo.setXmlsh(xmlsh);
            XmsbPo xmsbPo = xmsbService.selectXmsbByPrimaryKey(xmlsh);
            KycgPo kycgPo = kycgService.selectXmsbByPrimaryKey(cglsh);
            xmcgglPo.setXmmc(xmsbPo.getXmmc());
            xmcgglPo.setCgmc(kycgPo.getCgmc());
            xmcgglService.insertKyjf(xmcgglPo);
        }catch (Exception e){
            logger.error("删除数据失败",e);
            message.setMessage("删除数据失败");
        }
        message.setMessage("删除该条数据成功");
        return message;
    }


    @RequestMapping(value = "/getKyjfPageInfo",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult<XmcgglVo> getKyjfPageInfo(BaseQuery query){
        BaseResult<XmcgglVo> result = new BaseResult<XmcgglVo>();
        try {
            if(query == null){
                throw new Exception("传入参数不合法");
            }
            if ("-1".equals(query.getShzt())) {
                query.setShzt(null);
            }
            result = xmcgglService.getPageInfo(query);
        }catch (Exception e){
            logger.error("查询列表失败");
            e.printStackTrace();
        }
        return result;
    }


}
