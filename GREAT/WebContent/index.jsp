<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="js/jquery-3.5.0.js"></script>
    <script type="text/javascript">

        function reloadCheckImg() {
            $("img").attr("src", "checkcode.jsp?t=" + (new Date().getTime()));//需加个东西让服务端知道每次请求不一样
        }

        //验证管理员
        $(document).ready(function () {
            $("#administrator").blur(function () {
                var $ad = $("#administrator").val();
                $.post(
                    "QueryAdministratorByIdServlet",
                    "ad=" + $ad,
                    function (result) {
                        if (result == "true")
                            $("#flag").text("");
                        else
                            $("#flag").text("抱歉，查询不到此管理员!");
                    }
                );
            });
        });

        
        var temp="";	//用于保存密码
        
        //验证管理员的密码(用弹窗展示)
         $(document).ready(function () {
            $("#password").blur(function () {
                var add = $("#administrator").val();
	               
	       		$.ajax({
	    			url:"QueryAdministratorByIdServlet",
	    			type:"post",
	    			data:"ad_check="+add,
	    			success:function(result,testStatus)
	    			{
	    				temp = result;
	    			},
	    			error:function(xhr,errorMessage,e){
	    				//alert("系统异常!");
	    				temp = "!%(!&!^^^$&qwefgu)(*^$@)";
	    			}
	    		});
            });
        });
        
     
        var systemcheckcode = "";//用于保存系统验证码
        
        function check(){
			var pwd = $("#password").val();
			var $checkcode = $("#checkcodeId").val();
			if($checkcode == systemcheckcode){
				if(pwd==temp){
	       			return true;
				}
	       		else{
	       			alert("密码错误!");
	       			return false;
	       		}
			}
			else{
				alert("验证码错误!");
				return false;
			}
		}


        //验证码
        $(document).ready(function () {
            $("#checkcodeId").blur(function () {
                var $checkcode = $("#checkcodeId").val();
                //校验：文本框中输入的值  发送到服务端
                //服务端：获取文本框输入的值，和真实验证码图片中的值对比，并返回验证结果
                $.post(
                    "CheckCodeServlet",
                    "checkcode=" + $checkcode,
                    function (result) {
                        if (result == $checkcode){
                            $("#flag").text("");
                            systemcheckcode = result;
                            }
                        else{
                            $("#flag").text("抱歉，验证码错误!");
                            systemcheckcode = result;
                           }
                    }
                );
            });
        });

        </script>
        
        <!-- 退出登录后让浏览器后退按钮失效-->
        
        <script type="text/javascript">
        $(function(){
        		　　if(window.history && window.history.pushState){
        		　　		$(window).on("popstate", function(){
        			　　		window.history.pushState("forward", null, "#");
        			　　		window.history.forward(1);
        		　　		});
        		　　}
        		　　window.history.pushState("forward", null, "#"); //在IE中必须得有这两行
        		　　window.history.forward(1);
        		});
        </script>
 
        
    

    <title>登录</title>
    <link rel="stylesheet" href="css/style_login.css" type="text/css"/>
</head>


<body>
<div class="login-box">
    <h2>GREAT's&nbsp&nbspManagement&nbsp&nbspSystem</h2>
    <form  action="main.jsp" onsubmit="return check()" method="post">
        <div class="login-field">
            <input type="text" name="administrator" required="" id="administrator"> <label>Administrator</label>
        </div>
        <div class="login-field">
            <input type="password" name="password" required="" id="password"> <label>Password</label>
        </div>

        <div class="login-field">
            <!--验证码-->
            <input class="checkcode" type="text" name="checkcode" id="checkcodeId" size="4" required=""> <label>Checkcode</label>
            <a href="javascript:reloadCheckImg();"><img src="checkcode.jsp" title="点击图片，换一张"/></a>
        </div>

        <div class="flag1">
            <span id="flag"></span>
        </div>

        <div class="login-submit" type="submit">
            <button type="submit" name="" value="submit">Login</button>
        </div>
    </form>
</div>
<%
		

%>
</body>
</html>