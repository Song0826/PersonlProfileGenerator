package project.code_files.db;

import java.sql.*;

public class DBUtil {
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConn(){
        //personalpage.rwlb.rds.aliyuncs.com --> Cloud database public address
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://personalprofilegenerator.rwlb.rds.aliyuncs.com:3306/personalprofilegeneratordb", "song2020", "Lisong95");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
    public static void close(Connection conn, Statement state, ResultSet resultSet){
        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(state!=null) {
            try {
                state.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(resultSet!=null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
