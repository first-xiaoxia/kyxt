package com.java.dao;

import com.java.entity.KyjfPo;
import com.java.entity.commons.BaseQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KyjfDao {
    KyjfPo selectXmsbByPrimaryKey(String jflsh);

    List<KyjfPo> getKyjfList(BaseQuery query);

    Integer getCount(BaseQuery query);

    void deleteByPrimaryKey(String jflsh);

    void insertKyjf(KyjfPo kyjfPo);

    void updateByPrimaryKeySelective (KyjfPo kyjfPo);
}
