package project.code_files.servlet;

import project.code_files.bean.Result;
import project.code_files.bean.Work;
import project.code_files.service.DBService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/v1/work/insert")
public class WorkServlet extends HttpServlet {
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
        String company = request.getParameter("company");
        String job = request.getParameter("job");
        String description = request.getParameter("description");
        Work work = new Work(userId,start,end,company,job,description);
        int row = DBService.insertWork(work);
        Result result = null;
        if(row>0){
            result = new Result(0,"Work experience added successfully!");
        }else{
            result = new Result(-1,"Opps... failed to add work experience");
        }
        response.getWriter().append(result.toJSON());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
