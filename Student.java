package gushi;

public class Student {
    //学号
    private String no;
    //姓名
    private String name;
    //性别
    private String sex;


    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Student(String no, String name, String sex) {
        this.no = no;
        this.name = name;
        this.sex = sex;
    }

    public String toString() {
        return "Student{" +
                "学号='" + no + '\'' +
                ", 姓名='" + name + '\'' +
                ", 性别='" + sex + '\'' +
                '}';
    }
}


