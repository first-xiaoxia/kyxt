package com.java.controller;

import com.java.entity.OrganiseUnit;
import com.java.entity.commons.BaseMessage;
import com.java.service.OrganiseUnitService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/organiseUnit")
@Api
public class OrganiseUnitController {
    private static Logger logger = LoggerFactory.getLogger(OrganiseUnitController.class);
    @Autowired
    private OrganiseUnitService organiseUnitService;

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
