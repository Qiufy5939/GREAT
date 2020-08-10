<%@page import="org.great.entity.User_information"%>
<%@page import="java.util.List"%>
<%@page import="org.great.entity.*"%>
<%@page import="java.lang.Iterable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <!--引入bootstrap-->
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <!--<link rel="stylesheet" href="bootstrap/css/bootstrap.css">-->

    <script src="js/jquery-3.5.0.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    
    
    <!--引入自己的样式-->
    <link rel="stylesheet" href="css/style_userinfo.css">
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">


 </script>


</head>
<body>
 <%							String ad_name = (String)request.getSession().getAttribute("administrator");
                       		if(ad_name==null){
                       			//重定向到登录页
                       			request.getSession().invalidate();
                				response.sendRedirect("index.jsp");
                       		}else{
 
 							Page_user page2 = (Page_user)request.getAttribute("page2");
                       			if(page2!=null){
                       %>
            
                      <div class="serach">
                            <nav class="navbar navbar-light bg-light">
                                <form class="form-inline" action="QueryUser_informationByPageServlet" method="post">
                                    <input class="form-control" type="search" placeholder="Search" aria-label="Search" name="user_search" id="user_search">
                                    <button class="btn btn-outline-success" type="submit">Search</button>
                                </form>
                            </nav>
                       </div>
                        <div class="form">
                            <table class="table table-dark">
                                <thead>
                                <tr>
                                    <th scope="col">User</th>
                                    <th scope="col">Password</th>
                                    <th scope="col">Phone</th>
                                    <th scope="col">注册时间</th>
                                    <th scope="col">月龄</th>                              
                                    <th scope="col">Last time</th>
                                    <th scope="col">操作</th>
                                </tr>
                                </thead>
                                <tbody>
              <%
              			for(User_information user_information:page2.getUser_informations()){
              %>
	                                <tr>
	                                    <th scope="row"><%=user_information.getUser() %></th>
	                                    <td><%=Lock_password.process(user_information.getPassword()) %></td>
	                                    <td><%=user_information.getPhone() %></td>
	                                    <td><%=user_information.getRegistration_time() %></td>
	                                    <td><%=Calculate.getMonth(user_information.getRegistration_time()) %></td>
	                                    <td><%=Calculate.getTime(user_information.getLogin_time()) %></td>
	                                    <% 
	                                    		if("unlock".equals(user_information.getStatus())){%>
			                                    <td>
			                                        <a href="AddLock_userServlet?currentPage=<%=page2.getCurrentPage() %>&user=<%=user_information.getUser() %>" onClick="return confirm('确定【冻结】该用户?');"><button type="button" class="btn btn-danger" value="<%=user_information.getUser() %>">冻结用户</button></a>
			                                    </td>	                                    			
	                                    <% 		}else{		%>
		                                    	<td>
	                                        		<button type="button" class="btn btn-info" onClick="return alert('如需解除【锁定】请前往信息中心！');">该用户已被冻结</button>
	                                    		</td>	  
	                                    <% } %>
	                                </tr>
	 							<% } %>
                                </tbody>
                            </table>
                        </div>
                    <% 
					if(page2.getCurrentPage()==1 && page2.getTotalPage()>1){%>
						<div class="page">
                        	<nav aria-label="Page navigation example">
							  <ul class="pagination">
							  	<li class="page-item"><a class="page-link" href="QueryUser_informationByPageServlet?currentPage=1">First</a></li>
							    <li class="page-item"><a class="page-link" href="QueryUser_informationByPageServlet?currentPage=<%=page2.getCurrentPage()+1 %>">Next</a></li>
							    <li class="page-item"><a class="page-link" href="QueryUser_informationByPageServlet?currentPage=<%=page2.getTotalPage() %>">Last</a></li>
							  </ul>
							</nav>
                       	</div>
                       	
						<% }else if((page2.getCurrentPage()==page2.getTotalPage())&& page2.getTotalPage()>1){%>
						<div class="page">
                      			<nav aria-label="Page navigation example">
					  			<ul class="pagination">
					  				<li class="page-item"><a class="page-link" href="QueryUser_informationByPageServlet?currentPage=1">First</a></li>
					    			<li class="page-item"><a class="page-link" href="QueryUser_informationByPageServlet?currentPage=<%=page2.getCurrentPage()-1 %>">Previous</a></li>
					    			<li class="page-item"><a class="page-link" href="QueryUser_informationByPageServlet?currentPage=<%=page2.getTotalPage()%>">Last</a></li>
					  			</ul>
							</nav>
                       	</div>
						<% }else{
									if(page2.getTotalPage()>1){%>
						<div class="page">
                      			<nav aria-label="Page navigation example">
					  			<ul class="pagination">
					  				<li class="page-item"><a class="page-link" href="QueryUser_informationByPageServlet?currentPage=1">First</a></li>
					    			<li class="page-item"><a class="page-link" href="QueryUser_informationByPageServlet?currentPage=<%=page2.getCurrentPage()-1 %>">Previous</a></li>
					    			<li class="page-item"><a class="page-link" href="QueryUser_informationByPageServlet?currentPage=<%=page2.getCurrentPage()+1 %>">Next</a></li>
					    			<li class="page-item"><a class="page-link" href="QueryUser_informationByPageServlet?currentPage=<%=page2.getTotalPage() %>">Last</a></li>
					  			</ul>
							</nav>
                       	</div>
                       	<%}	}
                       			}
							
	              				else{
	            	  					request.getRequestDispatcher("QueryUser_informationByPageServlet").forward(request, response);
	              					}
	              }
		 				%>	
						
										
</body>
</html>