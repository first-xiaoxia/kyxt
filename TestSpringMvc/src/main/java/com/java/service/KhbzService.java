package com.java.service;

import com.java.dao.FileDao;
import com.java.dao.KhbzDao;
import com.java.entity.KhbzPo;
import com.java.entity.commons.BaseQuery;
import com.java.entity.commons.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhbzService {

    @Autowired
    private KhbzDao khbzDao;

   public KhbzPo selectXmsbByPrimaryKey(String wjlsh) throws  Exception{
       KhbzPo khbzPo = new KhbzPo();
       khbzPo = khbzDao.selectXmsbByPrimaryKey(wjlsh);
       return khbzPo;
   }

    public void  deleteByPrimaryKey(String wjlsh)throws  Exception{
        khbzDao.deleteByPrimaryKey(wjlsh);
    }

    public void insertKyjf(KhbzPo khbzPo)throws Exception{
        khbzDao.insertKyjf(khbzPo);
    }

    public List<KhbzPo> get(BaseQuery query) throws Exception{
        return khbzDao.getKyjfList(query);
    }

    public  void update(KhbzPo khbzPo) throws Exception{
       khbzDao.updateByPrimaryKeySelective(khbzPo);
    }



    public BaseResult<KhbzPo> getPageInfo(BaseQuery query){
        BaseResult<KhbzPo> result = new BaseResult<KhbzPo>();
        List<KhbzPo> rows = khbzDao.getKyjfList(query);
        Integer total = khbzDao.getCount(query);
        result.setRows(rows);
        result.setTotal(total);
        return result;
    }
}
