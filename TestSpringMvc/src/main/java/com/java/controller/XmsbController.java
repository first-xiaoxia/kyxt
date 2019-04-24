package com.java.controller;

import com.java.entity.commons.BaseQuery;
import com.java.entity.commons.BaseResult;
import com.java.entity.kyxm.XmsbPo;
import com.java.service.XmsbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/xmsb")
public class XmsbController {

    private static Logger logger = LoggerFactory.getLogger(XmsbController.class);

    @Autowired
    private XmsbService xmsbService;

    @RequestMapping(value = "/selectByKey",method = RequestMethod.GET)
    public XmsbPo selectXmsbByPrimaryKey(String xmlsh){
        XmsbPo xmsbPo = new XmsbPo();
        try {
            if(xmlsh == null || xmlsh.equals("")){
                throw new Exception("传入参数不合法");
            }
            xmsbPo = xmsbService.selectXmsbByPrimaryKey(xmlsh);
        }catch (Exception e){
            logger.error("查询项目申报失败");
            e.printStackTrace();
        }
        return xmsbPo;
    }

    @RequestMapping(value = "/deleteByKey",method = RequestMethod.GET)
    public void deleteByPrimaryKey(String xmlsh){
        try {
            if(xmlsh == null || xmlsh.equals("")){
                throw new Exception("传入参数不合法");
            }
            xmsbService.deleteByPrimaryKey(xmlsh);
        }catch (Exception e){
            logger.error("删除项目申报失败");
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public XmsbPo add(XmsbPo xmsbPo){
        try {
            if(xmsbPo == null){
                throw new Exception("传入参数不合法");
            }
            xmsbService.insertSelective(xmsbPo);
        }catch (Exception e){
            logger.error("删除项目申报失败");
            e.printStackTrace();
        }
        String uuid = UUID.randomUUID().toString();
        return xmsbPo;
    }


    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public XmsbPo update(XmsbPo xmsbPo){
        try {
            if(xmsbPo == null){
                throw new Exception("传入参数不合法");
            }
            xmsbService.updateByPrimaryKeySelective(xmsbPo);
        }catch (Exception e){
            logger.error("删除项目申报失败");
            e.printStackTrace();
        }
        return xmsbPo;
    }

    @RequestMapping(value = "/getKymxPageInfo",method = RequestMethod.GET)
    @ResponseBody
    public BaseResult<XmsbPo> getKymxPageInfo(BaseQuery query){
        BaseResult<XmsbPo> baseQuery = new BaseResult<XmsbPo>();
        try {
            if(query == null){
                throw new Exception("传入参数不合法");
            }
            xmsbService.getKymxPageInfo(query);
        }catch (Exception e){
            logger.error("科研项目列表查询失败");
            e.printStackTrace();
        }
        return baseQuery;
    }



}
