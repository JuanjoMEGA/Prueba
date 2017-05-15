<%-- 
    Document   : index
    Created on : 15-may-2017, 9:36:00
    Author     : jjmelgar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
        </head>
        <body>
            <h1><h:outputText value="Hello World!"/></h1>
            <h:dataTable value="#{b_smartphone.cogerMoviles()}" var="s">
                <h:column><h:outputText value="#{s.Smartphone.id}"></h:outputText></h:column>
                <h:column><h:outputText value="#{s.Smartphone.bid}"></h:outputText></h:column>
                <h:column><h:outputText value="#{s.Smartphone.pantalla}"></h:outputText></h:column>
                <h:column><h:outputText value="#{s.Smartphone.potencia}"></h:outputText></h:column>
                <h:column><h:outputText value="#{s.Smartphone.camara}"></h:outputText></h:column>
                <h:column><h:outputText value="#{s.Smartphone.sensor}"></h:outputText></h:column>
                <h:column><h:outputText value="#{s.Smartphone.modelo}"></h:outputText></h:column>
                <h:column><h:outputText value="#{s.Smartphone.publicado}"></h:outputText></h:column>
                <h:column><h:outputText value="#{s.Smartphone.dimensiones}"></h:outputText></h:column>
                <h:column><h:outputText value="#{s.Smartphone.peso}"></h:outputText></h:column>                
            </h:dataTable>
        </body>
    </html>
</f:view>
