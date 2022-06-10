package com.xu.test;

import com.xu.data.Interaction;
import com.xu.entity.Stus;
import com.xu.service.StuService;
import com.xu.utility.Realize;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {
        /*StuService.login("李红","qqq");*/
        /*StuService.register(4,"kk","778");*/
        StuService.change("kiii","456",1);


    }
}
