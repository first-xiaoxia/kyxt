package com.java.dao;

import com.java.entity.student.Student;
import com.java.entity.student.StudentQeury;

import java.util.List;

/**
 * @author 倪军
 * @Date ${Date} 10:37
 */
public interface StudentDao {

    public List<Student> students(StudentQeury qeury);

    public int getStudentsTotal(StudentQeury qeury);

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
