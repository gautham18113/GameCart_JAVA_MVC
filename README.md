# GameCart_JAVA_MVC

A Java MVC Application using HTTP Servlets, Requests, Response and Sessions to build an e-commerce application to buy, sell and manage games.

Structure- <br />
src<br />
--\com\catp\cgc<br />
  --\bo<br />
    --CustomerScreenBO<br />
    --displaygamesBO<br />
    --FeedbackBO<br />
    --loginBO<br />
    --PLayerIDBO<br />
    --regBO<br />
    --searchBO<br />
    --SellGameBO<br />
  --\businessexception<br />
    --BusinessException<br />
    --SearchBusinessException<br />
  --\constants<br />
    --ErrorConstants<br />
    --QueryConstants<br />
    --SuccessConstants<br />
  --\controller<br />
    --CustomerScreenCOntroller<br />
    --DisplayGamesCOntroller<br />
    --FeedbackController<br />
    --LoginController<br />
    --PlayController<br />
    --PlayerIDController<br />
    --PriceController<br />
    --regController<br />
    --SearchController<br />
    --SellGameController<br />
  --\dao<br />
    --CustomerScreenDAO<br />
    --DisplayGamesDAO<br />
    --FeedBackDAO<br />
    --LoginDAO<br />
    --PlayerIDDAO<br />
    --regDAO<br />
    --SearchDAO<br />
    --SellGameDAO<br />
  --\exception<br />
    --ApplicationException<br />
    --BusinessException<br />
    --DatabaseOperationException<br />
    --DisplayGamesException<br />
    --SystemException<br />
  --\logger<br />
    --LoggerInitializer<br />
  --\util<br />
    --DBUtil<br />
    --PropertyUtil<br />
  --\vo<br />
    --CustomerScreenBean<br />
    --FeedBackBean<br />
    --loginBean<br />
    --DisplayGamesTO<br />
    --PlayerIDTO<br />
    --SearchTO<br />
    --regBean<br />
    --SellGameVO<br />
db.properties<br />
errormessages.properties<br />
log4j.properties<br />
UIText.properties<br />
WebContent<br />
    
Application - JAVA MVC
Implementation - HTTP Servlets, HTTP GET and POST, HTTP Session.
Database - MySQL

Admin Login - Allows admin to add, delete or update game data, and manage user data.
![Alt text](https://github.com/gautham18113/GameCart_JAVA_MVC/blob/master/pictures/Admin.JPG "Optional title")

User Login - Allows users to browse, purchase and play games
![Alt text](https://github.com/gautham18113/GameCart_JAVA_MVC/blob/master/pictures/User.JPG "Optional title")

User Feedback - Allows users to provide feedback
![Alt text](https://github.com/gautham18113/GameCart_JAVA_MVC/blob/master/pictures/User_Feedback.JPG "Optional title")
