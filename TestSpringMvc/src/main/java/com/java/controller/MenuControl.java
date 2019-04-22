package com.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.entity.MenuSort;
import com.java.service.MenuService;

@RestController
@RequestMapping("/menu/")
public class MenuControl {
	@Autowired
	private MenuService menuservice;
	
	/**
	 * 获得排序好的左边菜单的集合
	* @Title: getMenuList
	* @Description: 
	* @param @return    
	* @return List<MenuList>    
	* @throws
	* @author 倪军
	 */
	@RequestMapping("getMenu")
	public List<MenuSort> getMenuList(){
		List<MenuSort> list = new ArrayList<MenuSort>();
		list = this.menuservice.getMenus();
		return list;
	}

}
