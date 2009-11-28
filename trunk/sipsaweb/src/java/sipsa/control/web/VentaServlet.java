package sipsa.control.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sipsa.control.VentaControl;
import sipsa.dominio.Pv;

public class VentaServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        VentaControl ventaControl = new VentaControl();
        try {
            Pv pv = (Pv) session.getAttribute("pv");
            String fechaFactura = request.getParameter("fechaFactura");
            String nroFactura = request.getParameter("nroFactura");
            int tipoProducto = Integer.parseInt(request.getParameter("tipoProducto"));
            int modelo = Integer.parseInt(request.getParameter("modelo"));
            String nroSerie = request.getParameter("nroSerie");
            ventaControl.activarGarantia(pv, fechaFactura, nroFactura, tipoProducto, modelo, nroSerie);
            response.sendRedirect("ActivacionOk.jsp");
        } catch (Exception ex) {
            response.sendRedirect("ActivacionError.jsp?textoError="+ex.getLocalizedMessage());
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}