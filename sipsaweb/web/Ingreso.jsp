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
    </head>
    <body>
        <h1 align="center">Sistema Sipsa - Punto de Venta</h1>
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
                    <td><input align="center" type="submit" value="Ingresar" ></td>
                </tr>
        </table>
    </form>
    </body>
</html>
