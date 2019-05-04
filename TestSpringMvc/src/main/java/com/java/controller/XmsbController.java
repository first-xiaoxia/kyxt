package com.java.controller;

import com.java.entity.commons.BaseMessage;
import com.java.entity.commons.BaseQuery;
import com.java.entity.commons.BaseResult;
import com.java.entity.kyxm.XmsbPo;
import com.java.entity.user.User;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
    public BaseMessage add(HttpServletRequest request,XmsbPo xmsbPo){
        BaseMessage message = new BaseMessage();
        try {
            if(xmsbPo == null){
                throw new Exception("传入参数不合法");
            }
            User user = (User) request.getSession().getAttribute("LoginMoldel");
            xmsbPo.setFzr(user.getYhmc());
            xmsbService.insertSelective(xmsbPo);
            message.setMessage("项目申报成功");
        }catch (Exception e){
            logger.error("新增项目申报失败",e);
            message.setMessage("新增项目申报失败");
        }
        return message;
    }


    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public BaseMessage update(XmsbPo xmsbPo){
        BaseMessage message = new BaseMessage();
        try {
            if(xmsbPo == null){
                message.setMessage("传入参数不合法");
                return message;
            }
            if (xmsbPo.getBz() != null && !xmsbPo.getBz().equals("")) {
                SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String zzsj = simpleDate.format(new Date());
                xmsbPo.setZzsj(zzsj);
                xmsbPo.setXmzt("2");
            }
            xmsbService.updateByPrimaryKeySelective(xmsbPo);
            message.setMessage("项目申报修改成功");
        }catch (Exception e){
            logger.error("项目申报修改失敗",e);
            message.setMessage("该项目修改失败");
        }
        return message;
    }

    @RequestMapping(value = "/updatesh",method = RequestMethod.POST)
    public BaseMessage updatesh(HttpServletRequest request,XmsbPo xmsbPo){
        BaseMessage message = new BaseMessage();
        try {
            if(xmsbPo == null){
                message.setMessage("传入参数不合法");
                return message;
            }
            if (xmsbPo.getBz() != null && !xmsbPo.getBz().equals("")) {
                SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String shsj = simpleDate.format(new Date());
                xmsbPo.setShsj(shsj);
                User user = (User) request.getSession().getAttribute("LoginMoldel");
                xmsbPo.setSpr(user.getYhmc());
            }
            xmsbService.updateByPrimaryKeySelective(xmsbPo);
            message.setMessage("项目申报修改成功");
        }catch (Exception e){
            logger.error("项目申报修改失敗",e);
            message.setMessage("该项目修改失败");
        }
        return message;
    }

    @RequestMapping(value = "/getKymxPageInfo",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult<XmsbPo> getKymxPageInfo(BaseQuery query){
        BaseResult<XmsbPo> result = new BaseResult<XmsbPo>();
        try {
            if(query == null){
                throw new Exception("传入参数不合法");
            }
            if ("0".equals(query.getXmxz())) {
                query.setXmxz("");
            }
            if ("0".equals(query.getXmzt())) {
                query.setXmzt("");
            }
            result = xmsbService.getKymxPageInfo(query);
        }catch (Exception e){
            logger.error("科研项目列表查询失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/getXmshPageInfo",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult<XmsbPo> getXmshPageInfo(BaseQuery query){
        BaseResult<XmsbPo> result = new BaseResult<XmsbPo>();
        try {
            if(query == null){
                throw new Exception("传入参数不合法");
            }
            if ("0".equals(query.getXmxz())) {
                query.setXmxz("");
            }
            if ("0".equals(query.getXmzt())) {
                query.setXmzt("");
            }
            if (query.getXmxz() == null){
                query.setXmzt("1");
            }
            result = xmsbService.getKymxPageInfo(query);
        }catch (Exception e){
            logger.error("科研项目列表查询失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/getXmshList",method = RequestMethod.POST)
    @ResponseBody
    public List<XmsbPo> getXmshList(HttpServletRequest request,BaseQuery query){
        List<XmsbPo> list = new ArrayList<XmsbPo>();
        try {
            if(query == null){
                throw new Exception("传入参数不合法");
            }
            User user = (User) request.getSession().getAttribute("LoginMoldel");
            query.setFzr(user.getYhmc());
            query.setXmzt("3");
            list = xmsbService.getXmshList(query);
        }catch (Exception e){
            logger.error("科研项目列表查询失败");
            e.printStackTrace();
        }
        return list;
    }



}
