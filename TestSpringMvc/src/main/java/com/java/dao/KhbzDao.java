package com.java.dao;

import com.java.entity.KhbzPo;
import com.java.entity.KycgPo;
import com.java.entity.MyFileUpload;
import com.java.entity.commons.BaseQuery;

import java.util.List;

public interface KhbzDao {
    KhbzPo selectXmsbByPrimaryKey(String bzlsh);

    List<KhbzPo> getKyjfList(BaseQuery query);

    Integer getCount(BaseQuery query);

    void deleteByPrimaryKey(String bzlsh);

    void insertKyjf(KhbzPo khbzPo);

    void updateByPrimaryKeySelective(KhbzPo khbzPo);
}
