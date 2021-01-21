package project.code_files;

import project.code_files.bean.User;
import project.code_files.service.DBService;

public class Main {
    public static void main(String[] args) {
        User user = new User("1",18,"1","1","1","1","1","1","1","1","1");
        DBService.insertUser(user);
    }
}
