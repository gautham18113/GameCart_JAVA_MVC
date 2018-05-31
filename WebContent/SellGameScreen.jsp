<%@page import="com.catp.cgc.vo.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<meta content="text/html; charset=windows-1252" http-equiv="Content-Type" />



<title>Zoid CSS Gaming Website Theme and Template - High Tech</title>


<!-- META TAGS -->

<meta content="english" name="language"/>

<meta content="public" http-equiv="cache-control"/>





<!-- CSS FILES -->

<link href="css/zoid-stylesheet.css" rel="stylesheet" type="text/css" />

<!-- JAVASCRIPT FILES -->

<script type="text/javascript" src="js/clock.js"></script>



</head>


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

				<li><a class="hbutton" href="SellGameLogin">Buy games</a></li>

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

				<div class="rb-title">Sell Game Screen</div>

			</div>

			<div class="rb-mid">

				<div class="rb-info">
<a href="SellGameLogin.jsp">Back to PurchaseGameLogin</a>


<h3 align="center">Games Available for Purchase</h3>
<br>

<table border="1">
<tr>
<th width="150">Game Title</th>
<th width="150">Game Type</th>
<th width="150">Price</th>
<th width="150">Rating</th>
<th width="150">Options Available</th>
</tr>
 <%
if(request.getAttribute("gamedetails")!=null)	
{
List<SellGameVO> al=(List)request.getAttribute("gamedetails");
String option="";
String passValue="";
int discount=0;
if(request.getAttribute("option")!=null)
{
	option=request.getAttribute("option").toString();	
}
int price=0;
String options="";
Iterator<SellGameVO> itr=al.iterator();
	SellGameVO vo=null;
	while(itr.hasNext())
	{
		
		vo=(SellGameVO)itr.next();
		 String priceValue=vo.getPrice();
		if(option.equals("buy"))
		{
			options="Buy";
			discount=vo.getDiscount();
			price=Integer.parseInt(priceValue);
			priceValue=(price-(discount*price/100))+"";
			passValue="Successfully bought" ;
		}
		else
			{
			options="Buy";
			discount=0;
			passValue="Sorry, Only registered users can purchase games!" ;
			} 
	
	%>

<tr>

<td width="150"><%=vo.getGameTitle() %></td>
<td width="150"><%=vo.getGameType() %></td>
<td width="150"><select name="price" id="price">
<option value="200">200</option>
<option value="300">300</option>
<option value="400">400</option>
</select></td>
<td width="150"><%=vo.getRating() %></td>
<td width="150"><a href="SellSuccess.jsp?p1=<%=passValue%>"><%=options %></a></td>

</tr>
<%}} %>




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

