package org.great.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckCodeServlet
 */
@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户键入验证码
        String checkcodeClient = request.getParameter("checkcode");
        //真实的验证码
        String checkcodeServer = (String) request.getSession().getAttribute("CHECKCODE");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
       /* if (checkcodeServer.equals(checkcodeClient)){
            writer.write("true");
        }else{
            writer.write("false");
        }*/
        writer.write(checkcodeServer);	//为了登录检验，所以直接返回系统验证码
        writer.flush();
        writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
