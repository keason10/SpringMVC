package myInterface.myImpl;

import myInterface.DataStorage;
import myEntity.StudentInfo;
import myInterface.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by KEASON on 2017/5/19.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private DataStorage dataStorage;

    public List<StudentInfo> listStudent() {
        return dataStorage.getList();
    }

    public StudentInfo getStudentById(Long id) {
        for (StudentInfo stu:dataStorage.getList()) {
            if (stu.getId().equals(id)) {
                return stu;
            }
        }
        return new StudentInfo();
    }

    public int updateStudentNameById(Long id, String name) {
        for (StudentInfo stu:dataStorage.getList()) {
            if (stu.getId().equals(id)) {
                stu.setName(name);
                return 1;
            }
        }
        return 0;
    }



}
