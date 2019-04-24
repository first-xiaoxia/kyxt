package com.java.service;

import com.java.dao.XmsbDao;
import com.java.entity.commons.BaseQuery;
import com.java.entity.commons.BaseResult;
import com.java.entity.kyxm.XmsbPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XmsbService {

    @Autowired
    private XmsbDao xmsbDao;

   public XmsbPo selectXmsbByPrimaryKey(String xmlsh) throws  Exception{
       XmsbPo xmsbPo = new XmsbPo();
       xmsbPo = xmsbDao.selectXmsbByPrimaryKey(xmlsh);
       return xmsbPo;
   }

    public void  deleteByPrimaryKey(String xmlsh)throws  Exception{
       xmsbDao.deleteByPrimaryKey(xmlsh);
    }

    public void insertSelective(XmsbPo xmsbPo)throws Exception{
        xmsbDao.insertSelective(xmsbPo);
    }

    public void updateByPrimaryKeySelective(XmsbPo xmsbPo) throws Exception{
       xmsbDao.updateByPrimaryKeySelective(xmsbPo);
    }

    public BaseResult<XmsbPo> getKymxPageInfo(BaseQuery query){
        BaseResult<XmsbPo> result = new BaseResult<XmsbPo>();
        List<XmsbPo> rows = xmsbDao.getKyxmList(query);
        Integer total = xmsbDao.getCount(query);
        result.setRows(rows);
        result.setTotal(total);
        return result;
    }
}
