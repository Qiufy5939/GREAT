package org.great.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.entity.Country;
import org.great.entity.Page;
import org.great.entity.Page_user;
import org.great.entity.User_information;
import org.great.service.ICountryService;
import org.great.service.IUser_informationService;
import org.great.service.impl.CountryServiceImpl;
import org.great.service.impl.User_informationServiceImpl;

import com.mysql.cj.xdevapi.JsonArray;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class QueryUser_informationByPageServlet
 */
@WebServlet("/QueryUser_informationByPageServlet")
public class QueryUser_informationByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryUser_informationByPageServlet() {
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
		String search = request.getParameter("user_search");
		
		System.out.println("初步的user_search:"+search);
		if(search==null) {	//是null就尝试去session中拿
			search = (String)request.getSession().getAttribute("user_search");
		}
		//并将其放到session中
		request.getSession().setAttribute("user_search", search);

		System.out.println("获取后的user_search:"+search);
		
		
		if (cPage==null) {//进来为空，默认第一页
			cPage = "1";
			}
		int currentPage = Integer.parseInt(cPage);		
		
		
	
		if (ad_name!=null) {
			
			if (search==null) {
					IUser_informationService user_informationServiceImpl = new User_informationServiceImpl();
					//数据总数
					int counts = user_informationServiceImpl.getTotalCount();
					
					int pageSize = 8;
					
					
					//将分页所需的5个字段（其中 页数 自动计算，因此只需传4个），组装到page对象之中
					Page_user page = new Page_user();
					page.setTotalCount(counts);
					page.setCurrentPage(currentPage);
					page.setPageSize(pageSize);
					
					
					//当前页信息
					List<User_information> user_informations = user_informationServiceImpl.queryUser_informationsByPage(currentPage, pageSize);
					page.setUser_informations(user_informations);
					
					//用输出流将信息返回回去
					//PrintWriter out= response.getWriter();
					//JSONObject json = new JSONObject();
					
					//User_information t1 = new User_information("1","1","1","1","1");
					//User_information t2 = new User_information("2","2","2","2","2"); 
					//json.put("s1", t1);
					//json.put("s2", t2);
					//System.out.println("传输json+"+user_informationttt);
					
					//request.setAttribute("page2", page);
					//request.getSession().setAttribute("page2", page);
					//out.print(page);//返回json对象 {"stu1":stu1,"stu2":stu2,"stu3":stu3}
					//out.close();
		
					
					//request.setAttribute("administrator", ad_name);
					request.setAttribute("page2", page);
				}else {

					IUser_informationService user_informationServiceImpl = new User_informationServiceImpl();
					//满足条件的数据总数
					int counts = user_informationServiceImpl.getSearchTotalCount(search);
					
					int pageSize = 8;
					
					
					//将分页所需的5个字段（其中 页数 自动计算，因此只需传4个），组装到page对象之中
					Page_user page = new Page_user();
					page.setTotalCount(counts);
					page.setCurrentPage(currentPage);
					page.setPageSize(pageSize);
					
					
					//当前页信息
					List<User_information> user_informations = user_informationServiceImpl.queryUser_informationsBySerachPage(search,currentPage, pageSize);
					//System.out.println("---------+"+user_informations);

					page.setUser_informations(user_informations);
				
					request.setAttribute("page2", page);
			}
		}
		request.getRequestDispatcher("userinfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
