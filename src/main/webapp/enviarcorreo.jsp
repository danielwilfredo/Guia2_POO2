<%-- 
    Document   : enviarcorreo
    Created on : 08-12-2017, 08:34:18 AM
    Author     : DanielWilfredo
--%>

<%@page import="com.sv.udb.controladores.PersonaCtrl"%>
<%@page import="com.sv.udb.modelos.Personas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel='stylesheet' href='webjars/materialize/0.97.3/dist/css/materialize.min.css'>
         <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
         <script type="text/javascript" src="webjars/materialize/0.97.3/dist/js/materialize.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body class="teal lighten-4">
        <div class="container">
            <h1><center>Formulario Correo</center></h1>
            <form method="POST" action="EnviarcorreoServ">
       <div class="row">
        <div class="col s12 m6 l12">
          <div class="card blue-grey darken-1">
            <div class="card-content white-text">
                <span class="card-title"><center>Nuevo Mensaje</center></span>
     <div class="input-field col s12 white-text">
        <select multiple class="white-text" id="cmbdesti" name="cmbdesti">
          <option value="" disabled selected>Seleccione Destinatario:</option>
 <%
                for(Personas temp: new PersonaCtrl().ConsEmail())
               
                { 

                 %>
                        <option value="<%=temp.getEmail()%>" ><%=temp.getNombPers()%></option>;
                               
                <%}
                
                %>
        </select>
    <label class="white-text">Destinatario:</label>
  </div>
       <div class="input-field col s12 white-text">
        <select multiple class="white-text" id="cmbcc" name="cmbcc">
          <option value="holakease@gmail.com" disabled selected>Seleccione un cc:</option>
          <%
                for(Personas temp: new PersonaCtrl().ConsEmail())
               
                { 

                 %>
                        <option value="<%=temp.getEmail()%>" ><%=temp.getNombPers()%></option>;
                               
                <%}
                
                %>
        </select>
    <label class="white-text">CC:</label>
  </div>
     <div class="input-field col s12 white-text">
        <select multiple class="white-text" id="cmbcco" name="cmbcco">
          <option value="holakease@gmail.com" disabled selected>Seleccione un cco:</option>
          <%
                for(Personas temp: new PersonaCtrl().ConsEmail())
               
                { 

                 %>
                        <option value="<%=temp.getEmail()%>" ><%=temp.getNombPers()%></option>;
                               
                <%}
                
                %>
        </select>
    <label class="white-text">CCO:</label>
                        <div class="input-field">
          <input id="asun" name="asun" type="text" class="validate">
          <label for="asun" class="white-text">Asunto</label>
        </div>
  </div>
    
            </div>
            <div class="card-action">
                <div class="input-field col s12">
                    <textarea id="mens" name="mens" class="materialize-textarea white-text"></textarea>
                    <label for="textarea1" class="white-text">Mensaje:</label>
                </div>
            </div>
              <div class="card-action">
                <button class="btn waves-effect waves-light" type="submit" name="action">Enviar
                </button>
              <button class="btn waves-effect red" type="submit" name="action">Cancelar
                </button>
            </div>
          </div>
        </div>
      </div>
        </form>
        </div>
         
    </body>
    <script>
          $(document).ready(function() {
    $('select').material_select();
  });
    </script>
</html>
