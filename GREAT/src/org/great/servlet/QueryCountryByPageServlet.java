package org.great.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.entity.Country;
import org.great.entity.Page;
import org.great.service.ICountryService;
import org.great.service.impl.CountryServiceImpl;


/**
 * Servlet implementation class QueryCountryByPageServlet
 */
@WebServlet("/QueryCountryByPageServlet")
public class QueryCountryByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryCountryByPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String ad_name = (String)request.getSession().getAttribute("administrator");
		String cPage = request.getParameter("currentPage");
		
		//获取search内容（input当没填但是点击提交进来时，获取到的是"",不是null，如果没填但没点提交来的，则送来的是null）
		String search = request.getParameter("country_search");
		
		System.out.println("初步的country_search:"+search);
		if(search==null) {	//是null就尝试去session中拿
			search = (String)request.getSession().getAttribute("country_search");
		}
		//并将其放到session中
		request.getSession().setAttribute("country_search", search);

		System.out.println("获取后的country_Search:"+search);
		
		if (cPage==null) {//进来为空，默认第一页
			cPage = "1";
			}
		int currentPage = Integer.parseInt(cPage);
		
		
		if (ad_name!=null) {
			
			if(search==null) {
				
				ICountryService countryServiceImpl = new CountryServiceImpl();
				//数据总数
				int counts = countryServiceImpl.getTotalCount();
				
				int pageSize = 14;
				
				
				//将分页所需的5个字段（其中 页数 自动计算，因此只需传4个），组装到page对象之中
				Page page = new Page();
				page.setTotalCount(counts);
				page.setCurrentPage(currentPage);
				page.setPageSize(pageSize);
				
				
				//当前页信息
				List<Country> countries = countryServiceImpl.queryCountriesByPage(currentPage, pageSize);
				page.setCountries(countries);;
				
				//request.setAttribute("administrator", ad_name);
				request.setAttribute("page1", page);
			}else {
				ICountryService countryServiceImpl = new CountryServiceImpl();
				//数据总数
				int counts = countryServiceImpl.getSearchTotalCount(search);

				
				int pageSize = 14;
				
				
				//将分页所需的5个字段（其中 页数 自动计算，因此只需传4个），组装到page对象之中
				Page page = new Page();
				page.setTotalCount(counts);
				page.setCurrentPage(currentPage);
				page.setPageSize(pageSize);
				
				
				//当前页信息
				List<Country> countries = countryServiceImpl.queryCountriesBySerachPage(search, currentPage, pageSize);
				page.setCountries(countries);
				
				//request.setAttribute("administrator", ad_name);
				request.setAttribute("page1", page);
			}
		}
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
