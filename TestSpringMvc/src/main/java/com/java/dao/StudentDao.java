package com.java.dao;

import com.java.entity.commons.BaseQuery;
import com.java.entity.student.Student;

import java.util.List;

/**
 * @author 倪军
 * @Date ${Date} 10:37
 */
public interface StudentDao {

    public List<Student> students(BaseQuery qeury);

    public int getStudentsTotal(BaseQuery qeury);

    /**
     * 修改student信息
     * @param student
     * @return
     */
    public int editStudent(Student student);

    /**
     * 新增学生信息
     * @param student
     * @return
     */
    public int addStudent(Student student);
}
