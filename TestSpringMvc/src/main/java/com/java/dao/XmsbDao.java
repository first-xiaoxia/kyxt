package com.java.dao;

import com.java.entity.commons.BaseQuery;
import com.java.entity.kyxm.XmsbPo;

import java.util.List;

public interface XmsbDao {
    XmsbPo selectXmsbByPrimaryKey(String xmlsh);

    void  deleteByPrimaryKey(String xmlsh);

    void insertSelective(XmsbPo xmsbPo);

    void updateByPrimaryKeySelective(XmsbPo xmsbPo);

    List<XmsbPo> getKyxmList(BaseQuery query);

    List<XmsbPo> getList(BaseQuery query);

    Integer getCount(BaseQuery query);
}
