<%@ page contentType="text/html;charset=GBK"%>			   <!-- 设置网页的编码为GBK -->
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %><!-- 引入JSF核心标记库 -->
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %><!-- 引入JSF关于HTML的标记库-->
<html>
<head>
<title>影南忘</title>
<link type="text/css" rel="stylesheet" href="images/style.css"><!-- 引入外部css样式表 -->
<script type="text/javascript" src="images/teacher.js"></script>
</head>
<body topMargin=0;background-image:url(images/image2.jpg);>
	<f:view><!-- 使用JSF标签库生成登录表单-->
		<h:form id="myform" onsubmit="return checkLogin();">
		<h:panelGrid styleClass="panel" >	
			<h:panelGrid columns="1">
				<h:outputText value="影南忘登陆首页" styleClass="pname"/>
				<h:panelGrid columns="2"  style="text-align:left;width=100%;">
					<h:panelGrid columns="2" width="100%" >
						<h:outputText value="用户名："/>
						<h:inputText id="uid" value="#{LoginBean.uid}" required="true"/>
						<h:outputText value="密    码："/>
						<h:inputSecret id="pwd" value="#{LoginBean.pwd}" required="true"/>
						<h:outputText value="角    色："/>
						<h:selectOneRadio layout="lineDirection" value="#{LoginBean.type}">
							<f:selectItem itemLabel="模特" itemValue="student"/>
							<f:selectItem itemLabel="摄影师" itemValue="teacher"/>
						</h:selectOneRadio>
						<h:outputText value=""/>
						<h:panelGroup>
							<h:message for="uid" style="color:red"/>
							<h:message for="pwd" styleClass="msg"/>
						</h:panelGroup>
					</h:panelGrid>
					<h:commandButton image="images/login1.gif" 
						onmouseover="this.src='images/login2.gif'" onmouseout="this.src='images/login1.gif'" 
						onmousedown="this.src='images/login3.gif'" onmouseup="this.src='images/login2.gif'" 
						action="homepage"/>	
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		</h:form>	
	</f:view>
</body>
</html>