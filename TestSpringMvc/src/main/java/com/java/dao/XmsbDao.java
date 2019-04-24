package com.java.dao;

import com.java.entity.XmsbPo;

public interface XmsbDao {
    XmsbPo selectXmsbByPrimaryKey(String xmlsh);

    void  deleteByPrimaryKey(String xmlsh);

    void insertSelective(XmsbPo xmsbPo);

    void updateByPrimaryKeySelective(XmsbPo xmsbPo);
}
