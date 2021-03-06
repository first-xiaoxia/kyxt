package com.java.service;

import com.java.dao.XmsbDao;
import com.java.entity.commons.BaseQuery;
import com.java.entity.commons.BaseResult;
import com.java.entity.kyxm.XmsbPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
       String uuid = UUID.randomUUID().toString().replace("-","");
       SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String cjsj = simpleDate.format(new Date());
       xmsbPo.setCjsj(cjsj);
       xmsbPo.setXmlsh(uuid);
       xmsbPo.setXmzt("1");
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

    public List<XmsbPo> getXmshList(BaseQuery query){
        List<XmsbPo> list = xmsbDao.getList(query);
        return list;
    }
}
