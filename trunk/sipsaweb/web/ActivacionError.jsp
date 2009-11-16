<%-- 
    Document   : ActivacionError
    Created on : 07/11/2009, 15:43:32
    Author     : elsupergomez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Sipsa</title>
        <link rel="shortcut icon" href="Sipsa.png" type="image/ico" />
        <link rel="icon" href="Sipsa.png" type="image/png" />
    </head>
    <body>
        <p align="center"><img width="20%" height="20%" src="Sipsa.png"></p>
        <h1 align="center">Error</h1>
        <h2 align="center">La información ingresada no es valida para activar la garantia</h2>
        <p align="center">Detalle: <%= request.getParameter("textoError")%></p>
        <p align="center">
            <input type="Button" value="Intentar de nuevo" onclick="window.location='RegistrarVenta.jsp'">
            <input type="Button" value="Salir del Sistema" onclick="window.location='Ingreso.jsp'">
        </p>
    </body>
</html>
