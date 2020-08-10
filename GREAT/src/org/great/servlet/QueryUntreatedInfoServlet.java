package org.great.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.great.entity.MyEntity;
import org.great.entity.TreatedInfo;
import org.great.entity.UntreatedInfo;
import org.great.service.ITreatedInfoService;
import org.great.service.IUntreatedInfoService;
import org.great.service.impl.TreatedInfoServiceImpl;
import org.great.service.impl.UntreatedInfoServiceImpl;

/**
 * Servlet implementation class QueryUntreatedInfoServlet
 */
@WebServlet("/QueryUntreatedInfoServlet")
public class QueryUntreatedInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryUntreatedInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String ad_name = request.getParameter("ad_name");
		
		//获取未处理信息
		IUntreatedInfoService untreatedInfoServiceImpl = new UntreatedInfoServiceImpl();
		//获取处理信息
		ITreatedInfoService treatedInfoServiceImpl = new TreatedInfoServiceImpl();
		
		List<UntreatedInfo> untreatedInfos = untreatedInfoServiceImpl.queryAllUntreatedInfos();
		List<TreatedInfo> treatedInfos = treatedInfoServiceImpl.queryAllTreatedInfos();

		MyEntity myEntity = new MyEntity(untreatedInfos,treatedInfos);
		
		request.setAttribute("MyEntity", myEntity);
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
