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
 

</head>
 
 <%
String errorMessage="";
if(request.getAttribute("message")!=null)
{
errorMessage=request.getAttribute("message").toString(); 
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
 
				<div class="rb-title">Error!</div>
 
			</div>
 
			<div class="rb-mid">
 
				<div class="rb-info">
 
		
<table align="center">
<tr><td>
</td>
<td><font color="red"><%=errorMessage %></font>
</td></tr>
</table>
 
		
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
 

