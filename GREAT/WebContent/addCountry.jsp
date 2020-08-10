<%@page import="org.great.entity.Country"%>
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
    <link rel="stylesheet" href="css/style_addCountry.css">
    <title>Add_Country!</title>

<script type="text/javascript">
	function check(){
			var r = confirm("请确保您的信息准确无误！并愿意承担错误信息所引起的后果！")
		  if (r==true)
		    {
		    	return true;
		    }
		  else
		    {
		    	return false;
		    }
}
	
	
	
    function changepic() {

        var reads= new FileReader();

        f=document.getElementById('file').files[0];

        reads.readAsDataURL(f);

        reads.onload=function (e) {

            document.getElementById('show').src=this.result;

        };

    }
 </script>

</head>
<body>
<%				
			
			String ad_name = (String)session.getAttribute("administrator");
			
            //如果获取不到登录管理员信息，就重定向到登录页
    			if(ad_name==null){
    				request.getSession().invalidate();
    				response.sendRedirect("index.jsp");
    			}
         
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
                    	<li><a href="main.jsp?administrator=<%=ad_name%>" class="glyphicon glyphicon-home">主界面</a></li>
                        <li><a href="information.jsp" class="glyphicon glyphicon-bell">信息中心</a></li>
                        <li><a href="LogOutServlet" class="glyphicon glyphicon-off">登出</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->

    </div><!-- /.container-fluid -->
</nav>


<!-- 通过表单展示此人信息country.getEn_name() %>-->


<div class="container">	
		<form action="AddCountryServlet" method="post" onsubmit="return check()"  enctype="multipart/form-data">
				
				<div class="title col-md-12">
					<li><input  type="text" name="en_name" placeholder="单击我！输入国家官方英文名" required/></li>
				</div>
				<br/>
				<div class="detail col-md-12">
					<div class="col-md-7">
						<li>中文：<input type="text" name="cn_name" placeholder="在此输入国家中文名" required/></li>
						<li>首都：<input type="text" name="capital" placeholder="在此输入国家首都" required/><li>
						<li>简介：<textarea name="introduction"  id="introduction" required>这是一个充满活力的国度！</textarea></li>
					</div>	
					<div class="col-md-5">
						<img src="" id="show" class="img-responsive">	
						<li>上传国旗：<input type="file" id="file" accept="image/png, image/jpeg, image/gif, image/jpg" name="flag" onchange="changepic(this)" required/></li>
					</div>
				</div>
				<br/>
		
				<div class="twobutton col-md-12">
					<a href="main.jsp"><button type="button" class="btn btn-danger">返回主界面</button></a>
					<button type="submit" class="btn btn-success">确认添加</button>
				</div>
		</form>
</div>


</body>
</html>