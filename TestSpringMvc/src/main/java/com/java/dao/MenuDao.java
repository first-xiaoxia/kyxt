package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.java.entity.Menu;

public interface MenuDao {
	
	/**
	 * 获得排序前的菜单集合
	* @Title: getMenus
	* @Description: 
	* @param @return    
	* @return List<Menu>    
	* @throws
	* @author 倪军
	 */
	List<Menu> getMenus(@Param("roleId") int roleId);

}
