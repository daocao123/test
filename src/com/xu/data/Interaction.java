package com.xu.data;

import com.xu.entity.Stus;
import com.xu.utility.Realize;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Interaction {

    public static void add(Integer id, String name, String password) throws SQLException {
        QueryRunner qr = new QueryRunner(Realize.getDataSource());
        String sql = "insert into stu (sid,name,password) values ( ?, ?,?)";
        qr.update(sql,id,name,password);
    };
    public static Stus query(String name,String password) throws SQLException {
        String sql = "select sid id,name username,password,age from stu where name=?and password = ?";
        QueryRunner qr = new QueryRunner(Realize.getDataSource());
        Stus stu = qr.query(sql, new BeanHandler<Stus>(Stus.class), name, password);
        return stu;
    };
    public static void update(String name,String password,Integer i) throws SQLException {
        String sql = "update stu set name = ?,password = ?where sid = ?";
        QueryRunner qr = new QueryRunner(Realize.getDataSource());
        qr.update(sql,name,password,i);
    }


}
