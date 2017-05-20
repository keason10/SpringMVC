package myInterface;

import myEntity.StudentInfo;

import java.util.List;

/**
 * Created by KEASON on 2017/5/19.
 */
public interface StudentService {
    List<StudentInfo> listStudent();
    StudentInfo getStudentById(Long id);
    int updateStudentNameById(Long id,String name);
}
