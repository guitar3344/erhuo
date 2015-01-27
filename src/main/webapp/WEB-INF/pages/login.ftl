<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <#include "/WEB-INF/pages/common_meta&title.ftl">
    <#include "/WEB-INF/pages/common_css&script.ftl">
</head>
<body>
    <form id="login_form" name="login_form" action="/login.do">
        <input id="account" name="account" type="text">
        <input id="password" name="password" type="password">
        <button id="login_button" type="submit">登录</button>
    </form>
</body>
</html>
