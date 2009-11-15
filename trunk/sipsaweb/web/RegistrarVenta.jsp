<%-- 
    Document   : registroVenta
    Created on : 07/11/2009, 13:02:03
    Author     : elsupergomez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java"%>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="sipsa.dominio.TipoProducto" %>
<%@ page import="sipsa.dominio.Modelo" %>
<%@ page import="sipsa.control.TipoProductoControl" %>
<%
    String usuario = (String) session.getAttribute("usuario");
    if (usuario == null)
        response.sendRedirect("Login.jsp");
%>
<%!
    private TipoProductoControl tipoProductoControl = new TipoProductoControl();
    private List<TipoProducto> lista = tipoProductoControl.getListaTipoProducto();
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sipsa Web</title>
        <link rel="icon" href="Sipsa.png" type="image/png" />
    </head>
    <body>
        <p align="center"><img width="20%" height="20%" src="Sipsa.png"></p>
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
                    <td style="font-weight:bold">Tipo de Producto: </td>
                    <td>
                        <select style="width:100%" name="tipoProducto">
                            <!--TODO aca deberia invocar la carga del segundo combo-->
                            <option value=-1 selected>Seleccione una opción</option>
                            <%
                            for (Iterator tpIt = lista.iterator(); tpIt.hasNext();) {
                                TipoProducto tipoProducto = (TipoProducto) tpIt.next();
                            %>
                            <option value=<%=tipoProducto.getID()%> ><%=tipoProducto.getDescripcion()%></option>
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td style="font-weight:bold">Modelo Producto: </td>
                    <td>
                        <select style="width:100%" name="modelo">
                            <option value=-1 selected>Seleccione una opción</option>
                            <!--TODO aca deberia ser parametrizado de acuerdo al tipo de producto seleccionado-->
                            <%
                            for (Iterator tpIt = lista.get(1).getModelos().iterator(); tpIt.hasNext();) {
                                Modelo modelo = (Modelo) tpIt.next();
                            %>
                            <option value=<%=modelo.getID()%> ><%=modelo.getNombre()%></option>
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td style="font-weight:bold">Numero de Serie: </td>
                    <td><input type="text" name="fechaFactura" value="" /></td>
                </tr>
                <tr>
                    <td><p align="center"><input type="submit" value="Activar Garantia"/></p></td>
                    <td><p align="center"><input type="Button" value="Salir del Sistema" onclick="window.location='Ingreso.jsp'"></p></td>
                </tr>
            </table>
        </form>
    </body>
</html>