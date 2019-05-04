package com.java.dao;

import com.java.entity.KhbzPo;
import com.java.entity.XmcgglPo;
import com.java.entity.commons.BaseQuery;
import com.java.entity.vo.XmcgglVo;

import java.util.List;

public interface XmcgglDao {
    XmcgglPo selectXmsbByPrimaryKey(String bh);

    List<XmcgglVo> getKyjfList(BaseQuery query);

    Integer getCount(BaseQuery query);

    void deleteByPrimaryKey(String bh);

    void insertKyjf(XmcgglPo xmcgglPo);

    void updateByPrimaryKeySelective(XmcgglPo xmcgglPo);
}
