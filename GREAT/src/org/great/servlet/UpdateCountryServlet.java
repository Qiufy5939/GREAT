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
 * Servlet implementation class UpdateCountryServlet
 */
@WebServlet("/UpdateCountryServlet")
public class UpdateCountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCountryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String ad_name = (String)request.getSession().getAttribute("administrator");
		
		if (ad_name!=null) {
			
			//获取待修改的英文名
			String en_name = request.getParameter("en_name");
			String currentPage = request.getParameter("currentPage");
		
			
			//获取修改后的内容
			String cn_name = request.getParameter("cn_name");
			String capital = request.getParameter("capital");
			String flag =  request.getParameter("flag");
			String introduction = request.getParameter("introduction");
			//封装
			Country country = new Country(en_name,cn_name,capital,flag,introduction);
			System.out.println("更改后："+country);
			
			
			ICountryService countryServiceImpl = new CountryServiceImpl();
			boolean result = countryServiceImpl.updateCountryByEn_name(en_name, country);
					
			System.out.println(result);
			/*if (!result) {
				request.setAttribute("flag", "update_failure");
			}else {
				request.setAttribute("flag", "update_success");
			}*/
		
		
			request.setAttribute("currentPage", currentPage);
			//request.setAttribute("ad_name", ad_name);
		}
		request.getRequestDispatcher("QueryCountryByPageServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
