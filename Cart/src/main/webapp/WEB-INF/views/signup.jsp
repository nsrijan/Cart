<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign Up</title>
</head>
<body>
	
	<form:form action="${pageContext.request.contextPath }/user/signup" method="post" modelAttribute="user">
		 
		Name: <form:input path="firstName" placeholder="FirstName"/><form:input path="lastName" placeholder="LastName"/><br />
		Email: <form:input path="email" placeholder="Email"/><br /><form:errors path="email"></form:errors>
		Username: <form:input path="username" placeholder="username"/> <br/>
		Password: <form:password path="password" placeholder="*******"/> <br />

		<input type="submit" vlaue="submit" name="Sign Up" />
		
	</form:form>

</body>
</html>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="header.jsp"></jsp:include>

<div class="container">
        <div class="row text-center  ">
            <div class="col-md-12">
                <br /><br />
                <h2> Binary Admin : Register</h2>
               
                <h5>( Register yourself to get access )</h5>
                 <br />
            </div>
        </div>
         <div class="row">
               
                <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                        <strong>  New User ? Register Yourself </strong>  
                            </div>
                            <div class="panel-body">
                                <form:form role="form" action="${pageContext.request.contextPath }/user/signup" method="post" modelAttribute="user">
<br/>
                                        <div class="form-group input-group">
                                            <span class="input-group-addon"><i class="fa fa-circle-o-notch"  ></i></span>
                                            <form:input path="firstName" cssClass="form-control" placeholder="Your FirstName" />
                                        </div>
                                     <div class="form-group input-group">
                                            <span class="input-group-addon"><i class="fa fa-tag"  ></i></span>
                                         	<form:input path="lastName" cssClass="form-control" placeholder="Your LastName" />
                                        </div>
                                         <div class="form-group input-group">
                                            <span class="input-group-addon">@</span>
                                             <form:input path="email" cssClass="form-control" placeholder="Your Email" />
                                        </div>
                                      <div class="form-group input-group">
                                            <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                                            <form:input path="username" cssClass="form-control" placeholder="Your Username" />
                                        </div>
                                     <div class="form-group input-group">
                                            <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                                            <form:password path="password" cssClass="form-control" placeholder="Enter Password" />
                                            
                                        </div>
                                     
                                     <input type="submit" value="Register Me" class="btn btn-success ">
                                     </form:form>
                                    <hr />
                                    Already Registered ?  <a href="${pageContext.request.contextPath }/user/login" >Login here</a>
                                    </form>
                            </div>
                           
                        </div>
                    </div>
                
                
        </div>
    </div>
    
    <script src="${pageContext.request.contextPath }/login/js/jquery-1.10.2.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="${pageContext.request.contextPath }/login/js/bootstrap.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="${pageContext.request.contextPath }/login/js/jquery.metisMenu.js"></script>
      <!-- CUSTOM SCRIPTS -->
    <script src="${pageContext.request.contextPath }/login/js/custom.js"></script>
    
  --%>   
    
    