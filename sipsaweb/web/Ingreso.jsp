<%-- 
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
        <link rel="icon" href="Sipsa.png" type="image/png" />
    </head>
    <body>
        <p align="center"><img alt="Sipsa" width="20%" height="20%" src="Sipsa.png"></p>
        <h1  align="center">Sistema Sipsa</h1>
        <h2  align="center">Punto de Venta</h2>
        <form action="IngresoServlet" method="post">
            <table align="center">
                <tr>
                    <td>CUIT:</td>
                    <td><input name="cuit" size="20"></td>
                    <td><input type="submit" value="Ingresar" ></td>
                </tr>
            </table>
        </form>
    </body>
</html>