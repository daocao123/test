package com.xu.utility;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Realize {
    private static DataSource dataSource;
    static {
        try {
            Properties prop = new Properties();
            prop.load(new FileReader("src\\druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(prop);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static DataSource getDataSource(){
        return dataSource;
    }
    public static Connection getCollections() throws SQLException {
        return dataSource.getConnection();
    }
}
