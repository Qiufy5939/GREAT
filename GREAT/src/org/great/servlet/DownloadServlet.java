package org.great.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");	
		
		//获取需要下载的文件名,包括后缀
		String fileName = request.getParameter("fileName");
		
		//------------------------------------------------
		//下载文件：需要设置响应头
		response.addHeader("content-Type", "application/octet-stream");//传输文件类型
		response.addHeader("content-Disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));
		//------------------------------------------------
		 
		//Servlet通过文件的地址  将文件转为输入流  读到Servlet中
		InputStream in = getServletContext().getResourceAsStream("/apk/"+fileName);
		
		//通过输出流  将刚才已经转为输入流的文件  输出给用户
		ServletOutputStream out = response.getOutputStream();
		
		byte[] bs = new byte[1024];
		int len = -1;
		while ((len=in.read(bs))!=-1) {
			out.write(bs,0,len);
		}
		out.close();
		in.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
