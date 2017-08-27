<%@page import="com.sv.udb.controladores.PersonaCtrl"%>
<%@page import="com.sv.udb.modelos.Personas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='webjars/materialize/0.97.3/dist/css/materialize.min.css'>
            <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
            <script type="text/javascript" src="webjars/materialize/0.97.3/dist/js/materialize.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
            
        <form method="POST" action="PersonaServ" name="Demo" enctype="multipart/form-data"> 
           <div class="row">
        <div class="col l12 s12 m12">
          <div class="card blue-grey darken-1">
            <div class="card-content white-text">
              <span class="card-title">Ingresar Persona</span>
              <h1>${mensAler}</h1>         
                  <!--Importante agregarle el enctype"multipart/form-data"-->
            <h5>Codigo Persona</h5>
            <input class="white-text" type="text" name="codi" id="codi" value="${codi}"/><br/>
                <h5>Nombre</h5>
            <input type="text" name="nomb" id="nomb" value="${nomb}"/><br/>
                <h5>Apellido</h5>
            <input type="text" name="apel" id="apel" value="${apel}"/><br/><br/>              
                <div class="file-field input-field">
                    <div class="btn">
                        <span>Imagen</span>
                        <input type="file" name="foto" id="foto" required />
                    </div>
                        <div class="file-path-wrapper">
                          <input class="file-path validate" name="foto" type="text" placeholder='1200x1200 máx., 2MB máx., PNG/JPG/GIF'>
                        </div>
                
                </div>           
            <h5>Email</h5>
            <input type="text" name="email" id="email" value="${email}"/><br/><br/>              
             <h5>Tipo Persona</h5>
        <SELECT name="cmbtipoPers" id="cmbtipoPers"> 
            <%
                for(Personas temp : new PersonaCtrl().ConsTipoPers())
                {
                    
            %>
            <option value="<%=temp.getCodiTipoPers() %>"><%=temp.getTipoPers() %></option>
           <%
                            
                }
            %>
            
        </SELECT> <br><br>
            <h5>Genero</h5>
            <input type="text" name="gene" id="gene" value="${gene}"/><br/><br/>              
            <h5>Fecha Nacimiento</h5>
            <input type="text" name="fechNaci" id="fechNaci" value="${fechNaci}"/><br/><br/>              
            <h5>DUI</h5>
            <input type="text" name="dui" id="dui" value="${dui}"/><br/><br/>              
            <h5>NIT</h5>
            <input type="text" name="nit" id="nit" value="${nit}"/><br/><br/>              
            <h5>Tipo de sangre</h5>
            <input type="text" name="sang" id="sang" value="${sang}"/><br/><br/>              
               <h5>Tipo Persona</h5>
        <SELECT name="cmbubicPers" id="cmbubicPers"> 
            <%
                for(Personas temp : new PersonaCtrl().ConsUbic())
                {
                    
            %>
            <option value="<%=temp.getCodiUbicPers() %>"><%=temp.getUbicPers() %></option>
           <%
                            
                }
            %>
            
        </SELECT> <br><br>
             <h5>Fecha Alta</h5>
            <input type="text" name="falta" id="falta" value="${falta}"/><br/><br/>              
            <h5>Fecha Baja</h5>
            <input type="text" name="fbaja" id="fbaja" value="${fbaja}"/><br/><br/>              
          </div>
            <div class="card-action">
               
             <input class="btn waves-effect waves-light" type="submit" name="btnEqui" value="Guardar"/>
             <input class="btn waves-effect waves-light" type="submit" name="btnEqui" value="Modificar"/>
               
            </div>
          </div>
        </div>
      </div>   
           
       </form>

    
         <form method="POST" action="PersonaServ" name="Tabla">                                                                                  
       <div class="row">
        <div class="col l12 s12 m12">
          <div class="card blue-grey darken-1">
            <div class="card-content white-text">
                <span class="card-title"><center>Personas Tabla</center></span>
              <table border="1">
                
                    <th>Cons</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                     <th>Email</th>
                     <th>Tipo Persona</th>
                     <th>Genero</th>
                     <th>Fecha Nacimiento</th>
                     <th>DUI</th>
                     <th>NIT</th>
                     <th>Tipo Sangre</th>
                     <th>Ubicacion</th>
                     <th>Fecha Alta</th>
                     <th>Fecha Baja</th>

                
                <%
                 for(Personas temp : new PersonaCtrl().Cons())
                 {
                     
            %>
                   
                <tr>
                    <td><input id="<%=temp.getCodiPers()%>" name="codiradi" type="radio" value="<%=temp.getCodiPers()%>"/>
                     <label for="<%=temp.getCodiPers()%>"></label></td>
                    <td><%=temp.getNombPers()%></td>
                    <td><%=temp.getApelPers()%></td>
                    <td><%=temp.getEmail()%></td>
                    <td><%=temp.getTipoPers()%></td>
                    <td><%=temp.getGenePers()%></td>
                    <td><%=temp.getFechaNaciPers()%></td>
                    <td><%=temp.getDuiPers()%></td>
                    <td><%=temp.getNitPers()%></td>
                    <td><%=temp.getTipoSangPers()%></td>
                    <td><%=temp.getUbicPers()%></td>
                    <td><%=temp.getFechaAlta()%></td>
                    <td><%=temp.getFechaBaja()%></td>
            </tr>
            <%
                }
            %>
               
            </table>
            </div>
            <div class="card-action">
            <input class="btn waves-effect waves-light" type="submit" name="btnEqui" value="Consultar"/>
            <input class="btn waves-effect waves-light" type="submit" name="btnEqui" value="Eliminar"/>
            </div>
          </div>
        </div>
      </div>
         </form>
            
                <script>
          $(document).ready(function() {
    $('select').material_select();
  });
    </script>
        </body>    
</html>
