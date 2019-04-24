package com.java.controller;

import com.java.entity.OrganiseUnit;
import com.java.entity.commons.BaseQuery;
import com.java.service.OrganiseUnitService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/organiseUnit")
@Api
public class OrganiseUnitController {
    private static Logger logger = LoggerFactory.getLogger(OrganiseUnitController.class);
    @Autowired
    private OrganiseUnitService organiseUnitService;

    /**
     *
     * @Title: getInfo
     * @Description:
     * @param @return
     * @return BaseQuery<OrganiseUnit>
     * @throws
     * @author 谭文
     */
    @RequestMapping(value = "/getInfo",method = RequestMethod.POST)
    @ResponseBody
    public BaseQuery<OrganiseUnit> getInfo(OrganiseUnit organiseUnit){
        /*if("--请选择--".equals(organiseUnit.getJslb())) {
            user.setJslb("");
        }*/
        BaseQuery<OrganiseUnit> result = new BaseQuery<OrganiseUnit>();
        List<OrganiseUnit> list = organiseUnitService.getInfo(organiseUnit);
        int total = list.size();
        result.setRows(list);
        result.setTotal(total);
        return result;
    }

    /**
     *
     *  @param organiseUnit
     * @return BaseMessage
     * @author 谭文
     * @time 2019/4/23 01:34
     * @version 0.1
     * @sice 0.1
     */
    @RequestMapping(value = "/addOrganiseUnit", method = RequestMethod.POST)
    @ResponseBody
    public BaseMessage addOrganiseUnit(OrganiseUnit organiseUnit){
        BaseMessage message = new BaseMessage();
        message = this.organiseUnitService.addOrganiseUnit(organiseUnit);
        return message;
    }
}
