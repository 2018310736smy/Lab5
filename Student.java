package gushi;

public class Student {
    //ѧ��
    private String no;
    //����
    private String name;
    //�Ա�
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

    @Override
    public String toString() {
        return "Student{" +
                "ѧ��='" + no + '\'' +
                ", ����='" + name + '\'' +
                ", �Ա�='" + sex + '\'' +
                '}';
    }
}

