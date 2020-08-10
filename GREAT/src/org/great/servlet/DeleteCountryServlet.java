package org.great.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.service.ICountryService;
import org.great.service.IUntreatedInfoService;
import org.great.service.impl.CountryServiceImpl;
import org.great.service.impl.UntreatedInfoServiceImpl;


/**
 * Servlet implementation class DeleteCountryServlet
 */
@WebServlet("/DeleteCountryServlet")
public class DeleteCountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCountryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				/*//删除
				request.setCharacterEncoding("utf-8");
				
				String ad_name = request.getParameter("ad_name");
				String operation = request.getParameter("operation");
				
				//根据operation截取国家名
				String str1=operation.substring(0, operation.indexOf(":"));
				String en_name = operation.substring(str1.length()+1, operation.length());
				
				System.out.println("同意删除国家："+en_name);
				
				//删除国家
				ICountryService countryServiceImpl = new CountryServiceImpl();
				boolean result1 = countryServiceImpl.deleteCountry(en_name);
				//删除未处理信息
				IUntreatedInfoService untreatedInfoServiceImpl = new UntreatedInfoServiceImpl();
				boolean result2 = untreatedInfoServiceImpl.deleteUntreatedInfo(operation);
				
				if (result1&&result2) {
					request.setAttribute("administrator", ad_name);
					request.getRequestDispatcher("information.jsp").forward(request, response);					
				}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
