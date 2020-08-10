<%--
  Created by IntelliJ IDEA.
  User: 93827
  Date: 2020/5/15
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.List"%>
<%@page import="org.great.entity.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
<head>

    <!--引入bootstrap-->
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    
    <!--<link rel="stylesheet" href="bootstrap/css/bootstrap.css">-->

    <script src="js/jquery-3.5.0.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>

    <!--引入自己的样式-->
    <link rel="stylesheet" href="css/style_main.css">
    <title>Welcome!</title>
    
<script type="text/javascript">
		function delete1(temp){
			
			var ad_name1 = document.getElementById("ad_name1").innerText;
			$.post(							
					"AddUntreatedInfoServlet",
					{"en_name":temp,"ad_name":ad_name1},
					function(result){
						if(result=="true"){
							alert("已提交申请，请等待另一个管理员审核!");
						}else{
							alert("该国家已被申请过，请前往信息中心查询!");
						}
					}
				);

		}
 </script>

</head>

<body>
<%
			String ad_name = request.getParameter("administrator");
			if(ad_name==null){//为了防止获取方式不同而获取不到
				//ad_name = (String)request.getAttribute("administrator");
				ad_name = (String)session.getAttribute("administrator");
			}
			session.setAttribute("administrator", ad_name);
%>


<nav class="navbar navbar-inverse nav-pills">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand hidden-xs" href="#"><font color="#ff7f50" size="5px">G</font>lobal  <font color="#ff7f50" size="5px">R</font>egion  <font color="#ff7f50" size="5px">E</font>nglish  <font color="#ff7f50" size="5px">A</font>ccessible  <font color="#ff7f50" size="5px">T</font>ranslation</a>
            <a class="navbar-brand hidden-md hidden-lg hidden-sm"><font color="#ff7f50">GREAT</font></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a id="ad_name1" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%=ad_name %><span class="caret"></span></a>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton" role="menu">
                        <li><a href="information.jsp" class="glyphicon glyphicon-bell">信息中心</a></li>
                        <li><a href="LogOutServlet" class="glyphicon glyphicon-off">登出</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->

    </div><!-- /.container-fluid -->
</nav>




        <div class="container">
            <div class="row">
                <header class="col-md-2">
                    <div class="logo">
                        <a class="hidden-xs hidden-sm">后台管理系统</a>
                    </div>

                    <div class="nav nav-tabs">
                        <ul class="left" id="myTab" role="tablist">
                            <li class="nav-item"><a class="glyphicon glyphicon-flag nav-link active" id="form1-tab" data-toggle="tab" href="#form1" role="tab" aria-controls="form1" aria-selected="true">国家信息</a></li>
                            <li class="nav-item"><a class="glyphicon glyphicon-user nav-link" id="form2-tab" data-toggle="tab" href="#form2" role="tab" aria-controls="form2" aria-selected="true"  >用户信息</a></li>
                            <li class="nav-item"><a class="glyphicon glyphicon-envelope nav-link" id="form3-tab" data-toggle="tab" href="#form3" role="tab" aria-controls="form3" aria-selected="true">用户反馈</a></li>
                        </ul>
                    </div>
                </header>



                <article class="col-md-10 tab-content">
                    <!--替换部分-->
                    <div class="tab-pane active" id="form1" role="tabpanel" aria-labelledby="form1-tab">

                        <div class="serach">                        
                            <nav class="navbar navbar-light bg-light">
                                <form class="form-inline"  action="QueryCountryByPageServlet" method="post">
                                    <input class="form-control" type="search" placeholder="Search" aria-label="Search"  name="country_search" id="country_search">
                                    <button class="btn btn-outline-success" type="submit">Search</button>
                                </form>
                            </nav>
                        </div>
                        
                        <div class="add_country">
	                        	<button type="button" class="btn btn-dark"><a class="glyphicon glyphicon-plus" href="addCountry.jsp"></a></button>
	                    </div>
                        
                        <div class="form">
                            <table class="table table-dark">
                                <thead>
                                <tr>
                                    <th scope="col">国旗</th>
                                    <th scope="col">国家</th>
                                    <th scope="col">英文</th>
                                    <th scope="col">首都</th>
                                    <th scope="col">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                	<!-- 为了让联合国置顶 -->
	                                <tr class="special_UN">
	                                    <td><img src="css/img/UN.png" class="img-responsive" width="60"></td>
	                                    <td>联合国</td>
	                                    <td>United Nations</td>
	                                    <td>美国-纽约-联合国总部大楼 </td>
	                                    <td>
												<a href="QueryCountryByEn_nameServlet?en_name=United Nations&currentPage=1"><button type="button" class="btn btn-info" >详情</button></a>
                                        		<button type="button" class="btn btn-danger" value="United Nations" onclick="javascript:delete1(this.value);">删除</button>
										</td>
	                                </tr>
                                <%
                                //如果获取不到登录管理员信息，就重定向到登录页
	                    			if(ad_name==null){
	                    				request.getSession().invalidate();
	                    				response.sendRedirect("index.jsp");
	                    			}
	                    			else{

									//获取request域中的数据
						
									Page page1 = (Page) request.getAttribute("page1");
									if(page1!=null)
									{	
									for(Country country:page1.getCountries()){
										%>
										<tr>
											<td><img src=<%=country.getFlag() %> class="img-responsive" width="60"></td>
											<td><%=country.getCn_name()%></td>
											<td><%=country.getEn_name()%></td>
											<td><%=country.getCapital()%></td>
											<td>
												<a href="QueryCountryByEn_nameServlet?en_name=<%=country.getEn_name()%>&currentPage=<%=page1.getCurrentPage()%>"><button type="button" class="btn btn-success">详情</button></a>
                                        		<button type="button" class="btn btn-danger" value="<%=country.getEn_name()%>" onclick="javascript:delete1(this.value);">删除</button>
											</td>
										</tr>
									<% 	}         %>   
							  </tbody>
			                </table>
			            </div>
								<%if(page1.getTotalPage()>1){
									if(page1.getCurrentPage()==1){%>
										<div class="page">
				                        	<nav aria-label="Page navigation example">
											  <ul class="pagination">
											  	<li class="page-item"><a class="page-link" href="QueryCountryByPageServlet?currentPage=1">First</a></li>
											    <li class="page-item"><a class="page-link" href="QueryCountryByPageServlet?currentPage=<%=page1.getCurrentPage()+1 %>">Next</a></li>
											    <li class="page-item"><a class="page-link" href="QueryCountryByPageServlet?currentPage=<%=page1.getTotalPage() %>">Last</a></li>
											  </ul>
											</nav>
			                        	</div>
			                        	
										<% }else if(page1.getCurrentPage()==page1.getTotalPage()){%>
										<div class="page">
		                        			<nav aria-label="Page navigation example">
									  			<ul class="pagination">
									  				<li class="page-item"><a class="page-link" href="QueryCountryByPageServlet?currentPage=1">First</a></li>
									    			<li class="page-item"><a class="page-link" href="QueryCountryByPageServlet?currentPage=<%=page1.getCurrentPage()-1 %>">Previous</a></li>
									    			<li class="page-item"><a class="page-link" href="QueryCountryByPageServlet?currentPage=<%=page1.getTotalPage()%>">Last</a></li>
									  			</ul>
											</nav>
			                        	</div>
										<% }else{%>
										<div class="page">
		                        			<nav aria-label="Page navigation example">
									  			<ul class="pagination">
									  				<li class="page-item"><a class="page-link" href="QueryCountryByPageServlet?currentPage=1">First</a></li>
									    			<li class="page-item"><a class="page-link" href="QueryCountryByPageServlet?currentPage=<%=page1.getCurrentPage()-1 %>">Previous</a></li>
									    			<li class="page-item"><a class="page-link" href="QueryCountryByPageServlet?currentPage=<%=page1.getCurrentPage()+1 %>">Next</a></li>
									    			<li class="page-item"><a class="page-link" href="QueryCountryByPageServlet?currentPage=<%=page1.getTotalPage() %>">Last</a></li>
									  			</ul>
											</nav>
			                        	</div>
											
									<%	}	}
									}else{
										//否则就去查询国家列表
										//request.setAttribute("ad_name", ad_name);//为了防止用户名失效，得传一下用户名
										//response.sendRedirect("QueryCountryByPageServlet");
										request.getRequestDispatcher("QueryCountryByPageServlet?currentPage=1").forward(request, response);
									}
	                    			}
								%>
                    </div>

<!-- 第二界面了——用户信息 -->
                    <div class="tab-pane" id="form2" role="tabpanel" aria-labelledby="form2-tab">
                       <!-- 右侧内容 -->
					        <div class="main_right">
					            <iframe frameborder="0" scrolling="no" src="userinfo.jsp" style="width: 100%;height:100%"  id="user_info"></iframe>
					        </div>
                       
                    </div>
                    
      <!-- 第三个界面——反馈信息 -->              
                    <div class="tab-pane" id="form3" role="tabpanel" aria-labelledby="form3-tab">
                        <h3><font color="#ff7f50" >客官，还没有用户留言呢！</font></h3>
                    </div>

                </article>
            </div>
        </div>


<script>
    $(function () {
        $('#myTab li:first-child a').tab('show')
    })
</script>

 <script>
        $(function(){
            $(".left li").on("click",function(){
                var address =$(this).attr("data-src");
                $("iframe").attr("src",address);
            });
        });
    </script>

</body>
</html>
