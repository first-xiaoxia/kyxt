package com.java.dao;

import com.java.entity.KycgPo;
import com.java.entity.KyjfPo;
import com.java.entity.commons.BaseQuery;

import java.util.List;

public interface KycgDao {
    KycgPo selectXmsbByPrimaryKey(String cglsh);

    List<KycgPo> getKyjfList(BaseQuery query);

    Integer getCount(BaseQuery query);

    void deleteByPrimaryKey(String cglsh);

    void insertKyjf(KycgPo kycgPo);

    void updateByPrimaryKeySelective(KycgPo kycgPo);
}
