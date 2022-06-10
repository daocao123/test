package com.xu.test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;

public class TestJdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///day0212", "root", "857538");
        String sql = "select *from stu  ";
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet resultSet = pst.executeQuery();
        ArrayList<Stu> as = new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            String tel = resultSet.getString(4);
            Stu s= new Stu(id,name,age,tel);
            as.add(s);
        }
        as.sort(new Comparator<Stu>() {
            @Override
            public int compare(Stu o1, Stu o2) {
                return o2.getAge()-o1.getAge();
            }
        });
        for (int i = 0;i<=as.size()-1;i++){
            if(as.get(i).getTel().substring(0,3).equals("138")){
                System.out.println(as.get(i));
            }
        }
    }
}
class Stu{
    private int id;
    private String name;
    private int age;
    private String tel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Stu() {
    }

    @Override
    public String toString() {
        return "Stu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", tel='" + tel + '\'' +
                '}';
    }

    public Stu(int id, String name, int age, String tel) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.tel = tel;
    }

}