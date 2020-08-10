package org.great.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.entity.Country;
import org.great.service.ICountryService;
import org.great.service.impl.CountryServiceImpl;

/**
 * Servlet implementation class QueryCountryByEn_name
 */
@WebServlet("/QueryCountryByEn_nameServlet")
public class QueryCountryByEn_nameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryCountryByEn_nameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//String ad_name = request.getParameter("administrator");
		String en_name = request.getParameter("en_name");
		String currentPage = request.getParameter("currentPage");
		
		
		ICountryService countryServiceImpl = new CountryServiceImpl();
		Country result = countryServiceImpl.queryCountryByEn_name(en_name);
		
		
		System.out.println("页数："+currentPage);
		System.out.println(result);	
		
		
		//将此数据通过detail.jsp显示
		request.setAttribute("country", result);//将查询到的国家放入request域中
		request.setAttribute("currentPage", currentPage);
		//request.setAttribute("administrator", ad_name);
		
		request.getRequestDispatcher("detail.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
