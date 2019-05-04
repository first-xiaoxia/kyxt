package com.java.service;

import com.java.dao.KycgDao;
import com.java.dao.KyjfDao;
import com.java.entity.KycgPo;
import com.java.entity.KyjfPo;
import com.java.entity.MyFileUpload;
import com.java.entity.commons.BaseQuery;
import com.java.entity.commons.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KycgService {

    @Autowired
    private KycgDao kycgDao;

   public KycgPo selectXmsbByPrimaryKey(String cglsh) throws  Exception{
       KycgPo kycgPo = new KycgPo();
       kycgPo = kycgDao.selectXmsbByPrimaryKey(cglsh);
       return kycgPo;
   }

    public void  deleteByPrimaryKey(String cglsh)throws  Exception{
        kycgDao.deleteByPrimaryKey(cglsh);
    }

    public void insertKyjf(KycgPo kycgPo)throws Exception{
        kycgDao.insertKyjf(kycgPo);
    }

    public void updateByPrimaryKeySelective(KycgPo kycgPo) throws Exception{
        kycgDao.updateByPrimaryKeySelective(kycgPo);
    }

    public BaseResult<KycgPo> getKymxPageInfo(BaseQuery query){
        BaseResult<KycgPo> result = new BaseResult<KycgPo>();
        List<KycgPo> rows = kycgDao.getKyjfList(query);
        Integer total = kycgDao.getCount(query);
        result.setRows(rows);
        result.setTotal(total);
        return result;
    }

    public List<KycgPo> getCgListByCjr(BaseQuery query){
        List<KycgPo> rows = kycgDao.getKyjfList(query);
        return rows;
    }
}
