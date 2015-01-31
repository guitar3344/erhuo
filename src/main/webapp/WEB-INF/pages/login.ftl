<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <#include common_header.ftl>
</head>
<body>
    <form id="login_form" name="login_form" action="/login.do">
        <input id="account" name="account" type="text">
        <input id="password" name="password" type="password">
        <button id="login_button" type="submit">登录</button>
    </form>
</body>
</html>
