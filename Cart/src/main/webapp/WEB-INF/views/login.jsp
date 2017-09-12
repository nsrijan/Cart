<%--<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:if test="${errormsg !=null }">${errormsg }</c:if>
	<form:form action="${pageContext.request.contextPath }/user/login" method="post" modelAttribute="user">
		<form:input path="username" placeholder="username" /><br />
		<form:password path="password" placeholder="password" /><br />
		<input type="submit" value="Login" name="submit" />
	</form:form>

</body>
</html> --%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="header.jsp"></jsp:include>

<div class="container">
	<div class="row text-center ">
		<div class="col-md-12">
			<br />
			<br />
			<h2>Login Form</h2>

			<h5>( Login yourself to get access )</h5>
			<br />
		</div>
	</div>
	<div class="row ">

		<div
			class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
			<div class="panel panel-default">
				<div class="panel-heading">
					<strong> Enter Details To Login </strong>
				</div>
				<div class="panel-body">
					<form:form role="form"
						action="${pageContext.request.contextPath }/user/login"
						method="post" modelAttribute="user">
						<br />
						<div class="form-group input-group">
							<span class="input-group-addon"><i class="fa fa-tag"></i></span>
							<form:input path="username" cssClass="form-control"
								placeholder="Your Username" />
						</div>
						<div class="form-group input-group">
							<span class="input-group-addon"><i class="fa fa-lock"></i></span>
							<form:password path="password" cssClass="form-control"
								placeholder="Your Password" />
						</div>
						<div class="form-group">
							<label class="checkbox-inline"> <input type="checkbox" />
								Remember me
							</label> <span class="pull-right"> <a href="#">Forget
									password ? </a>
							</span>
						</div>

						<input type="submit" value="Login Now" class="btn btn-primary ">
					</form:form>
					<hr />
					Not register ? <a href="${pageContext.request.contextPath }/user/signup">click here </a>
					</form>
				</div>

			</div>
		</div>


	</div>
</div>

<script
	src="${pageContext.request.contextPath }/resources/login/js/jquery-1.10.2.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script
	src="${pageContext.request.contextPath }/resources/login/js/bootstrap.min.js"></script>
<!-- METISMENU SCRIPTS -->
<script
	src="${pageContext.request.contextPath }/resources/login/js/jquery.metisMenu.js"></script>
<!-- CUSTOM SCRIPTS -->
<script
	src="${pageContext.request.contextPath }/resources/login/js/custom.js"></script>
