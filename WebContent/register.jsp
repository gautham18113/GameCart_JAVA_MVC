<%@page import="com.catp.cgc.vo.*"%>
<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 
<html xmlns="http://www.w3.org/1999/xhtml">
 
<head>
 
 
 
<meta content="text/html; charset=windows-1252" http-equiv="Content-Type" />
 
 
<title>Cyber Game Center</title>

<!-- META TAGS -->
 
<meta content="english" name="language"/>
 
<meta content="public" http-equiv="cache-control"/>
 
<!-- CSS FILES -->
 
<link href="css/zoid-stylesheet.css" rel="stylesheet" type="text/css" />
 
 
<!-- JAVASCRIPT FILES -->
 
<script type="text/javascript" src="js/clock.js"></script>


<script type="text/javascript" src="script\validation.js"></script>
</head>
 
 
 
 
 <%
String message="";
if(request.getAttribute("message")!=null)
{
message=request.getAttribute("message").toString();
}
%>
 
 
 
 
<body>


<div id="Header">
 
	<div id="Banner">
 
		<div id="tag">==</div>
 
		<div id="hz-menu">
 
			<ul>
 
				<li><a class="hbutton" href="main.jsp">Home</a></li>

				<li><a class="hbutton" href="login.jsp">Add game</a></li>

				<li><a class="hbutton" href="register.jsp">Sign Up</a></li>

				<li><a class="hbutton" href="searchcontroller3?action=search">Search</a></li>

				<li><a class="hbutton" href="CustomerLoginScreen.jsp">Feedback</a></li>

				<li><a class="hbutton" href="SellGameLogin.jsp">Buy games</a></li>
			</ul>
 
		</div>

	</div>
 
</div>
 
<div id="main-top"></div>
 
<div id="main-mid">
 
 
 
	<div id="left-column">
 
		<div class="left-block">
 
			<div class="lb-top">
 
				<div class="lb-title">Earth Time</div>
 
			</div>
 
			<div class="lb-mid">
 
				<div class="lb-info">
 
				
 
					<div class="sb-clock">
 
						<script type="text/javascript">new imageclock.display()</script>
 
					</div>
 
	
 
				</div>
 
			</div>
 
			<div class="lb-btm"></div>
 
		</div>
 
		<div class="left-block">
 
			<div class="lb-top">
 
				<div class="lb-title">MP3 Player</div>
 
			</div>
 
			<div class="lb-mid">
 
				<div class="lb-info">
 
					<object id="flash1" data="pi.swf" type="application/x-shockwave-flash" width="210" height="140" style="margin:0px auto 0px auto; padding:0px">
 
						<param name="movie" value="pi.swf" />
 
						<param name="quality" value="Best" />
 
						<param name="wmode" value="transparent" />
 
					</object>
 
				</div>
 
			</div>
 
			<div class="lb-btm"></div>
 
		</div>

 
	</div>
 
 
	<div id="right-column">
 
	
 
		<div class="right-block">
 
			<div class="rb-top">
 
				<div class="rb-title">Player Registration</div>
 
			</div>
 
			<div class="rb-mid">
 
				<div class="rb-info">
				<h3 align="center"><font color="red"><%=message %></font></h3> 
 
	<form action="PlayeridController" method="post">
		<table align="center" cellspacing="20" >
			<tr>
				<td colspan="2">
				<td>
			</tr>
			<tr>
          
				<td>PlayerName</td>                                  <%-- It Creates Column For PlayerName As Label --%>
				<td><input type="text" name="playername">            <%--It Creates TextBox To Enter The PlayerName  --%>
				</td>
				<td><span id="playerror" style="color: red;"></span>
				</td>
			</tr>
			<tr>
				<td>PlayerAge</td>                                    <%-- It Creates Column For PlayerAge As Label --%>
				<td><input type="text" name="playerage" id="age">     <%--It Creates TextBox To Enter The Age --%>
				</td>
				<td><span id="ageerror" style="color: red;"></span>
				</td>

			</tr>
			<tr>
				<td>PlayerEmail</td>                                    <%-- It Creates Column For PlayerEmail As Label --%>
				<td><input type="text" name="playeremail" id="email">   <%--It Creates TextBox To Enter The PlayerEmail  --%>
				</td>
				<td><span id="emailerror" style="color: red;"></span> 
				</td>
			</tr>
			<tr>
				<td>PlayerAddress</td>                                    <%-- It Creates Column For PlayerAddress As Label --%>
				<td><input type="text" name="playeraddress" id="address"> <%--It Creates TextBox To Enter The PlayerAddress  --%>
				</td>
				<td><span id="addresserror" style="color: red;"></span>
				</td>
			</tr>
			<tr>
				<td>PlayerContact</td>                                      <%-- It Creates Column For PlayerAddress As Label --%>
				<td><input type="text" name="playercontact" id="contact">   <%--It Creates TextBox To Enter The PlayerContact  --%>
				</td>
				<td><span id="contacterror" style="color: red;"></span>
				</td>
			</tr>
			<tr>
<tr><td>Duration</td><td><input type="radio" name="duration" value="100">100</td></tr>
<tr><td></td><td> <input type="radio" name="duration" value="200">200</td></tr>
<tr><td></td><td> <input type="radio" name="duration" value="300">300</td></tr>
<tr><td></td><td> <input type="radio" name="duration" value="400">400</td></tr>
				</select></td>
			</tr>
			<tr>
				<td>PlayerPassword</td>                                         <%-- It Creates Column For PlayerPassword As Label--%>
				<td><input type="password" name="password" id="password">       <%--It Creates PasswordBox To Enter The PlayerPassword--%>
				</td>
				<td><span id="passworderror" style="color: red;"></span>        
				</td>
			</tr>
			<tr><td>Gender</td><td><input type="radio" name="gender" value="male">Male</td></tr>
<tr><td></td><td> <input type="radio" name="gender" value="female">Female</td></tr>

			<tr>
			<tr><td>Player Age Group</td><td><input type="radio" name="agegroup" value="kids">kids</td></tr>
<tr><td></td><td> <input type="radio" name="agegroup" value="teenagers">teenagers</td></tr>
<tr><td></td><td> <input type="radio" name="agegroup" value="grownups">grown ups</td></tr>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"                         <%-- It Creates Submit Button To Generate Player_id --%>
					onclick="return validate()"></td>
				<td><input type="reset" value="reset"></td>
			</tr>
		</table>
	</form>
				</div>
 
			</div>
 
			<div class="rb-btm"></div>
 
		</div>
 
 
	</div>
 
	
 
	<div class="clearB"></div>
 
 
 
</div>
 
 
<div id="main-btm"></div>
 
 
 
<div id="footer">
 
 
 
	<div id="footer-mid">
 
	
 
		<div id="ft-left-column">
 
	
 
			<div id="ft-lt-info">
 
			</div>
 
		</div>
 
			
 
		<div id="ft-right-column">
 
			<div id="ft-rt-info">
 
			
 
				<div class="floatR">
 
					<img alt="Droid Icon" src="theme/icon-droid.fw.png" width="220px" height="205px" />
 
				</div>
 
			
 
				<div class="clearR"></div>
 
			
 
			</div>
 
		
 
		</div>
 
			
 
		<div class="clearB"></div>
 
	</div>
 
</div>
 
</body>
 

 
</html>
 

