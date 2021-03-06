/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vistas;

import com.sv.udb.controladores.PersonaCtrl;
import com.sv.udb.modelos.Personas;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author DanielWilfredo
 */
@MultipartConfig //Este CODIGO ES IMPORTANTE AGREGARLO SIN ESTO NO GUARDA LA IMAGEN
@WebServlet(name = "PersonaServ", urlPatterns = {"/PersonaServ"})
public class PersonaServ extends HttpServlet {

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
            throws ServletException, IOException {         boolean esValido = request.getMethod().equals("POST");
        String mens = "";
        if(!esValido){
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
        else{
            String CRUD = request.getParameter("btnEqui");
            if(CRUD.equals("Guardar"))
            {
                System.err.println("Esta en el guardar");
                Personas obje = new Personas();
                 System.err.println("casi enviando valores");
                obje.setCodiPers(Integer.parseInt(request.getParameter("codi")));
                obje.setNombPers(request.getParameter("nomb"));
                obje.setApelPers((request.getParameter("apel")));
                obje.setEmail((request.getParameter("email")));
                obje.setCodiTipoPers(Integer.parseInt(request.getParameter("cmbtipoPers")));
                obje.setGenePers((request.getParameter("gene")));
                obje.setFechaNaciPers((request.getParameter("fechNaci")));
                obje.setDuiPers((request.getParameter("dui")));
                obje.setNitPers((request.getParameter("nit")));
                obje.setTipoSangPers(request.getParameter("sang"));
                obje.setCodiUbicPers(Integer.parseInt((request.getParameter("cmbubicPers"))));
                obje.setFechaBaja((request.getParameter("fbaja")));
                //codigo para guardar la imagen
                Part filepart = request.getPart("foto"); //obtiene la foto
                int SizeImg = (int)filepart.getSize();//el tamaño de la foto
                byte[] img = null; //declaramos variable para guardar la foto
                if(filepart !=null)
                {
                    img = new byte[SizeImg];
                    try(DataInputStream dataImg = new DataInputStream(filepart.getInputStream()))
                    {
                        dataImg.readFully(img);
                        System.err.println("agarra la imagen");
                    }
                }
                if(SizeImg > 0)
                {
                    obje.setFoto(img);
                    System.err.println("algo imagen");
                }
                if(new PersonaCtrl().guar(obje))
                {
                    mens="Datos Guardados";
                }
                else
                {
                    mens="Error al guardar";
                }
            }
            else if(CRUD.equals("Consultar"))
            {
                
                int codi = Integer.parseInt(
                        request.getParameter("codiradi").isEmpty() 
                        ? "-1" : request.getParameter("codiradi"));//Creamos una variable que me almacene
                //el codigo seleccionado dependiendo del radio buton seleccionado
               Personas obje = new PersonaCtrl().consTodo2(codi);
               if(obje != null)
                {
                    request.setAttribute("codi", obje.getCodiPers());
                    request.setAttribute("nomb", obje.getNombPers());
                    request.setAttribute("apel", obje.getApelPers());
                    request.setAttribute("gene", obje.getGenePers());
                    request.setAttribute("fechNaci", obje.getFechaNaciPers());
                    request.setAttribute("email", obje.getEmail());
                    request.setAttribute("fbaja", obje.getFechaBaja());
                    request.setAttribute("falta", obje.getFechaAlta());
                    request.setAttribute("dui", obje.getDuiPers());
                    request.setAttribute("nit", obje.getNitPers());
                    request.setAttribute("sang", obje.getTipoSangPers());
                    
                   
                }
                else
                {
                    mens = "Error al consultar";
                }
                
            }
            else if (CRUD.equals("Eliminar"))
            {
                Personas obje = new Personas();
                int codi= Integer.parseInt(request.getParameter("codiradi").isEmpty() ? "-1" : request.getParameter("codiradi"));
                   obje.setCodiPers(codi);
                if(new PersonaCtrl().elim(obje))
                {
                    mens="Datos Eliminados";
                }
                else
                {
                    mens="Error al eliminar";
                }
            }
            else if(CRUD.equals("Modificar"))
            {
                Personas obje = new Personas();
               obje.setCodiPers(Integer.parseInt(request.getParameter("codi")));
                obje.setNombPers(request.getParameter("nomb"));
                obje.setApelPers(request.getParameter("apel"));
                obje.setEmail(request.getParameter("email"));
                obje.setTipoSangPers(request.getParameter("sang"));
                obje.setGenePers(request.getParameter("gene"));
                obje.setFechaNaciPers(request.getParameter("fechNaci"));
                obje.setDuiPers(request.getParameter("dui"));
                obje.setNitPers(request.getParameter("nit"));
                obje.setFechaAlta(request.getParameter("falta"));
                obje.setFechaBaja(request.getParameter("fbaja"));
                obje.setCodiUbicPers(Integer.parseInt(request.getParameter("cmbubicPers")));
                obje.setCodiTipoPers(Integer.parseInt(request.getParameter("cmbtipoPers")));
                                 //codigo para guardar la imagen
                Part filepart = request.getPart("foto"); //obtiene la foto
                int SizeImg = (int)filepart.getSize();//el tamaño de la foto
                byte[] img = null; //declaramos variable para guardar la foto
                if(filepart !=null)
                {
                    img = new byte[SizeImg];
                    try(DataInputStream dataImg = new DataInputStream(filepart.getInputStream()))
                    {
                        dataImg.readFully(img);
                    }
                }
                if(SizeImg > 0)
                {
                   // obje.setImgJuga(img);
                }
                
                if(new PersonaCtrl().modi(obje))
                {
                   mens="Datos Actualizados"; 
                }
                else
                {
                   mens="Error al Actualizar"; 
                }
                
            }
             request.setAttribute("mensAler",mens);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            
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
