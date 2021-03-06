<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <base href="/">
    <meta charset="utf-8">
    <title>歪歪视频</title>
    <base href="/"/>
    <link rel="stylesheet" href="css/index.css"/>
    <link rel="stylesheet" type="text/css" href="css/his.css">
    <script type="text/javascript" src="lib/layui/layui.all.js"></script>
    <script src="js/jquery-3.4.1.js" ></script>
</head>
<script>
    $(document).ready(function(){
        var user = "${sessionScope.user}"
        //点击链接的时候调用
        $("#viewHistory").click(function () {
            if (user == null || user == "") {
                layer.confirm('您需要登录后才能查看，是否前往登录？', {
                    btn: ['登录', '取消'], //按钮
                    cancel: function(index){
                        layer.close(index);
                    },title:'查看提示',
                }, function () {
                    window.location.href = "/user/login";
                }, function (index) {
                    layer.close(index);
                });
            }else {
                window.open("/view/history");
            }
        })
    })
</script>

<script>
    $(document).ready(function(){
        var user = "${sessionScope.user}"
        //点击链接的时候调用
        $("#viewCollection").click(function () {
            if (user == null || user == "") {
                layer.confirm('您需要登录后才能查看，是否前往登录？', {
                    btn: ['登录', '取消'], //按钮
                    cancel: function(index){
                        layer.close(index);
                    },title:'查看提示',
                }, function () {
                    window.location.href = "/user/login";
                }, function (index) {
                    layer.close(index);
                });
            }else {
                window.open("/view/collection");
            }
        });
    });
</script>

<script>
    $(document).ready(function(){
        var user = "${sessionScope.user}"
        //点击链接的时候调用
        $("#myVideo").click(function () {
            if (user == null || user == "") {
                layer.confirm('您需要登录后才能查看，是否前往登录？', {
                    btn: ['登录', '取消'], //按钮
                    cancel: function(index){
                        layer.close(index);
                    },title:'查看提示',
                }, function () {
                    window.location.href = "/user/login";
                }, function (index) {
                    layer.close(index);
                });
            }else {
                window.open("/view/myvideo");
            }
        });
    });
</script>

<body>
<div
        class="v3-app-layout layoutstatus-header--Normal layoutstatus-side--Normal limitWidth">
    <jsp:include page="header.jsp"></jsp:include>
    <div class="v3-app-layout__side">
        <div class="v3-app-layout__side__Normal">
            <div class="v3-app-layout__side__Normal__contentWrapper">
                <div class="v3-app-layout__side__block-top">
                    <a id="index" class="v3-app-layout__side__item" href="/index"><i
                            class="icon-home"></i><span>首页</span></a>
                </div>
                <div id="te" class="v3-app-layout__side__block-channel">
                    <div class="v3-app-layout__side__block-title bg-blue " >特色频道</div>
                    <c:forEach items="${categories}" var="category" varStatus="s">
                    <a id="${s.count}" class="v3-app-layout__side__item" href="index/category/${category.id}">
                        <i class="icon-triangle"></i><span>${category.name}</span></a>
                    </c:forEach>
                </div>
                <div class="v3-app-layout__side__block-user">
                    <div id="my" class="v3-app-layout__side__block-title">我的</div>
                    <a  id="viewHistory" class="v3-app-layout__side__item" target="_self">
                        <i class=""></i><span>观看历史</span></a>
                    <a id="viewCollection" class="v3-app-layout__side__item">
                        <i class=""></i><span>我的收藏</span></a>
                    <a id="myVideo" class="v3-app-layout__side__item">
                        <i class=""></i><span>我的视频</span></a>
                    <a href="view/praise"  class="v3-app-layout__side__item">
                        <i class=""></i><span>我点赞的视频</span></a>
                    <a  class="v3-app-layout__side__item">
                        <i class=""></i><span>我评论的视频</span></a>

                </div>

            </div>
        </div>
    </div>
    <div class="v3-app-layout__content  ">
        <div class="categoryContent__wrapper">
            <div class="categoryContent categoryPage_home">
                <div
                        class="FeedContainer channelBlocklist channelBlocklist--narrow categoryPage_home__LvideoRecomment">
                    <div class="FeedContainer__content">
                        <div class="FeedContainer__items">
                            <c:forEach items="${videos}" begin="0" end="${fn:length(videos)}" var="video" varStatus="p">
                                <div class="FeedContainer__itemWrapper">
                                    <div class="VerticalFeedCard VerticalChannelBlockList__item">
                                        <a href="video/view/${video.id}"  class="VerticalFeedCard__coverWrapper" title=""
                                           target="_blank" data-disable_default="true">
                                            <picture>
                                                <source srcSet="" type="image/webp"/>
                                                <img class="BU-MagicImage"
                                                     style="width: 100%; height: 100%; transition: transform 0.3s; object-fit: cover"
                                                     src="images/${video.cover}" alt="${video.title}"/>
                                            </picture>
                                        </a>
                                        <a class="VerticalFeedCard__title" title="" href="video/view/${video.id}"
                                               target="_blank" data-disable_default="true">${video.title}</a>
                                        <div class="VerticalFeedCard__bottomInfo">${video.viewTime}</div>
                                    </div>
                                </div>
                                <c:if test="${p.count mod 5 eq 0 }">
                                    <br/>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</body>
<script>
    $(document).ready(function (){
        $(".v3-app-layout__side__block-channel a").each(function(){
            $this = $(this);
            if($this[0].href==String(window.location)){
                $('.v3-app-layout__side__item').removeClass("active");
                $(".v3-app-layout__side__block-channel a").removeClass("active");
                $this.addClass("active");
            }
        })
        var pathname = window.location.pathname;
        if (pathname == '/index'){
            $('#index').addClass("active");
        }
    })
</script>
</html>