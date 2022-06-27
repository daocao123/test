package com.xu.service;

import com.xu.data.Interaction;
import com.xu.entity.Stus;

import java.sql.SQLException;

public class StuService {
     public static void login(String username,String password) throws SQLException {
        Stus query = Interaction.query(username, password);
        if (query!=null){
            System.out.println("登录成功，欢迎您"+query.getUsername());
        }else {
            System.out.println("用户名或密码错误");
        }
    }
    public static void register(int id,String name,String password) {
        try {
            Interaction.add(id,name,password);
            System.out.println("恭喜您，注册成功");
        }catch (Exception e){
            System.out.println("用户名已存在");
            e.printStackTrace();
        }

    }
    public static void change(String name,String password,int id){
        System.out.println("第三次更新");
         try{
             Interaction.update(name,password,id);
             System.out.println("修改成功");
         }
         catch (Exception e){
             e.printStackTrace();
         }
    }
}
