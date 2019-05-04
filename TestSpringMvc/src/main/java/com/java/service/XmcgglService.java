package com.java.service;

import com.java.dao.XmcgglDao;
import com.java.entity.XmcgglPo;
import com.java.entity.commons.BaseQuery;
import com.java.entity.commons.BaseResult;
import com.java.entity.vo.XmcgglVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XmcgglService {

    @Autowired
    private XmcgglDao xmcgglDao;

   public XmcgglPo selectXmsbByPrimaryKey(String wjlsh) throws  Exception{
       XmcgglPo xmcgglPo = new XmcgglPo();
       xmcgglPo = xmcgglDao.selectXmsbByPrimaryKey(wjlsh);
       return xmcgglPo;
   }

    public void  deleteByPrimaryKey(String wjlsh)throws  Exception{
        xmcgglDao.deleteByPrimaryKey(wjlsh);
    }

    public void insertKyjf(XmcgglPo xmcgglPo)throws Exception{
        xmcgglDao.insertKyjf(xmcgglPo);
    }



    public  void update(XmcgglPo xmcgglPo) throws Exception{
        xmcgglDao.updateByPrimaryKeySelective(xmcgglPo);
    }



    public BaseResult<XmcgglVo> getPageInfo(BaseQuery query){
        BaseResult<XmcgglVo> result = new BaseResult<XmcgglVo>();
        List<XmcgglVo> rows = xmcgglDao.getKyjfList(query);
        Integer total = xmcgglDao.getCount(query);
        result.setRows(rows);
        result.setTotal(total);
        return result;
    }
}
