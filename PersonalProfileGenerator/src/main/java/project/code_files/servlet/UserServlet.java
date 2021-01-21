package project.code_files.servlet;

import project.code_files.bean.Result;
import project.code_files.bean.User;
import project.code_files.service.DBService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/v1/user/insert")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. Avoid garbled
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        //2. Receive data passing from the browser
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String facebook = request.getParameter("facebook");
        String linkedin = request.getParameter("linkedin");
        String twitter = request.getParameter("twitter");
        String sex = request.getParameter("sex");
        String description = request.getParameter("description");
        String ageText = request.getParameter("age");
        int age = -1;
        try {
            age = Integer.parseInt(ageText);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        //3. Using service，save passing data to database
        User user = new User(name,age,city,address,email,phone,facebook,linkedin,twitter,sex,description);
        int userId = DBService.insertUser(user);
        //4. Encapsulate saving result to Json file and send to the browser
        Result r;
        if(userId>0){
            r = new Result(0,"New user profile created successfully!",userId);
        }else{
            r = new Result(-1,"Opps... failed to create user profile!");
        }
        String json = r.toJSON();
        response.getWriter().append(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
