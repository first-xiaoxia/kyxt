package com.java.service;

import com.java.dao.XmsbDao;
import com.java.entity.XmsbPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
