package com.java.dao;

import com.java.entity.OrganiseUnit;

import java.util.List;

public interface OrganiseUnitDao {
    int deleteByPrimaryKey(Integer id);

    int insert(OrganiseUnit organiseUnit);

    OrganiseUnit selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(OrganiseUnit organiseUnit);

    /**
     * 获得所有组织机构
     * @param organiseUnit
     * @return
     */
    List<OrganiseUnit> getOrganiseUnit(OrganiseUnit organiseUnit);
}
