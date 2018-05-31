<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 
<html xmlns="http://www.w3.org/1999/xhtml">
 
<head>
 
 
 
<meta content="text/html; charset=windows-1252" http-equiv="Content-Type" />
 
 
 
<!-- SEO RELATED META TAGS -->
 
<title>Zoid CSS Gaming Website Theme and Template - High Tech</title>
 
<meta name="revisit" content="2 days"></meta>
 
<meta name="robots" content="all, index, follow"></meta>
 
<meta name="description" content="" />
 
<meta name="keywords" content="" />
 
<link rel="canonical" href="#" />
 
 
 
<!-- META TAGS -->
 
<meta content="english" name="language"/>
 
<meta content="public" http-equiv="cache-control"/>
 
 
 
 
 
<!-- CSS FILES -->
 
<link href="css/zoid-stylesheet.css" rel="stylesheet" type="text/css" />
 
 
 
 
 
<!-- JAVASCRIPT FILES -->
 
<script type="text/javascript" src="js/clock.js"></script>
 
 
 
<!-- GOOGLE FONT -->
 
<link href='http://fonts.googleapis.com/css?family=Aldrich' rel='stylesheet' type='text/css'/>
 
 
 
<!-- EMAIL FILES -->
 
<link type="text/css" rel="stylesheet" href="css/public.css"/>
 
<script type="text/javascript" src="js/jquery-1.6.4.min.js"></script>
 
<script type="text/javascript" src="js/jquery.simpleContactForm.js"></script>
 
<script type="text/javascript" src="js/jquery.simpleContactForm_min.js"></script>
 
<script type="text/javascript" > 
 
    $(window).ready(function() {
 
        $('form').simpleContactForm();
 
    });
 
</script>
 
 
 
 
 
 
 
</head>
 
 
 
 <script type="text/javascript">
var a;var b;var c;


function feedCheck()
{
		var pattern=/^[A-Za-z0-9 ]{10,}$/;
	
		if(pattern.test(document.getElementById('feed').value))
			{
				a=true;
				document.getElementById('feedmsg').style.visibility='hidden';
				
			
			}
		else
			{
			{
				a=false;
				document.getElementById('feedmsg').style.visibility='visible';
				
			
			}
			}
}

</script>
 
 
 
 
 
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
 
				<div class="rb-title"></div>
 
			</div>
 
			<div class="rb-mid">
 
				<div class="rb-info">
 
					<form action="FeedBackController" method="post">
<h1><font size=5 color="yellow"><i>Thank you for choosing to send us 
your valuable feedback.</i></font></h1>
<p align=justify style="font-size:22px"><i>
<font color="yellow">You are encouraged to use the online feedback form below to
<br><br> send us your valuable comments and requests. as well as </font></i></p>

<br>
<br>

<table  align="center" width="400">

<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr><td><font size=04 color="blue">Welcome</font></td><td><%=session.getAttribute("feedback") %></td></tr>
<tr><td><font size=04 color="blue">Request Type</font></td><td><%=session.getAttribute("game") %></td></tr>
<tr><td><font size=04 color="blue">Suggestion Id</font></td><td><%=session.getAttribute("suggest") %></td></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
</table>

<br>
<br>
<br>
<br>


<table align="left" width="400">

<tr><td colspan=50><p><font size=04 color="white"><b>Please give us your valuable FeedBack:</b></font></td><td>
<textarea rows="5" cols="40" id="feed" name="text" onblur="feedCheck();"></textarea></td>
<td id="feedmsg" style="visibility: hidden;"><font size=04 color="red" >Enter at least 10 characters</font></td>
</tr>


<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>


<tr><td colspan=50><p><font size=04 color="white"><b>Please Enter the Requested Game Name:</b></font></td><td>
<font color="grey"><input type="text" name="name" disabled="disabled" style="color:grey" onkeypress="Function1();"></font></td></tr>


<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>

<tr><td colspan=50><p><font size=04 color="white"><b>Please Enter the Publisher Name:</b></font></td><td>
<input type="text" name="name" disabled="disabled" style="color:grey" onkeypress="Function1();"></td></tr>

<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>


<tr><td colspan=50><font size=04 color="white"><b>Please enter Description of the game:</b></font> </td><td>
<input type="text" name="name" disabled="disabled" style="color:grey" onkeypress="Function();"></td></tr>


<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>

<tr><td><input type="submit" value="Submit"></td>
<td><input type="reset" value="Reset"></td></tr>
</table>
</form>
<script language="javascript">
function Function1()
{
	var n=document.form.name.value;
if(n<=10000)
	{
	document.form.name.isdisabled=true;

	}
else
	{
	document.form.name.isdisabled=false;

	}
	}
</script>
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
 

