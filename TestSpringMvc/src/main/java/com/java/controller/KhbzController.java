package com.java.controller;

import com.java.entity.KhbzPo;
import com.java.entity.commons.BaseMessage;
import com.java.entity.commons.BaseQuery;
import com.java.entity.commons.BaseResult;
import com.java.entity.user.User;
import com.java.service.KhbzService;
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
@RequestMapping("/khbz")
public class KhbzController {
    private static Logger logger = LoggerFactory.getLogger(KhbzController.class);

    @Autowired
    private KhbzService khbzService;


    @RequestMapping(value = "/selectByKey",method = RequestMethod.GET)
    public KhbzPo selectXmsbByPrimaryKey(String xmlsh){
        KhbzPo kycgPo = new KhbzPo();
        try {
            if(xmlsh == null || xmlsh.equals("")){
                throw new Exception("传入参数不合法");
            }
            kycgPo = khbzService.selectXmsbByPrimaryKey(xmlsh);
        }catch (Exception e){
            logger.error("查询考核标准");
            e.printStackTrace();
        }
        return kycgPo;
    }

    @RequestMapping(value = "/deleteByKey",method = RequestMethod.GET)
    public BaseMessage deleteByPrimaryKey(String bzlsh){
        BaseMessage message = new BaseMessage();
        try {
            if(bzlsh == null || bzlsh.equals("")){
                message.setMessage("传入参数不合法");
                return message;
            }
            khbzService.deleteByPrimaryKey(bzlsh);
        }catch (Exception e){
            logger.error("删除数据失败",e);
           message.setMessage("删除数据失败");
        }
        message.setMessage("删除该条数据成功");
        return message;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public BaseMessage add(HttpServletRequest request,KhbzPo khbzPo){
        BaseMessage message = new BaseMessage();
        try {
            if(khbzPo == null){
                message.setMessage("传入参数不合法");
                return message;
            }
            String uuid = UUID.randomUUID().toString().replace("-","");
            khbzPo.setBzlsh(uuid);
            //业务数据
            User user = (User) request.getSession().getAttribute("LoginMoldel");
            khbzPo.setCjr(user.getYhmc());
            SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String cjsj = simpleDate.format(new Date());
            khbzPo.setCjsj(cjsj);
            khbzService.insertKyjf(khbzPo);
        }catch (Exception e){
            logger.error("新增数据失败",e);
            message.setMessage("新增数据失败");
        }
        message.setMessage("新增数据成功");
        return message;
    }


    @RequestMapping(value = "/update",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public BaseMessage update(HttpServletRequest request, KhbzPo khbzPo){
        BaseMessage message = new BaseMessage();
        try {
            if(khbzPo == null){
                message.setMessage("传入参数不合法");
                return message;
            }
            //业务数据修改
            khbzService.update(khbzPo);
            message.setMessage("修改成功");
        }catch (Exception e){
            logger.error("修改数据失败",e);
            message.setMessage("修改数据失败");
        }
        message.setMessage("修改数据成功");
        return message;
    }


    @RequestMapping(value = "/getKyjfPageInfo",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult<KhbzPo> getKyjfPageInfo(BaseQuery query){
        BaseResult<KhbzPo> result = new BaseResult<KhbzPo>();
        try {
            if(query == null){
                throw new Exception("传入参数不合法");
            }
            if ("-1".equals(query.getShzt())) {
                query.setShzt(null);
            }
            result = khbzService.getPageInfo(query);
        }catch (Exception e){
            logger.error("查询列表失败");
            e.printStackTrace();
        }
        return result;
    }


}
