package org.great.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.great.service.IAdministratorService;
import org.great.service.impl.AdministratorServiceImpl;

/**
 * Servlet implementation class QueryAdministratorByIdServlet
 */
@WebServlet("/QueryAdministratorByIdServlet")
public class QueryAdministratorByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAdministratorByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //获取管理员输入的ad及密码
        String ad = request.getParameter("ad");
        String ad_check = request.getParameter("ad_check");

        System.out.println(ad);
        System.out.println(ad_check);
      
    IAdministratorService administratorService = new AdministratorServiceImpl();

    //通过输出流返回结果

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter writer = response.getWriter();
    if(ad!=null){
        if (administratorService.queryAdByAd(ad))
        writer.write("true");
        else
        writer.write("false");
    }
    if (ad_check!=null){
        String flag = administratorService.queryPwdByAd(ad_check);
        if (flag==null) {
			writer.write("!%(!&!^^^$&_!&#^^&%()$$***qfy");
		}else {
			writer.write(flag);
		}
        
    }
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
