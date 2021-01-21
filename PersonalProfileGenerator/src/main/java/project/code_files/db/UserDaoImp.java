package project.code_files.db;

import project.code_files.bean.User;
import project.code_files.util.DBUtil;

import java.sql.*;

public class UserDaoImp implements BaseDao<User>{
    private static final String SQL_INSERT = "insert into user(name,age,city,address,email,phone,facebook,linkedin,twitter,sex,description) values(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_FIND_BY_USERID = "select * from user where id=?";

    @Override
    public int insert(User o) {
        //1. get link
        Connection conn = project.code_files.util.DBUtil.getConn();
        PreparedStatement state = null;
        try {

            //2. get runtime environment
            state = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            //3. feed parameters into runtime environment
            state.setString(1,o.getName());
            state.setInt(2,o.getAge());
            state.setString(3,o.getCity());
            state.setString(4,o.getAddress());
            state.setString(5,o.getEmail());
            state.setString(6,o.getPhone());
            state.setString(7,o.getFacebook());
            state.setString(8,o.getLinkedin());
            state.setString(9,o.getTwitter());
            state.setString(10,o.getSex());
            state.setString(11,o.getDescription());
            //4. execute
            state.executeUpdate();
            ResultSet rs = state.getGeneratedKeys();
            if(rs.next()){
                //5. return result of adding records
                return rs.getInt(1);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }finally {
            // Releasing database resource
            project.code_files.util.DBUtil.close(conn,state,null);
        }
        return -1;
    }

    @Override
    public User findByUserId(int userId) {
        try {
            //1. link to cloud database
            Connection conn = DBUtil.getConn();
            //2. get runtime environment
            PreparedStatement state = conn.prepareStatement(SQL_FIND_BY_USERID);
            //3. feed parameters into runtime environment
            state.setInt(1,userId);
            //4. execute result
            ResultSet resultSet = state.executeQuery();
            while(resultSet.next()){
                int age = resultSet.getInt("age");
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String facebook = resultSet.getString("facebook");
                String linkedin = resultSet.getString("linkedin");
                String twitter = resultSet.getString("twitter");
                String sex = resultSet.getString("sex");
                String description = resultSet.getString("description");
                User user = new User(name,age,city,address,email,phone,facebook,linkedin,twitter,sex,description);
                //5. Return result
                return user;
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return null;
    }
}
