<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 
<html xmlns="http://www.w3.org/1999/xhtml">
 
<head>

 <%
	String message="";
	if(request.getAttribute("message")!=null)
	{
		message=request.getAttribute("message").toString();
	}
%>

<meta content="text/html; charset=windows-1252" http-equiv="Content-Type" />
 
 
 
<!-- SEO RELATED META TAGS -->
 
<title>Cyber Game Center</title>
 
 
<!-- META TAGS -->
 
<meta content="english" name="language"/>
 
<meta content="public" http-equiv="cache-control"/>
 <script src="jquery-1.6.2.min.js"></script>

<script src="jquery-ui-1.8.15.custom.min.js"></script>

<link href="jqueryCalendar.css"  rel="stylesheet" type="text/css"/>

<script>

jQuery(function() {

var format={
dateFormat:"dd-mm-yy" ,
changeMonth: true,
changeYear: true,
showOn: "button",
buttonImage: "calendar.bmp",
buttonImageOnly: true
};

jQuery( "#datepicker" ).datepicker(format);
jQuery( "#datepicker1" ).datepicker(format);

});

</script>
<!-- CSS FILES -->
 
<link href="css/zoid-stylesheet.css" rel="stylesheet" type="text/css" />
</head>

 
 
 
<body>
 
 
<h3><font color="red" align="center"> <%=message %></font></h3>
 
 
<div id="Header">
 
	<div id="Banner">
 
		
 
		<div id="tag">=ZOID=</div>
 
		
 
 
 
		<div id="hz-menu">
 
			<ul>
 
				<li><a class="hbutton" href="main.jsp">Home</a></li>

				<li><a class="hbutton" href="login.jsp">Add game</a></li>

				<li><a class="hbutton" href="#">Sign Up</a></li>

				<li><a class="hbutton" href="searchcontroller3?action=search">Search</a></li>

				<li><a class="hbutton" href="CustomerLoginScreen.jsp">Feedback</a></li>

				<li><a class="hbutton" href="#">Buy games</a></li>
 
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
 
				<div class="rb-title">Game Registration</div>
 
			</div>
 
			<div class="rb-mid">
 
				<div class="rb-info">
 
				<form action="regController" method="post">
<center>
<table>
<tr>
<td>Game Title</td>
<td><input type="text" name="gametitle" id="gametitle"/></td>
<td><span id="titleError" style="color:red"></span></td>

</tr>

<tr>
<td>Company</td>
<td><input type="text"  name="company" id="company"/></td>
<td><span id="companyError" style="color:red"></span></td>
</tr>

<tr>
<td>Game Release Date</td>
<td><input type="text"  name="datepicker" id="datepicker"/></td>
<td><span id="releaseError" style="color:red"></span></td>
</tr>

<tr>
<td>Game Type</td>
<td><select name="gametype" > 
<option value="select">select</option> 
<option value="ACT">ACT</option>
<option value="STR">STR</option>
<option value="SIM">SIM</option>
</select></td>
</tr>

<tr>
<td>Game Base Price</td>
<td><input type="text" name="price" id="price"/></td>
<td><span id="priceError" style="color:red"></span></td>
</tr>

<tr>
<td>Installation Date</td>
<td><input type="text"  name="datepicker1" id="datepicker1"/></td>
<td><span id="installationError" style="color:red"></span></td>
</tr>

<tr>
<td>Valid Year</td>
<td><input type="text"  name="validyear" id="valid_year"/></td>
<td><span id="validError" style="color:red"></span></td>
</tr>

<tr>
<td>Game Rating</td>
<td><select name="gamerating">
<option value="select">select</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
</select></td>
</tr>

</table>
<button onclick="return validate()">Submit</button>&nbsp;&nbsp; <button>Reset</button>
</form>
</center>
 
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
 

