<%-- 
    Document   : index
    Created on : 07/11/2009, 12:21:00
    Author     : Maria Eugenia Sanchez
    Author     : Claudio Rodrigo Pereyra Diaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
session.removeAttribute("usuario");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sipsa Web</title>
        <link rel="shortcut icon" href="Sipsa.png" type="image/ico" />
        <link rel="icon" href="Sipsa.png" type="image/png" />
    </head>
    <body>
        <p align="center"><img width="20%" height="20%" src="Sipsa.png"></p>
        <h1  align="center">Sistema Sipsa - Punto de Venta</h1>
        <form action="UsuarioServlet" method="post">
            <table align="center">
                <tr>
                    <td><p>Usuario:</p></td>
                    <td><input name="usuario" size="20">
                </tr>
                <tr>
                    <td><p>Contraseña:</p></td>
                    <td><input type="password" value name="password" size="20"></td>
                </tr>
                <tr>
                    <td align="center"><input align="center" type="submit" value="Ingresar" ></td>
                </tr>
        </table>
    </form>
    </body>
</html>
