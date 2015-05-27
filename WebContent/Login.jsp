<%@ page contentType="text/html;charset=GBK"%>			   <!-- ������ҳ�ı���ΪGBK -->
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %><!-- ����JSF���ı�ǿ� -->
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %><!-- ����JSF����HTML�ı�ǿ�-->
<html>
<head>
<title>Ӱ����</title>
<link type="text/css" rel="stylesheet" href="images/style.css"><!-- �����ⲿcss��ʽ�� -->
<script type="text/javascript" src="images/teacher.js"></script>
</head>
<body topMargin=0;background-image:url(images/image2.jpg);>
	<f:view><!-- ʹ��JSF��ǩ�����ɵ�¼��-->
		<h:form id="myform" onsubmit="return checkLogin();">
		<h:panelGrid styleClass="panel" >	
			<h:panelGrid columns="1">
				<h:outputText value="Ӱ������½��ҳ" styleClass="pname"/>
				<h:panelGrid columns="2"  style="text-align:left;width=100%;">
					<h:panelGrid columns="2" width="100%" >
						<h:outputText value="�û�����"/>
						<h:inputText id="uid" value="#{LoginBean.uid}" required="true"/>
						<h:outputText value="��    �룺"/>
						<h:inputSecret id="pwd" value="#{LoginBean.pwd}" required="true"/>
						<h:outputText value="��    ɫ��"/>
						<h:selectOneRadio layout="lineDirection" value="#{LoginBean.type}">
							<f:selectItem itemLabel="ģ��" itemValue="student"/>
							<f:selectItem itemLabel="��Ӱʦ" itemValue="teacher"/>
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