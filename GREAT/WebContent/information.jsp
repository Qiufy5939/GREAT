<%@page import="org.great.entity.TreatedInfo"%>
<%@page import="org.great.entity.MyEntity"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.great.entity.UntreatedInfo"%>
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
    <link rel="stylesheet" href="css/style_information.css">
    <title>Information!</title>
    
<script type="text/javascript">

</script>
</head>
<body>
<%
			/*String ad_name = request.getParameter("administrator");
			if(ad_name==null){//为了防止获取方式不同而获取不到
				ad_name = (String)request.getAttribute("administrator");
			}*/
			String ad_name = (String)session.getAttribute("administrator");
			
            //如果获取不到登录管理员信息，就重定向到登录页
    			if(ad_name==null){
    				request.getSession().invalidate();
    				response.sendRedirect("index.jsp");
    			}else{
    				
    				//获取request域中的数据
    				MyEntity myEntity = (MyEntity)request.getAttribute("MyEntity");
    				
%>
<nav class="navbar navbar-inverse nav-pills">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <!--<span class="sr-only">Toggle navigation</span>-->
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
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%=ad_name %><span class="caret"></span></a>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton" role="menu">
                    	<li><a href="main.jsp" class="glyphicon glyphicon-home">主界面</a></li>
                        <li><a href="LogOutServlet" class="glyphicon glyphicon-off">登出</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->

    </div><!-- /.container-fluid -->
</nav>

<div class="container">
	<div class="title1"><h2>管 理 员 信 息（未处理）</h2></div>
 		<div class="form">
                            <table class="table table-dark">
                                <thead>
                                <tr>
                                	<th scope="col">ID</th>
                                	<th scope="col">处理状态</th>
                                    <th scope="col">类型</th>
                                    <th scope="col">操作者</th>
                                    <th scope="col">时刻</th>
                                    <th scope="col">操作</th>
                                    <th scope="col">确认</th>
                                </tr>
                                </thead>
                          
                          		<tbody>
                      <%
                      		if(myEntity!=null)   
                      		{
                      			List<UntreatedInfo> untreatedInfos = myEntity.getUntreatedInfos();
                         	for(UntreatedInfo untreatedInfo:untreatedInfos){
                         		%><tr>
                                	<th scope="row"><%=untreatedInfo.getId() %></th>
                                	<th scope="row" class="status1">未处理</th>
                                	
                                	<% if("国家信息".equals(untreatedInfo.getType())){ %>
                                    <th scope="row" class="status3">国家信息</th>
                                    <td><%=untreatedInfo.getAdministrator() %></td>
                                    <td><%=untreatedInfo.getTime() %></td>
                                    <td><%=untreatedInfo.getOperation() %></td>
                                    <td>
                                    	<% if(ad_name.equals(untreatedInfo.getAdministrator())){%>
                                    		<button type="button" class="btn btn-info">申请者无权审核</button>
                                    	<% }else{ %>
                                        <a href="AgreeDeleteCountryServlet?id=<%=untreatedInfo.getId()%>" onClick="return confirm('确定【删除】该国家?');"><button type="button" class="btn btn-success" >同意</button></a>
                                        <a href="DisagreeDeleteCountryServlet?id=<%=untreatedInfo.getId()%>" onClick="return confirm('【不同意】该申请?');"><button type="button" class="btn btn-danger">不同意</button></a>
                                        <% } %>
                                    </td>
                                    <%}else{ %>
                                    <th scope="row" class="status4">用户信息</th>
                                    <td><%=untreatedInfo.getAdministrator() %></td>
                                    <td><%=untreatedInfo.getTime() %></td>
                                    <td><%=untreatedInfo.getOperation() %></td>
                                    <td>
                                    	<% if(ad_name.equals(untreatedInfo.getAdministrator())){%>
                                    		<button type="button" class="btn btn-warning">操作者无权解除</button>
                                    	<% }else{ %>
                                        <a href="DisagreeLockUserServlet?id=<%=untreatedInfo.getId()%>" onClick="return confirm('确定【解除冻结】该用户?');"><button type="button" class="btn btn-success" >解除锁定</button></a>
                                        <a href="AgreeLockUserServlet?id=<%=untreatedInfo.getId()%>" onClick="return confirm('确定【永久封锁】该用户?');"><button type="button" class="btn btn-danger" >永久封号</button></a>
                                        <% } %>
                                    </td>
                                    <%}%>
                                </tr>
                         <% 	}	%>
                                </tbody>
                            </table>
		</div>
	
	<div class="title2"><h2>管 理 员 信 息（已处理）</h2></div>
 		<div class="form">
                            <table class="table table-dark">
                                <thead>
                                <tr>
                                	<th scope="col">ID</th>
                                	<th scope="col">处理状态</th>
                                	<th scope="col">类型</th>
                                    <th scope="col">内容</th>
                                    <th scope="col">申请者</th>
                                    <th scope="col">申请时刻</th>
                                    <th scope="col">审核者</th>
                                    <th scope="col">审核时刻</th>
                                    <th scope="col">处理结果</th>
                                </tr>
                                </thead>
                                <tbody>
                           <% 
                           		List<TreatedInfo> treatedInfos = myEntity.getTreatedInfos();
                         		for(TreatedInfo treatedInfo:treatedInfos){
                         %>
                                <tr>
                                	<th scope="row"><%=treatedInfo.getId() %></th>
                                	<th scope="row" class="status2">已处理</th>
                                	
                                	<% if("国家信息".equals(treatedInfo.getType())){ %>
                                    <th scope="row" class="status3">国家信息</th>
                                    <%}else{ %>
                                    <th scope="row" class="status4">用户信息</th>
                                    <%}%>
                                    
                                    <td><%=treatedInfo.getContent() %></td>
                                    <td><%=treatedInfo.getApplicant() %></td>
                                    <td><%=treatedInfo.getApplication_date() %></td>
                                    <td><%=treatedInfo.getChecker() %></td>
                                    <td><%=treatedInfo.getCheck_date() %></td>
                                    <%
                                    	if("同意".equals(treatedInfo.getResult()) || "解除锁定".equals(treatedInfo.getResult())){	%>
                                    		<th scope="row" class="status2"><%=treatedInfo.getResult() %></th>
                                    <% }else if("不同意".equals(treatedInfo.getResult()) || "永久封号".equals(treatedInfo.getResult())){%>
                                    		<th scope="row" class="status1"><%=treatedInfo.getResult() %></th>
                                    <%  }else{ %>
                                    		<th scope="row" class="status3">处理异常</th>
                                    <% }%>
                                </tr>
                          <%
                         		}
                          %>
                                </tbody>
                            </table>
		</div>
</div>


<% 
}else{
	//否则就去查询信息列表
	//request.setAttribute("ad_name", ad_name);//为了防止用户名失效，得传一下用户名
	request.getRequestDispatcher("QueryUntreatedInfoServlet").forward(request, response);
}
}
%>
</body>
</html>