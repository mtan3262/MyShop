<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <link href="${contextPath}/css/global.css" rel="stylesheet" type="text/css" id="globalStyle"></link>
  <script type="text/javascript" src="${contextPath}/js/execute.js"></script>
  <title><tiles:getAsString name="title" /></title>
</head>

<body>
	<div class="header">
    <tiles:insert attribute="header" />
	</div>
	
 	<div class="body" style="text-align: center; margin-left: 400px">
    <tiles:insert attribute="body" />
</div>
	<div class="footer">
    <tiles:insert attribute="footer" />
  </div>
</body>
</html>