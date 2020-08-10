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
import org.great.service.ITreatedInfoService;
import org.great.service.IUntreatedInfoService;
import org.great.service.impl.TreatedInfoServiceImpl;
import org.great.service.impl.UntreatedInfoServiceImpl;

/**
 * Servlet implementation class AddUntreatedInfoServlet
 */
@WebServlet("/AddUntreatedInfoServlet")
public class AddUntreatedInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUntreatedInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String ad_name = (String)request.getSession().getAttribute("administrator");
		String en_name = request.getParameter("en_name");
		//String currentPage = request.getParameter("currentPage");
		
		
		boolean result = false;
		
		if (en_name!=null&&ad_name!=null) {
			System.out.println(ad_name + en_name);
			
			IUntreatedInfoService untreatedInfoServiceImpl = new UntreatedInfoServiceImpl();
			ITreatedInfoService treatedInfoServiceImpl = new TreatedInfoServiceImpl();
			
			if(untreatedInfoServiceImpl.queryUntreatedInfoByOperation("请求删除国家:"+en_name)==null) {
				
				int id = untreatedInfoServiceImpl.getTotalCount()+ treatedInfoServiceImpl.getTotalCount()+1;	//前面是未处理总数，后面是已处理总数
				String type = "国家信息";
				String administrator = ad_name;
				
				//获取申请时刻时间
				Date date=new Date();    
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				
				String time = df.format(date);
				String operation = "请求删除国家:"+en_name;
				
				//封装到UntreatedInfo类
				UntreatedInfo untreatedInfo = new UntreatedInfo(id,type,administrator,time,operation);
				System.out.println("加入未处理信息："+untreatedInfo);
				
				result = untreatedInfoServiceImpl.addUntreatedInfo(untreatedInfo);
			}
		}
		
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        if (result){
            writer.write("true");
        }else{
            writer.write("false");
        }
        writer.flush();
        writer.close();
		
		/*
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("administrator", ad_name);
		request.getRequestDispatcher("main.jsp").forward(request, response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
