package com.java.service;

import com.java.dao.StudentDao;
import com.java.entity.commons.BaseMessage;
import com.java.entity.commons.BaseQuery;
import com.java.entity.commons.BaseResult;
import com.java.entity.student.Student;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 倪军
 * @version 0.1
 * @time 2017/3/17 10:34
 */
@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;
    private static final Logger logger = Logger.getLogger("");

    /**
     *
    *  @param qeury
    * @return BaseResult<Student>
    * @author 倪军
    * @time 2017/3/17 10:54
    * @version 0.1
    * @sice 0.1
    */
    public BaseResult<Student> getStudent(BaseQuery qeury){
        BaseResult<Student> base = new BaseResult<Student>();
        List<Student> rows = this.studentDao.students(qeury);//获得所有的行数据
        int total = this.studentDao.getStudentsTotal(qeury);
        base.setRows(rows);
        base.setTotal(total);
        return base;
    }

    /**
     *
     *  @param student
     * @return BaseResult<Student>
     * @author 倪军
     * @time 2017/3/17 10:54
     * @version 0.1
     * @sice 0.1
     */
    public BaseMessage editStudent(Student student){
        BaseMessage base = new BaseMessage();
        int i = 1;
        try {
            i = this.studentDao.editStudent(student);//获得所有的行数据
        }catch (Exception e){
            logger.error("修改学生信息失败"+e);
            base.setMesscode(String.valueOf(i));
            base.setMessage("修改学生信息失败");
            return base;
        }
        base.setMesscode(String.valueOf(i));
        base.setMessage("修改学生信息成功");
        return base;
    }

    /**
     *
    *  @param student
    * @return
    * @author 倪军
    * @time 2017/3/20 15:07
    * @version 0.1
    * @sice 0.1
    */
    public BaseMessage addStudent(Student student){
        BaseMessage baseMessage = new BaseMessage();
        int i = 1;
        try {
            i = this.studentDao.addStudent(student);
        }catch (Exception e){
            baseMessage.setMesscode(String.valueOf(i));
            baseMessage.setMessage("新增学生信息失败");
            logger.error("新增学生信息失败");
            return baseMessage;
        }
        baseMessage.setMesscode(String.valueOf(i));
        baseMessage.setMessage("新增学生信息成功");
        return  baseMessage;
    }
}
