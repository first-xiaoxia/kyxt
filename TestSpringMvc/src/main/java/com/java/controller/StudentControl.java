package com.java.controller;

import com.java.entity.User;
import com.java.entity.commons.BaseMessage;
import com.java.entity.commons.BaseQuery;
import com.java.entity.student.Student;
import com.java.entity.student.StudentQeury;
import com.java.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.spi.http.HttpContext;
import java.util.Date;

/**
 * @author 倪军
 * @version 0.1
 * @time 2017/3/16 18:00
 */
@RequestMapping("student")
@Controller
public class StudentControl {
    @Autowired
    private StudentService StudentService;

    /**
     *
    *  @param sqeury
    * @return BaseQuery
    * @author 倪军
    * @time 2017/3/17 9:44
    * @version 0.1
    * @sice 0.1
    */
    @RequestMapping("getStudent")
    @ResponseBody
    public BaseQuery<Student> getStudent(StudentQeury sqeury){
        BaseQuery<Student> base = new BaseQuery<Student>();
        base = this.StudentService.getStudent(sqeury);
        return base;
    }

    /**
     *
     *  @param student
     * @return BaseMessage
     * @author 倪军
     * @time 2017/3/17 9:44
     * @version 0.1
     * @sice 0.1
     */
    @RequestMapping("editStudent")
    @ResponseBody
    public BaseMessage editStudent(Student student){
        //获取登录对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = null;
        user = (User) request.getSession().getAttribute("LoginMoldel");

        student.setUpdater(user.getUserType());//设置修改人类型
        student.setUpdateTime(new Date());
        BaseMessage base = new BaseMessage();
        base = this.StudentService.editStudent(student);
        return base;
    }

    /**
     *
    *  @param student
    * @return BaseMessage
    * @author 倪军
    * @time 2017/3/20 15:05
    * @version 0.1
    * @sice 0.1
    */
    @RequestMapping(value = "addStudent",method = RequestMethod.POST)
    @ResponseBody
    public BaseMessage addStudent(Student student){
        //获取登录对象
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) request.getSession().getAttribute("LoginMoldel");

        long i = user.getUserType();
        student.setCreater(i);//设置创建对象类型
        Date date = new Date();
        student.setCreateTime(date);//设置创建时间

        BaseMessage baseMessage = new BaseMessage();
        baseMessage = this.StudentService.addStudent(student);
        return baseMessage;
    }
}
