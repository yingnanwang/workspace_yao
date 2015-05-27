<%@ page contentType="text/html;charset=GBK"%>			   <!-- ������ҳ�ı���ΪGBK -->
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %><!-- ����JSF���ı�ǿ� -->
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %><!-- ����JSF����HTML�ı�ǿ�-->
	
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
            <h1 id="logo">Ӱ����</h1>
            <i class="fa fa-search fa-3x" id="search"></i>
        </div>

    </header>
    <ul id="nav">
        <li class="current">��ҳ</li>
        <li>��Ӱʦ</li>
        <li>ģ��</li>
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
            <span id="ps-name">����?</span>
            <div class="spe-info">
                <span class="cl">ϲ��</span>
                <span class="num">500</span>
            </div>            
            <div class="spe-info">
                <span class="cl">��ע</span>
                <span class="num">20W</span>
                
            </div>            
            <div class="spe-info">
                <span class="cl">��˿</span>
                <span class="num">888</span> 
            </div>            
            <div class="spe-info">
                <span class="cl">˽��</span>
                <span class="num">45</span>
            </div>
        </div>
    </div>
    <footer>
        @copyright Ӱ����
    </footer>
    <script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
    <script src="scripts.js"></script>
</body>

</html>
