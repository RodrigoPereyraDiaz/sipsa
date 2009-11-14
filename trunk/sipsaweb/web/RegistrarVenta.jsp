<%-- 
    Document   : registroVenta
    Created on : 07/11/2009, 13:02:03
    Author     : elsupergomez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">



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
                    <td>Empresa Vendedora</td>
                    <td>Ventas y Distribuciones S.A</td>
                </tr>
                <tr>
                    <td>Nro Factura </td>
                    <td><input type="text" name="nroFactura" value="" /></td>
                </tr>
                <tr>
                    <td>Fecha Factura</td>
                    <td><input type="text" name="fechaFactura" value="" /></td>
                </tr>
                <tr>
                    <td>Tipo de Producto</td>
                    <td>
                        <select name="tipoProducto" onchange="cargaModelos()">
                            <% writeListaTiposProducto(out);%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Modelo Producto</td>
                    <td>
                        <select name="modelo">
                            <script LANGUAGE="JavaScript">
                                function cargaModelos() {
                                var miform = document.datosVenta;
                                var valorselect = miform.tipoProducto.options[miform.tipoProducto.selectedIndex].value;
                                <%
                                    //int idTipoProducto = Integer.parseInt(request.getParameter("valorselect"));
                                    int idTipoProducto = 1;
                                    writeListaModelos(out, idTipoProducto);
                                %>
                                }
                            </script>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Numero de Serie</td>
                    <td>
                        <select name="nroSerie">
                            <% writeListaNrosSerie(out);%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input align="right" type="submit" value="Activar Garantia"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>

<%@ page language="java"%>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="sipsa.dominio.TipoProducto" %>
<%@ page import="sipsa.control.TipoProductoControl" %>
<%@ page import="sipsa.dominio.Modelo" %>
<%!    private TipoProductoControl tipoProductoControl = new TipoProductoControl();
    private List<TipoProducto> lista = tipoProductoControl.getListaTipoProducto();

    private void writeListaTiposProducto(javax.servlet.jsp.JspWriter out) {
        try {
            out.println("<option value=\"-1\" selected>  Selecciona una opción</option>");
            for (Iterator tpIt = lista.iterator(); tpIt.hasNext();) {
                TipoProducto tipoProducto = (TipoProducto) tpIt.next();
                out.println("<option value=" + tipoProducto.getID() + " selected>" + tipoProducto.getDescripcion() + "</option>");
            }
        } catch (java.io.IOException e1) {
            System.out.println(e1);
        }
    }

    private void writeListaModelos(javax.servlet.jsp.JspWriter out, int idTipoProducto) {
        try {
            TipoProducto tipoProducto = lista.get(idTipoProducto);
            for (Iterator tpIt = tipoProducto.getModelos().iterator(); tpIt.hasNext();) {
                Modelo modelo = (Modelo) tpIt.next();
                out.println("<option value=" + modelo.getID() + " selected>" + modelo.getNombre() + "</option>");
            }
        } catch (java.io.IOException e1) {
            System.out.println(e1);
        }
    }

    private void writeListaNrosSerie(javax.servlet.jsp.JspWriter out) {
        try {

            for (int i = 1; i < (31 + 1); i++) {
                out.println("<option value=" + i + " selected>" + Integer.toString(i) + "</option>");
            }
            out.println("<option value=\"-1\" selected>  Selecciona una opción</option>");
        } catch (java.io.IOException e1) {
            System.out.println(e1);
        }
    }
%>