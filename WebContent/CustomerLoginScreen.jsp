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

 <script type="text/javascript">
var a;var b;var c;


function userCheck()
{
		var pattern=/^[A-Za-z0-9 ]{3,20}$/;
	
		if(pattern.test(document.getElementById('user').value))
			{
				a=true;
				document.getElementById('usermsg').style.visibility='hidden';
				
			
			}
		else
			{
			{
				a=false;
				document.getElementById('usermsg').style.visibility='visible';
				
			
			}
			}
}
function passwordCheck()
{
		var pattern=/^[A-Za-z0-9]*[#][A-Za-z0-9]*$/;
		var pattern1=/^[A-Za-z0-9#]{4,8}$/;
	
		if(pattern.test(document.getElementById('pass').value)&&pattern1.test(document.getElementById('pass').value))
			{
				b=true;
				document.getElementById('passmsg').style.visibility='hidden';
				
			
			}
		else
			{
			{
				b=false;
				document.getElementById('passmsg').style.visibility='visible';
				
			
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
 
 
	</div>
 
	
	<div id="right-column">
 

 
		<div class="right-block">
 
			<div class="rb-top">
 
				<div class="rb-title">Welcome To Login</div>
 
			</div>
 
			<div class="rb-mid">
 
				<div class="rb-info">
 <form action="CustomerscreenController" method="post">
<table align="center">
		<tr>
			<td><font size=04 >Login ID:</font></td>
			<td><font size=04 ><input type=text name="id" id="user" onblur="userCheck();"></font></td>
			<td id="usermsg" style="visibility: hidden;"><font size=04 color="red" >Invalid User Name</font></td>	
		</tr>
		<tr>
			<td><font size=04 >Password:</font></td>
			<td><input type=password name=passwd id="pass" onblur="passwordCheck();"></td>
			<td id="passmsg" style="visibility: hidden;"><font size=04 color="red" >Invalid password-use of # must</font></td>
		</tr>

<tr>
		 	<td><font size=04 >Feedback Type</font></td>
			<td>
			<select name="feedbackrequest">
			<option value="General Feedback" >General Feedback</option>
			<option value="Game Request" >Game Request</option>
			</select>
			</td>
</tr>
		
		
		<tr><td><input type="submit" value="Login"></td>
		<td><input type="reset" value="Reset"></td></tr>
		
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
 

