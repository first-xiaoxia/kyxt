package com.java.controller;

import com.java.entity.commons.BaseMessage;
import com.java.entity.commons.BaseQuery;
import com.java.entity.LoginModel;
import com.java.entity.user.User;
import com.java.entity.user.UserQeury;
import com.java.service.IUserService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
@Api
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService iuserservice;
      
     /**
      * user/test?id=1
      * @param request
      * @param model
      * @return
      */
    @RequestMapping(value="/test",method=RequestMethod.GET)
    @ResponseBody
    public String test(HttpServletRequest request,Model model){
        int userId = Integer.parseInt(request.getParameter("id"));  
        System.out.println("userId:"+userId);
        User user=null;
        if (userId==1) {
             user = new User();
             user.setId(1);
             user.setPassword("123");
             user.setUserName("javen");
        }
        model.addAttribute("user", user);  
        return "index";  
    }  
    
    /**
     * user/{id}
     * @param id
     * @return
     */
    @RequestMapping(value="/getUnser",method=RequestMethod.GET)  
    public @ResponseBody User getUserInJson(@RequestParam String id){  
        int userId = Integer.parseInt(id);  
        System.out.println("userId:"+userId);
        User user = this.iuserservice.getIUser(userId);
        logger.info(user.toString());
        return user;  
    }
    
    /**
     * 
    * @Title: login
    * @Description: 
    * @param @param model
    * @param @return    
    * @return LoginModel    
    * @throws
    * @author 倪军
     */
    @RequestMapping(value="/login",method=RequestMethod.POST)
    @ResponseBody
    public String login(HttpServletRequest request,LoginModel model){
       return  iuserservice.getUsers(request,model);

    }
    
    /**
     * 
    * @Title: getInfo
    * @Description: 
    * @param @return    
    * @return BaseQuery<User>    
    * @throws
    * @author 倪军
     */
    @RequestMapping(value = "/getInfo",method = RequestMethod.POST)
    @ResponseBody
    public BaseQuery<User> getInfo(UserQeury userQeury){
        if("--请选择--".equals(userQeury.getJslb())) {
            userQeury.setJslb("");
        }
    	BaseQuery<User> result = new BaseQuery<User>();
    	return iuserservice.getInfo(userQeury);
    }

   /**
    *
   *  @param user
   * @return BaseMessage
   * @author 倪军
   * @time 2017/3/16 11:34
   * @version 0.1
   * @sice 0.1
   */
    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    @ResponseBody
    public BaseMessage editUser(User user){
        BaseMessage message = new BaseMessage();
        message = this.iuserservice.editUser(user);
        return message;
    }

    /**
     *
     *  @param user
     * @return BaseMessage
     * @author 倪军
     * @time 2017/3/16 11:34
     * @version 0.1
     * @sice 0.1
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public BaseMessage addUser(User user){
        BaseMessage message = new BaseMessage();
        message = this.iuserservice.addUser(user);
        return message;
    }
    /**
     *
     *  @param id
     * @return BaseMessage
     * @author 倪军
     * @time 2017/3/16 11:34
     * @version 0.1
     * @sice 0.1
     */
    @RequestMapping(value = "/delUser", method = RequestMethod.POST)
    @ResponseBody
    public BaseMessage delUser(Integer id){
        BaseMessage message = new BaseMessage();
        message = this.iuserservice.delUser(id);
        return message;
    }

    /**
     *
     *
     * @return BaseMessage
     * @author 倪军
     * @time 2017/3/16 11:34
     * @version 0.1
     * @sice 0.1
     */
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    @ResponseBody
    public User getUser(HttpServletRequest request){
        User model = (User)request.getSession().getAttribute("LoginMoldel");
        User user = this.iuserservice.getIUser(model.getId());
        return user;
    }
    /**
     *
     *
     * @return BaseMessage
     * @author 倪军
     * @time 2017/3/16 11:34
     * @version 0.1
     * @sice 0.1
     */
    @RequestMapping(value = "/loginOut", method = RequestMethod.POST)
    @ResponseBody
    public String loginOut(HttpServletRequest request){
        request.getSession().removeAttribute("LoginMoldel");
        return "";
    }
} 