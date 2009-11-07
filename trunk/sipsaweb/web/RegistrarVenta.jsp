<%-- 
    Document   : registroVenta
    Created on : 07/11/2009, 13:02:03
    Author     : elsupergomez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
//Se recupera el usuario de la session actual
String username = (String) session.getAttribute("usuario");
//Si el usuario es nulo se direcciona a la pagina de login
if (username == null)
    response.sendRedirect("Ingreso.jsp");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Sipsa - Activación de Garantias</title>
    </head>
    <body>
        <h1 align="center">Ingrese los datos de la venta para activar la garantia</h1>
        <form action="VentaServlet" method="post" >
          <table align="center">
              <tr><td>Empresa Vendedora</td><td><input type="text" name="empresa" value="" /></td></tr>
              <tr><td>Nro Factura </td><td><input type="text" name="nroFactura" value="" /></td></tr>
              <tr><td>Fecha</td><td><input type="text" name="fechaFactura" value="" /></td></tr>
              <tr><td>Tipo de Producto</td><td>
<!Iterar para llenar con las opciones>
                  <select name="tipoProducto">
                    <tr>
                        <option value="1">TipoProducto1</option> 
                    </tr>
                  </select></td>
              </tr>
              <tr><td>Modelo Producto</td><td><input type="text" name="modelo" value="" /></td></tr>
              <tr><td>Numero de Serie</td><td><input type="text" name="nroSerie" value="" /></td></tr>
              <tr><td><input type="submit" value="Activar Garantia"/></td>
         </table>
        </form>
    </body>
</html>