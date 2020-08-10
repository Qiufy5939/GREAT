package org.great.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.entity.TreatedInfo;
import org.great.entity.UntreatedInfo;
import org.great.service.ITreatedInfoService;
import org.great.service.IUntreatedInfoService;
import org.great.service.impl.TreatedInfoServiceImpl;
import org.great.service.impl.UntreatedInfoServiceImpl;

/**
 * Servlet implementation class DisagreeDeleteCountryServlet
 */
@WebServlet("/DisagreeDeleteCountryServlet")
public class DisagreeDeleteCountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisagreeDeleteCountryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//不删除
				request.setCharacterEncoding("utf-8");
				
				String ad_name = (String)request.getSession().getAttribute("administrator");
				/*String operation = request.getParameter("operation");
				
				//根据operation截取国家名
				String str1=operation.substring(0, operation.indexOf(":"));
				String en_name = operation.substring(str1.length()+1, operation.length());
				
				System.out.println("不同意删除国家："+en_name);
				*/
				
				if (ad_name!=null) {
					
				
				int id = Integer.parseInt(request.getParameter("id"));
				
				//获取未处理信息
				IUntreatedInfoService untreatedInfoServiceImpl = new UntreatedInfoServiceImpl();
				UntreatedInfo untreatedInfo = untreatedInfoServiceImpl.queryUntreatedInfoById(id);
				
				//根据operation截取国家名
				String str1 = untreatedInfo.getOperation();
				String str2 = str1.substring(0, str1.indexOf(":"));
				String en_name = str1.substring(str2.length()+1, str1.length());
				
				
				//封装（已处理信息）
				String type = untreatedInfo.getType();
				String content = untreatedInfo.getOperation();
				String applicant = untreatedInfo.getAdministrator();
				String application_date = untreatedInfo.getTime();
				String checker = ad_name;
				
					//获取审核时刻时间
					Date date=new Date();    
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			
				String check_date = df.format(date);
				
				TreatedInfo treatedInfo = new TreatedInfo(id,type,content,applicant,application_date,checker,check_date,"不同意");

				//添加到已处理信息
				ITreatedInfoService treatedInfoServiceImpl = new TreatedInfoServiceImpl();
				boolean result1 = treatedInfoServiceImpl.addTreatedInfo(treatedInfo);
				
				boolean result2 = false;
				
				if(result1) {
					//删除未处理信息
					result2 = untreatedInfoServiceImpl.deleteUntreatedInfo(id);
				}
				
				}
				//request.setAttribute("administrator", ad_name);
				request.getRequestDispatcher("information.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
