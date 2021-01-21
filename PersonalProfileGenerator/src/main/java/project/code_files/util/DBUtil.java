package project.code_files.util;

import java.sql.*;

public class DBUtil {
    /**
     * This is using for linking database，return connection object of database, which has many functions of managing database
     * @return connection database object
     */
    public static Connection getConn(){
        //1. load database driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2. get connection link of database
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://personalprofilegenerator.rwlb.rds.aliyuncs.com:3306/personalprofilegeneratordb", "song2020", "Lisong95");
            //3. return link back to user
            return conn;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    /**
     * disconnect from database，release database resource
     * @param conn link need to be release
     * @param statement runtime environment need to be release
     * @param resultSet set of results needed to be release
     */
    public static void close(Connection conn, Statement statement, ResultSet resultSet){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
    }



}
