package com.java.dao;

import com.java.entity.MyFileUpload;
import com.java.entity.commons.BaseQuery;

import java.util.List;

public interface FileDao {
    MyFileUpload selectXmsbByPrimaryKey(String wjlsh);

    List<MyFileUpload> getKyjfList(BaseQuery query);

    Integer getCount(BaseQuery query);

    void deleteByPrimaryKey(String cglsh);

    void insertKyjf(MyFileUpload file);

    void insertByBatch(List<MyFileUpload> list);
}
