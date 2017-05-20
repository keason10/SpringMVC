package myInterface;

import myEntity.SexEnum;
import myEntity.StudentInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KEASON on 2017/5/19.
 */
@Service
public class DataStorage {
    static List<StudentInfo> list = getStudentList();
    private static List<StudentInfo> getStudentList(){
        List<StudentInfo> list = new  ArrayList<StudentInfo>();
        list.add(new StudentInfo(10001L,"student10001","10001L", SexEnum.MAN));
        list.add(new StudentInfo(10002L,"student10002", "10002L",SexEnum.MAN));
        list.add(new StudentInfo(10003L,"student10003", "10003L",SexEnum.WOMAN));
        return list;
    }

    public static List<StudentInfo> getList() {
        return list;
    }
}
