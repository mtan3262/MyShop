<head>
	<meta charset="UTF-8">
	<title>Invoice Book</title>
	<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
	<div id="background">
		<div id="page">
			<%@include file="WEB-INF/layout/header.jsp" %>
			<div id="contents">
				
				<div id="main" style="margin-left:200px ">
					
					<%@include file="WEB-INF/view/common/invoice.jsp" %>
				</div>
			</div>
			<%@include file="WEB-INF/layout/footer.jsp" %>
		</div>
	</div>
</body>
