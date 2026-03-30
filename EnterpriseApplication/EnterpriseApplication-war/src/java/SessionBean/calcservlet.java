/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package SessionBean;

import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class calcservlet extends HttpServlet {

    @EJB
    private calcbeanLocal calcbean;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String error = null;
        Integer resultado = null;
        String nombreOp = "";
        try {
            String t1 = request.getParameter("t1");
            String t2 = request.getParameter("t2");
            String op = request.getParameter("operacion");

            if (t1 == null || t1.isEmpty()) {
                error = "Debes ingresar el Número 1";
            } else if (!op.equals("elevar") && (t2 == null || t2.isEmpty())) {
                error = "Debes ingresar el Número 2";
            } else {
                int a = Integer.parseInt(t1);
                int b = op.equals("elevar") ? 0 : Integer.parseInt(t2);

                switch (op) {
                    case "suma":
                        resultado = calcbean.addition(a, b);
                        nombreOp = "Suma";
                        break;
                    case "resta":
                        resultado = calcbean.restar(a, b);
                        nombreOp = "Resta";
                        break;
                    case "multiplicar":
                        resultado = calcbean.multiplicar(a, b);
                        nombreOp = "Multiplicación";
                        break;
                    case "dividir":
                        if (b == 0) {
                            error = "No se puede dividir entre cero";
                        } else {
                            resultado = calcbean.dividir(a, b);
                            nombreOp = "División";
                        }
                        break;
                    case "modulo":
                        if (b == 0) {
                            error = "No se puede calcular módulo entre cero";
                        } else {
                            resultado = calcbean.modulo(a, b);
                            nombreOp = "Módulo";
                        }
                        break;
                    case "elevar":
                        resultado = calcbean.elevar(a);
                        nombreOp = "Elevar al cuadrado";
                        break;
                }
            }
        } catch (NumberFormatException e) {
            error = "Solo se permiten números enteros";
        }
        request.setAttribute("resultado", resultado);
        request.setAttribute("nombreOp", nombreOp);
        request.setAttribute("error", error);
        request.getRequestDispatcher("calcjsp.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
