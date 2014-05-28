<%@page import="com.easyjob.utils.URLUtils"%>
<%@page pageEncoding="UTF-8" %>
<%@include file="common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>

<script type="text/javascript">
	window.onload = function() {
		$('.carousel').carousel({
			  interval: 2000
		});
	};
	
</script>
</head>
<body>

	<%=request.getRemoteAddr()%>
	
	<%=URLUtils.getIpAddr(request) %>

	<%@include file="common/header.jsp" %>
	
	<div class="container" >
		<div class="carousel slide">
			<div class="carousel-inner">
				<div class="item">
					<img src="${BASE }/img/gc.jpg" alt="">
					<div class="carousel-caption">
						<h4>gc</h4>
					</div>
				</div>
				<div class="item">
					<img src="${BASE }/img/mybatis.jpg" alt="">
					<div class="carousel-caption">
						<h4>mybatis</h4>
					</div>
				</div>
				<div class="item active">
					<img src="${BASE }/img/yellow.jpg" alt="">
					<div class="carousel-caption">
						<h4>yellow</h4>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="common/footer.jsp" %>
	
</body>
</html>