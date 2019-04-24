package com.java.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.java.entity.commons.BaseMessage;
import com.java.entity.commons.BaseQuery;
import com.java.entity.commons.BaseResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.UserMapper;
import com.java.entity.LoginModel;
import com.java.entity.user.User;
@Service
public class IUserService {
	@Autowired
	private UserMapper iUserdaomapper;
	private static final Logger logger = Logger.getLogger(IUserService.class);
	
	/**
	 * 通过id查找user
	 * @param id
	 * @return
	 */
	public User getIUser(int id){
		return iUserdaomapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 获得所有的用户
	* @Title: getUsers
	* @Description: 
	* @param @return    
	* @return List<User>    
	* @throws
	* @author 倪军
	 */
	public String getUsers (HttpServletRequest request,LoginModel model){
		List<User> users = new ArrayList<User>();
		users = iUserdaomapper.getAll();//获取到数据库中的所有的用户
		for(User user:users){
			if(model.getName().equals(user.getUserName())&&model.getName()!=""
					&&model.getPassword().equals(user.getPassword())&&model.getPassword()!=""){//如果账号和密码相同
				request.getSession().setAttribute("LoginMoldel", user);
				return "1";
			}
		}
		
		return "0";
	}
	
	/**
	 * 
	* @Title: getInfo
	* @Description: 
	* @param @return    
	* @return List<User>    
	* @throws
	* @author 倪军
	 */
	public BaseResult<User> getInfo(BaseQuery query){
		BaseResult<User> baseQuery = new BaseResult<User>();
		List<User> rows = new ArrayList<User>();
		rows = iUserdaomapper.getUsers(query);//获取到数据库中的所有的用户
		int total = this.iUserdaomapper.getCount(query);
		baseQuery.setRows(rows);
		baseQuery.setTotal(total);
		return baseQuery;
	}

	/**
	 *
	*  @param user
	* @return BaseMessage
	* @author 倪军
	* @time 2017/3/16 11:35
	* @version 0.1
	* @sice 0.1
	*/
	public BaseMessage editUser(User user){
		BaseMessage message = new BaseMessage();
		int i = 1;
		try {
			i = this.iUserdaomapper.updateByPrimaryKeySelective(user);
		}catch (Exception e){
			logger.error("修改用户信息失败"+e);
			message.setMesscode(String.valueOf(i));
			message.setMessage("修改用户信息失败");
		}
		message.setMessage("修改用户信息成功");
		message.setMesscode(String.valueOf(i));
		return message;
	}

	/**
	 *
	 *  @param user
	 * @return BaseMessage
	 * @author 倪军
	 * @time 2017/3/16 11:35
	 * @version 0.1
	 * @sice 0.1
	 */
	public BaseMessage addUser(User user){
		BaseMessage message = new BaseMessage();
		int i = 1;
		try {
			i = this.iUserdaomapper.insertSelective(user);
		}catch (Exception e){
			logger.error("新增用户信息失败"+e);
			message.setMesscode(String.valueOf(i));
			message.setMessage("新增用户信息失败");
		}
		message.setMessage("新增用户信息成功");
		message.setMesscode(String.valueOf(i));
		return message;
	}
	/**
	 *
	 *  @param id
	 * @return BaseMessage
	 * @author 倪军
	 * @time 2017/3/16 11:35
	 * @version 0.1
	 * @sice 0.1
	 */
	public BaseMessage delUser(Integer id){
		BaseMessage message = new BaseMessage();
		int i = 1;
		try {
			i = this.iUserdaomapper.deleteByPrimaryKey(id);
		}catch (Exception e){
			logger.error("删除用户信息失败"+e);
			message.setMesscode(String.valueOf(i));
			message.setMessage("删除用户信息失败");
		}
		message.setMessage("删除用户信息成功");
		message.setMesscode(String.valueOf(i));
		return message;
	}
}
