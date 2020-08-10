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
import org.great.entity.User_information;
import org.great.service.ITreatedInfoService;
import org.great.service.IUntreatedInfoService;
import org.great.service.IUser_informationService;
import org.great.service.impl.TreatedInfoServiceImpl;
import org.great.service.impl.UntreatedInfoServiceImpl;
import org.great.service.impl.User_informationServiceImpl;

/**
 * Servlet implementation class DisagreeLockUserServlet
 */
@WebServlet("/DisagreeLockUserServlet")
public class DisagreeLockUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisagreeLockUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//不冻结
		request.setCharacterEncoding("utf-8");
		
		String ad_name = (String)request.getSession().getAttribute("administrator");
	
		
		if (ad_name!=null) {
			
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			//获取未处理信息
			IUntreatedInfoService untreatedInfoServiceImpl = new UntreatedInfoServiceImpl();
			UntreatedInfo untreatedInfo = untreatedInfoServiceImpl.queryUntreatedInfoById(id);
			
			//根据operation截取用户名
			String str1 = untreatedInfo.getOperation();
			String str2 = str1.substring(0, str1.indexOf(":"));
			String user = str1.substring(str2.length()+1, str1.length());
			
			
			//封装（已处理信息）
			String type = untreatedInfo.getType();
			String content = "解锁用户:"+user;
			String applicant = untreatedInfo.getAdministrator();
			String application_date = untreatedInfo.getTime();
			String checker = ad_name;
			
				//获取审核时刻时间
				Date date=new Date();    
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
			String check_date = df.format(date);
			
			TreatedInfo treatedInfo = new TreatedInfo(id,type,content,applicant,application_date,checker,check_date,"解除锁定");
	
			//添加到已处理信息
			ITreatedInfoService treatedInfoServiceImpl = new TreatedInfoServiceImpl();
			boolean result1 = treatedInfoServiceImpl.addTreatedInfo(treatedInfo);
			
			boolean result2 = false;
			
			if(result1) {
				//把用户状态设置为unlock
				IUser_informationService user_informationServiceImpl = new User_informationServiceImpl();
				User_information temp = user_informationServiceImpl.queryUser_informationByUser(user);
				temp.setStatus("unlock");
				user_informationServiceImpl.updateUser_informationByUser(user, temp);	
				
				//删除未处理信息
				result2 = untreatedInfoServiceImpl.deleteUntreatedInfo(id);
			}
		
		}
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
