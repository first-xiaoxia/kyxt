package com.java.service;

import com.java.dao.KyjfDao;
import com.java.entity.KyjfPo;
import com.java.entity.MyFileUpload;
import com.java.entity.commons.BaseQuery;
import com.java.entity.commons.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class KyjfService {

    @Autowired
    private KyjfDao kyjfDao;

   public KyjfPo selectXmsbByPrimaryKey(String jflsh) throws  Exception{
       KyjfPo kyjfPo = new KyjfPo();
       kyjfPo = kyjfDao.selectXmsbByPrimaryKey(jflsh);
       return kyjfPo;
   }

    public void  deleteByPrimaryKey(String jflsh)throws  Exception{
       kyjfDao.deleteByPrimaryKey(jflsh);
    }

    public void insertKyjf(KyjfPo kyjfPo)throws Exception{
       kyjfDao.insertKyjf(kyjfPo);
    }

    public void updateByPrimaryKeySelective(KyjfPo kyjfPo) throws Exception{
       kyjfDao.updateByPrimaryKeySelective(kyjfPo);
    }

    public BaseResult<KyjfPo> getKymxPageInfo(BaseQuery query){
        BaseResult<KyjfPo> result = new BaseResult<KyjfPo>();
        List<KyjfPo> rows = kyjfDao.getKyjfList(query);
        Integer total = kyjfDao.getCount(query);
        result.setRows(rows);
        result.setTotal(total);
        return result;
    }

}
