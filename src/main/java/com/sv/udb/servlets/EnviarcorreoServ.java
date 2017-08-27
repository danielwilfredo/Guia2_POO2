/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.servlets;

import com.sv.udb.recursos.EnviarCorreo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DanielWilfredo
 */
@WebServlet(name = "EnviarcorreoServ", urlPatterns = {"/EnviarcorreoServ"})
public class EnviarcorreoServ extends HttpServlet {

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
        boolean esValido = request.getMethod().equals("POST");
    String menss="";
    if(!esValido)
    {
        response.sendRedirect(request.getContextPath()+"/enviarcorreo.jsp");
    }
    else
    {
      
        String asunto=request.getParameter("asun");
        String mensaje=request.getParameter("mens");
        String ruta = request.getParameter("ruta");
        String[] destino = request.getParameterValues("cmbdesti");
     try {
         for(String mail : destino)
        {
            EnviarCorreo envi = new EnviarCorreo(mensaje, mail, asunto);
            envi.SendMail();
            if (ruta != null)
            {
                envi.enviarpdf(ruta, mensaje , asunto);

            }
             else
               {
                   menss = "hubo un problema al enviar el archivo";
               }
                          request.setAttribute("mensAler",menss);
            request.getRequestDispatcher("/enviarcorreo.jsp").forward(request, response);
                     
        }
    
            }
                
             catch (Exception e) {
            }
            
    }
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


