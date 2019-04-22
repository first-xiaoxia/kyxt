package com.java.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.java.dao.MenuDao;
import com.java.entity.LoginModel;
import com.java.entity.Menu;
import com.java.entity.MenuSort;
import com.java.entity.User;

@Service
public class MenuService {
	
	@Autowired
	private MenuDao menuDao;
	
	/**
	 * 获得排序好的左边菜单的集合
	* @Title: getMenus
	* @Description: 
	* @param @return    
	* @return List<MenuList>    
	* @throws
	* @author 倪军
	 */
	public List<MenuSort> getMenus(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		User loginmodel = (User)request.getSession().getAttribute("LoginMoldel");
		int roleId = loginmodel.getUserType();//获得登陆的用户的角色类型
		
		List<MenuSort> MenuList = new ArrayList<MenuSort>();//接收排序后的菜单集合
		List<Menu> menus = new ArrayList<Menu>();//根据不同角色获得排序前的菜单集合
		menus = this.menuDao.getMenus(roleId);
		for(Menu menu:menus){
			if(menu.getParentId()==0){
				MenuSort menusort = new MenuSort();
				menusort.setId(menu.getId());
				menusort.setText(menu.getName()==null?"":menu.getName());
				menusort.setUrl(menu.getUrl()==null?"":menu.getUrl());
				menusort.setDisployOrder(menu.getDisployOrder());
				menusort.setLeaf(menu.getHasLeaf()==0?false:true);
				MenuList.add(menusort);
				loanLeaf(menus,menusort);//对每个父节点匹配子节点
			}
		}
		return MenuList;
	}
	
	/**
	 * 对每个父节点匹配子节点
	* @Title: loanLeaf
	* @Description: 
	* @param @param MenuList
	* @param @param menu    
	* @return void    
	* @throws
	* @author 倪军
	 */
	public void loanLeaf(List<Menu> menus,MenuSort menusort){
		if(menusort.isLeaf()){//如果该节点包含子节点
			menusort.setState("closed");
			List<MenuSort> menusortlist = new ArrayList<MenuSort>();
			for(Menu menu:menus){
				if(menusort.getId() == menu.getParentId()){//如果该节点的id为某个节点的父节点id
					MenuSort menusort1 = new MenuSort();
					menusort1.setId(menu.getId());
					menusort1.setText(menu.getName()==null?"":menu.getName());
					menusort1.setUrl(menu.getUrl()==null?"":menu.getUrl());
					menusort1.setLeaf(menu.getHasLeaf()==0?false:true);
					menusort1.setParentId(menu.getParentId());
					menusort1.setParentName(menu.getParentName());
					menusort1.setDisployOrder(menu.getDisployOrder());
					menusort1.setMemo(menu.getMemo());
					menusortlist.add(menusort1);
					loanLeaf(menus,menusort1);
				}
			}
			if(menusortlist.size()!=0){//如果存在子节点
				menusort.setChildren(menusortlist);
			}
		}
	}

}
