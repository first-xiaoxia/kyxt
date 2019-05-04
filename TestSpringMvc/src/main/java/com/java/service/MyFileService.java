package com.java.service;

import com.java.dao.FileDao;
import com.java.entity.KycgPo;
import com.java.entity.MyFileUpload;
import com.java.entity.commons.BaseQuery;
import com.java.entity.commons.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyFileService {

    @Autowired
    private FileDao fileDao;

   public MyFileUpload selectXmsbByPrimaryKey(String wjlsh) throws  Exception{
       MyFileUpload myFile = new MyFileUpload();
       myFile = fileDao.selectXmsbByPrimaryKey(wjlsh);
       return myFile;
   }

    public void  deleteByPrimaryKey(String wjlsh)throws  Exception{
        fileDao.deleteByPrimaryKey(wjlsh);
    }

    public void insertKyjf(MyFileUpload myFile)throws Exception{
        fileDao.insertKyjf(myFile);
    }

    public List<MyFileUpload> get(BaseQuery query) throws Exception{
        return fileDao.getKyjfList(query);
    }


    public void insertByBatch(List<MyFileUpload> list) throws Exception{
        fileDao.insertByBatch(list);
    }

    public BaseResult<MyFileUpload> getPageInfo(BaseQuery query){
        BaseResult<MyFileUpload> result = new BaseResult<MyFileUpload>();
        List<MyFileUpload> rows = fileDao.getKyjfList(query);
        Integer total = fileDao.getCount(query);
        result.setRows(rows);
        result.setTotal(total);
        return result;
    }

}
