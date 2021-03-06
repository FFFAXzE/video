<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <base href="/"/>
    <title>后台管理中心</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body style="background-color: lightgray;">
<div class="header bg-inverse">
    <div class="logo margin-big-left fadein-top">
        <h1>歪歪视频管理系统</h1>
    </div>
    <div class="head-l">
        <a class="button button-little bg-blue-light" href="video/list"
           target="right"> <span class=""></span>管理首页
        </a> &nbsp;&nbsp; <a class="button button-little bg-dot"
                             href="/admin/logout"> <span class="icon-power-off"></span>退出登录
    </a><> Welcome! ${sessionScope.admin.account}!
    </div>
</div>
<div class="leftnav">
    <div class="leftnav-title">
        <strong><span class="icon-list"></span>菜单列表</strong>
    </div>
    <h2>
        <span class=""></span>视频管理
    </h2>
    <ul>
        <li><a href="/category/add" target="right"><span
                class="icon-caret-right"></span>增加视频分类</a></li>
        <li><a href="/category/list" target="right"><span
                class="icon-caret-right"></span>视频分类列表</a></li>
        <li><a href="/video/list" target="right"><span
                class="icon-caret-right"></span>视频列表</a></li>
    </ul>

    <h2>
        <span class=""></span>用户管理
    </h2>
    <ul>
        <li><a href="user/list" target="right"><span
                class="icon-caret-right"></span>用户列表</a></li>
        <li><a href="admin/show" target="right"><span class="icon-caret-right"></span>报表统计</a></li>
    </ul>
    <h2>
        <span class="icon-pencil-square-o"></span>个人中心
    </h2>
    <ul>
        <li><a href="admin/modifypwd" target="right"><span
                class="icon-caret-right"></span>修改密码</a></li>
    </ul>
</div>
<div class="admin">
    <iframe src="video/list" name="right" width="100%" height="100%"></iframe>
</div>
</body>
</html>