
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



<script language="javascript" type="text/javascript">
function clear()
{
	
document.getElementsByName("playerid").value="";
document.getElementsByName("playerpswd").value="";
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

				<div class="rb-title">Buy Games</div>

			</div>

			<div class="rb-mid">

				<div class="rb-info">
<form action="SellGameController?action=registereduser" method="post">

<%
String message="";

if(request.getAttribute("message")!=null)
 message=request.getAttribute("message").toString();

%>

<p align="right"><a href='SellGameController?action=guestuser'>Guest User</a></p>

<table cellspacing="20" >

<tr align="center" ><font color="red"><%=message %></font></tr>
<tr><td>Player Id :</td><td></td><td><input type="text" name="playerid" /></td></tr>

<tr><td>Player Password :</td><td></td><td><input type="password" name="playerpswd"/></td></tr>

<tr><td align="right" class="columnstyle"><input type="submit" name="submit" value="Submit"/></td>
<td></td><td align="left" class="columnstyle"><input type="reset" name="reset" value="Reset"/></td></tr>

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

