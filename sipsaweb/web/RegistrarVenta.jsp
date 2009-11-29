<%--
    Author     : Maria Eugenia Sanchez
    Author     : Claudio Rodrigo Pereyra Diaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML
    PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java"%>
<%@ page import="sipsa.dominio.Modelo" %>
<%@ page import="sipsa.control.ModeloControl" %>
<%
            String usuario = (String) session.getAttribute("usuario");
            if (usuario == null) {
                response.sendRedirect("Login.jsp");
            }
%>
<%!     private ModeloControl modeloControl = new ModeloControl();
        private List<Modelo> listaModelos = modeloControl.getListaModelos();
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sipsa Web</title>
        <link rel="icon" href="Sipsa.png" type="image/png" />
    </head>
    <body>
        <p align="center"><img alt="Sipsa" width="20%" height="20%" src="Sipsa.png"></p>
        <h1 align="center">Activación de Garantia</h1>
        <h2 align="center">Ingrese los datos de la venta para activar la garantia</h2>
        <form name="datosVenta" action="VentaServlet" method="post" >
            <table align="center">
                <tr>
                    <td style="font-weight:bold">Empresa Vendedora: </td>
                    <td><%=usuario%></td>
                </tr>
                <tr>
                    <td style="font-weight:bold">Nro Factura: </td>
                    <td><input type="text" name="nroFactura" value="" /></td>
                </tr>
                <tr>
                    <td style="font-weight:bold">Fecha Factura: </td>
                    <td><input type="text" name="fechaFactura" value="" /></td>
                </tr>
                <tr>
                    <td style="font-weight:bold">Tipo y Modelo de Producto: </td>
                    <td>
                        <select style="width:100%" name="modelo">
                            <option value=-1 selected>Seleccione una opción</option>
                            <%
                            for (Modelo modelo : listaModelos) {
                            %>
                            <option value=<%=modelo.getID()%> ><%=modelo.toString()%></option>
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td style="font-weight:bold">Numero de Serie: </td>
                    <td><input type="text" name="nroSerie" value="" /></td>
                </tr>
                <tr>
                    <td><p align="center"><input type="submit" value="Activar Garantia"/></p></td>
                    <td><p align="center"><input type="Button" value="Salir del Sistema" onclick="window.location='Ingreso.jsp'"></p></td>
                </tr>
            </table>
        </form>
    </body>
</html>