package org.great.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.great.entity.Country;
import org.great.service.ICountryService;
import org.great.service.impl.CountryServiceImpl;


/**
 * Servlet implementation class AddCountryServlet
 */
@WebServlet("/AddCountryServlet")
public class AddCountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCountryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String ad_name = (String)request.getSession().getAttribute("administrator");
		System.out.println("来自addCountry的ad_name："+ad_name);
		
		if (ad_name!=null) {
			
	
				String en_name = "";
				String cn_name = "";
				String capital = "";
				String introduction = "";
				//设置文件名
				String fileName = "";
				
				
				//上传
				boolean isMutipart = ServletFileUpload.isMultipartContent(request);	//检查前台的form是否有enctype="multipart/form-data"
				
				if(isMutipart) {
					//FileItemFactory factory = new DiskFileItemFactory();
					DiskFileItemFactory factory = new DiskFileItemFactory();
					ServletFileUpload upload = new ServletFileUpload(factory);
					
					try {
						//通过parseRequest解析form中的所有请求字段，并保存到items集合中（即前台传递的en_name,cn_name,capital,introduction,flag此时就保存在了items中）
						List<FileItem> items = upload.parseRequest(request);
						//遍历items中的数据
						Iterator<FileItem> iter = items.iterator();
						while (iter.hasNext()) {
							FileItem item = iter.next();
							//根据name属性判断是哪个内容
							String itemName = item.getFieldName();//getFieldName普通表单字段名
							
							//判断前台字段 是普通form表单字段，还是文件字段
							if(item.isFormField()) {
								
								//接下来判断哪个内容
								if (itemName.equals("en_name")) {
									en_name = item.getString("UTF-8");	
								}else if(itemName.equals("cn_name")) {
									cn_name = item.getString("UTF-8");
								}else if (itemName.equals("capital")) {
									capital = item.getString("UTF-8");
								}else if (itemName.equals("introduction")) {
									introduction = item.getString("UTF-8");
								}
							}
							else {
								//文件上传
								
								String[] temp = en_name.split(" ");
								
								
								for (int i = 0; i < temp.length; i++) {
									fileName+=temp[i];
									if (i!=temp.length-1) {
										fileName+="_";
									}
								}
								fileName+=".png";
		
								
								//获取文件内容并上传
								//指定文件路径：指定上传的位置(服务器路径)//可以采用方法动态获取服务器路径，避免忘记了
								String path = request.getSession().getServletContext().getRealPath("css");
								path+="/img";
								File file = new File(path,fileName);
								
								item.write(file);//上传
								System.out.println(fileName+"上传成功！在路径："+path);
							}
						}
						
						
					}catch (FileUploadBase.SizeLimitExceededException e) {
						// TODO: handle exception
						//System.out.println("单个文件大小大于5mb");
						e.printStackTrace();
					}catch (FileUploadException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}

				Country country = new Country(en_name,cn_name,capital,"css/img/"+fileName,introduction);
				System.out.println("新增国家+"+country);
				ICountryService countryServiceImpl = new CountryServiceImpl();
				boolean result = countryServiceImpl.addCountry(country);
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
