package project.code_files.servlet;

import project.code_files.bean.Edu;
import project.code_files.bean.Result;
import project.code_files.service.DBService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/v1/edu/insert")
public class EduServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");

        int userId = 0;
        String userIdText = request.getParameter("userid");
        if(userIdText != null){
            try {
                userId = Integer.parseInt(userIdText);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        String school = request.getParameter("school");
        String study = request.getParameter("study");
        String description = request.getParameter("description");
        Edu edu = new Edu(userId,start,end,school,study,description);
        int row = DBService.insertEdu(edu);
        Result result = null;
        if(row>0){
            result = new Result(0,"Education history added successfully!");
        }else{
            result = new Result(-1,"Opps...Failed to add education history");
        }
        response.getWriter().append(result.toJSON());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
