package org.great.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.entity.UntreatedInfo;
import org.great.entity.User_information;
import org.great.service.ITreatedInfoService;
import org.great.service.IUntreatedInfoService;
import org.great.service.IUser_informationService;
import org.great.service.impl.TreatedInfoServiceImpl;
import org.great.service.impl.UntreatedInfoServiceImpl;
import org.great.service.impl.User_informationServiceImpl;

/**
 * Servlet implementation class AddLock_userServlet
 */
@WebServlet("/AddLock_userServlet")
public class AddLock_userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLock_userServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String ad_name = (String)request.getSession().getAttribute("administrator");
		String user = (String)request.getParameter("user");
		String currentPage = request.getParameter("currentPage");
		
		System.out.println("冻结用户："+user);
		
		boolean result = false;
		
		if (ad_name!=null && user!=null) {
			
			IUntreatedInfoService untreatedInfoServiceImpl = new UntreatedInfoServiceImpl();
			ITreatedInfoService treatedInfoServiceImpl = new TreatedInfoServiceImpl();
			
			
			int id = untreatedInfoServiceImpl.getTotalCount()+ treatedInfoServiceImpl.getTotalCount()+1;	//前面是未处理总数，后面是已处理总数
			String type = "用户信息";
			String administrator = ad_name;
			
			//获取申请时刻时间
			Date date=new Date();    
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			
			String time = df.format(date);
			String operation = "冻结用户:"+user;
			
			//封装到UntreatedInfo类
			UntreatedInfo untreatedInfo = new UntreatedInfo(id,type,administrator,time,operation);
			System.out.println("加入未处理信息："+untreatedInfo);
			
			result = untreatedInfoServiceImpl.addUntreatedInfo(untreatedInfo);
		}
		
		if (result) {
				IUser_informationService user_informationServiceImpl = new User_informationServiceImpl();
				User_information temp = user_informationServiceImpl.queryUser_informationByUser(user);
				
				temp.setStatus("lock");
				user_informationServiceImpl.updateUser_informationByUser(user, temp);			
		}


		request.setAttribute("currentPage", currentPage);
		request.getRequestDispatcher("QueryUser_informationByPageServlet").forward(request, response);
		
		
		

		
				
			/*
		
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        if (result){
            writer.write("true");
        }else{
            writer.write("false");
        }
        writer.flush();
        writer.close();*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
