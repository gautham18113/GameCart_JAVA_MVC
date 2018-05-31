<%@page import="com.catp.cgc.controller.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<script type="text/javascript">
function check()
{
	var x=0;
var group = document.myForm.radio;
for (var i=0; i<group.length; i++) {
if (group[i].checked)
break;
}
if (i==group.length)
{
	document.write("Select a radio button!");
}	
}
</script>
<meta content="text/html; charset=windows-1252" http-equiv="Content-Type" />
<!-- SEO RELATED META TAGS -->

<title>Cyber Game Center</title>

<!-- CSS FILES -->

<link href="css/zoid-stylesheet.css" rel="stylesheet" type="text/css" />





<!-- JAVASCRIPT FILES -->

<script type="text/javascript" src="js/clock.js"></script>


</head>


<%String message="";
if(request.getAttribute("message4")!=null)
{
	message=request.getAttribute("message4").toString();
}%>


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

			</div>

			<div class="lb-mid">
			</div>

			<div class="lb-btm"></div>

		</div>



	

		<div class="left-block">

			<div class="lb-top">



			</div>

			<div class="lb-mid">

				<div class="lb-info">


					

					

				</div>

			</div>

			<div class="lb-btm"></div>

		</div>

		

		

		

		

		

	</div>

	

	

	

	<div id="right-column">

	

		<div class="right-block">

			<div class="rb-top">

				<div class="rb-title">Select And Log In To Play...</div>
	

			</div>
	
			<div class="rb-mid">

				<div class="rb-info">

					<p>
						&nbsp; 
				</p>
			
				<font color="red"><strong><%=message %></strong></font>
				
<form  name=myForm action="playcontroller" method=post>
		
		
		
			
			
		<table frame="box" align="center">
			
			
				<tr>
					<th>Select</th>
					<th>GameId</th>
					<th>GameTitle</th>
					<th>Genre</th>
					<th>Developed by</th>
			

			<tbody>

				<c:forEach items="${message}" var="message">
					<tr>
						<td><input type="radio" id="radio" name="radio"
							onclick="userVisible(divid)" value="yes">
						</td>
						<td><input type="text" readonly="readonly"
							value=<c:out value="${message.gid}" />>
						</td>
						<td><input type="text" readonly="readonly"
							value=<c:out value="${message.gtitle}"/>></td>
						<td><input type="text" readonly="readonly"
							value=<c:out value="${message.gtype}"  />></td>
						<td><input type="text" readonly="readonly"
							value=<c:out value="${message.com}" />></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		
		<center>
		Enter your details<br/>
		Player ID:<input type="text" name="id"/><br/>
		Password:<input type="password" name="pwd"/><br/>
		Hours to play:<input type="text" name="time"/><br/>
		<button onclick="return check(this);">Login & Play</button>
		
<h3 style="color:red" id="message1"></h3>
		</center>
		</form>
					</p>
					
					<ul>
						
					</ul>
					
					<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>

				</div>

			</div>

			

		</div>

		

		

		<div class="right-block">

			

			

		</div>
		
		
		
		
		
		<div class="right-block">

			

				


			<div class="rb-btm"></div>

		</div>






	

	</div>

	

	

	

	<div class="clearB"></div>



</div>









<div id="main-btm"></div>









<div id="footer">



	<div id="footer-mid">

	

		<div id="ft-left-column">

			

			<div id="ft-left-title">Login</div>

			

			<div id="ft-lt-info">

				

				<form style="margin-top:0px" action="playcontroller">

                   

                    

                </form>

                

			

			</div>

			

			

					

			

		</div>

			

		<div id="ft-right-column">

		

			<div id="ft-right-title"></div>

			

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

