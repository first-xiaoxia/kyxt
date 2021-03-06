package com.java.service;

import com.java.dao.OrganiseUnitDao;
import com.java.entity.OrganiseUnit;
import com.java.entity.commons.BaseMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrganiseUnitService {

    @Autowired
    private OrganiseUnitDao organiseUnitDao;
    private static final Logger logger = Logger.getLogger(OrganiseUnitService.class);

    /**
     *
     * @Title: getInfo
     * @Description:
     * @param @return
     * @return List<User>
     * @throws
     * @author 倪军
     */
    public List<OrganiseUnit> getInfo(OrganiseUnit organiseUnit){
        List<OrganiseUnit> organiseUnits = new ArrayList<OrganiseUnit>();
        organiseUnits = organiseUnitDao.getOrganiseUnit(organiseUnit);//获取到数据库中的所有的组织机构
        return organiseUnits;
    }

    /**
     * 通过id查找组织机构
     * @param id
     * @return
     */
    public OrganiseUnit getOrganiseUnit(int id){
        return organiseUnitDao.selectByPrimaryKey(id);
    }

    /**
     * 新增组织机构
     * @param organiseUnit
     * @return
     */
    public BaseMessage addOrganiseUnit(OrganiseUnit organiseUnit){
        BaseMessage message = new BaseMessage();
        int i = 1;
        try {
            i = this.organiseUnitDao.insert(organiseUnit);
        }catch (Exception e){
            logger.error("新增组织机构信息失败"+e);
            message.setMesscode(String.valueOf(i));
            message.setMessage("新增组织机构信息失败");
        }
        message.setMessage("新增组织机构信息成功");
        message.setMesscode(String.valueOf(i));
        return message;
    }
}
