package myEntity;

import java.util.List;

/**
 * Created by KEASON on 2017/5/19.
 */
public class StudentInfo {
    private Long id;
    private String name;
    private String pwd;
    private SexEnum sex;

    private List<CourseInfo> courseList;

    public StudentInfo() {
    }

    public StudentInfo(Long id, String name,String pwd, SexEnum sex) {
        this.id = id;
        this.name = name;
        this.pwd= pwd;
        this.sex = sex;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


    public List<CourseInfo> getCourseList() {

        return courseList;
    }

    public void setCourseList(List<CourseInfo> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex=" + sex +
                '}';
    }

}
