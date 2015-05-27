<%@ page contentType="text/html;charset=GBK"%>			   <!-- 设置网页的编码为GBK -->
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %><!-- 引入JSF核心标记库 -->
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %><!-- 引入JSF关于HTML的标记库-->
	
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Indelible Image</title>
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>

<body>
    <header>
        <div class="header-container">
            <h1 id="logo">影南忘</h1>
            <i class="fa fa-search fa-3x" id="search"></i>
        </div>

    </header>
    <ul id="nav">
        <li class="current">首页</li>
        <li>摄影师</li>
        <li>模特</li>
    </ul>
    <div id="main-container">
        <div id="left-content">
            <div class="content-container">
                <div class="content-head">
                    <img src="images/portrait.jpg" class="portrait">
                    <span class="name">Adrian James</span>
                </div>
                <div class="content-body">
                    <div class="img-wrap">
                        <div class="img-roll">
                    		<img src="images/1.jpg" class="imgs">
                    		<img src="images/2.jpg" class="imgs">
                    		<img src="images/3.jpg" class="imgs">
                        </div>
                        <i class="fa fa-chevron-left left fa-2x"></i>
                        <i class="fa fa-chevron-right right fa-2x"></i>
                    </div>
                    <div class="icons">
                        <i class="fa fa-comments fa-2x comments"></i>
                        <span class="comments-amount amount">18</span>
                        <i class="fa fa-share-alt fa-2x share"></i>
                        <span class="share-amount amount">50</span>
                        <i class="fa fa-thumbs-o-up fa-2x up"></i>
                        <span class="up-amount amount">250</span>
                    </div>
                </div>
            </div>
        </div>
        <div id="psn-info">
            <img src="images/ps-port.gif" id="ps-port">
            <span id="ps-name">向右?</span>
            <div class="spe-info">
                <span class="cl">喜欢</span>
                <span class="num">500</span>
            </div>            
            <div class="spe-info">
                <span class="cl">关注</span>
                <span class="num">20W</span>
                
            </div>            
            <div class="spe-info">
                <span class="cl">粉丝</span>
                <span class="num">888</span> 
            </div>            
            <div class="spe-info">
                <span class="cl">私信</span>
                <span class="num">45</span>
            </div>
        </div>
    </div>
    <footer>
        @copyright 影南忘
    </footer>
    <script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
    <script src="scripts.js"></script>
</body>

</html>
