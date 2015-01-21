<%@ page session="false"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1" name="viewport">
    <meta content="二货 二手货 校园 会员注册 免费" name="keywords">
    <title>二货!到碗里来</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <!-- <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css"> -->
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

    <script>
      function test(){
          $.ajax({
              type: "post",
              contentType: "application/json",
              url: "/erhuo/ajaxcalc.do",
              data:{"email":"123"},
              dataType: "json",
              success: function (data) {
                  alert(Json.stringify(data))
              },
              error: function (XMLHttpRequest, textStatus, errorThrown) {
                  alert(errorThrown);
              }
          });


      }
    </script>
</head>
<body>
	<h1>${message}</h1>
    <button onclick="javascript:test();"></button>
</body>
</html>