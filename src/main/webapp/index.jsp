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
            
        <form method="POST" action="PiezaServ" name="Demo"> 
           <div class="row">
        <div class="col l12 s12 m12">
          <div class="card blue-grey darken-1">
            <div class="card-content white-text">
              <span class="card-title">Ingresar Persona</span>
              <h1>${mensAler}</h1>         
                  <!--Importante agregarle el enctype"multipart/form-data"-->
            <input hidden type="text" name="codi2" id="codi2" value="${codi}"/><br/>
                <h5>Codigo Persona</h5>
            <input disabled class="white-text" type="text" name="codi" id="codi" value="${codi}"/><br/>
                <h5>Nombre</h5>
            <input type="text" name="nomb" id="nomb" value="${nomb}"/><br/>
                <h5>Apellido</h5>
            <input type="text" name="tipo" id="tipo" value="${tipo}"/><br/><br/>              
                <h5>Foto</h5>
            <input type="text" name="marc" id="marc" value="${marc}"/><br/><br/>              
            <h5>Tipo Persona</h5>
            <input type="text" name="marc" id="marc" value="${marc}"/><br/><br/>              
            <h5>Genero</h5>
            <input type="text" name="marc" id="marc" value="${marc}"/><br/><br/>              
            <h5>Foto</h5>
            <input type="text" name="marc" id="marc" value="${marc}"/><br/><br/>              
            <h5>Foto</h5>
            <input type="text" name="marc" id="marc" value="${marc}"/><br/><br/>              
          </div>
            <div class="card-action">
               
             <input class="btn waves-effect waves-light" type="submit" name="btnEqui" value="Guardar"/>
             <input class="btn waves-effect waves-light" type="submit" name="btnEqui" value="Modificar"/>
               
            </div>
          </div>
        </div>
      </div>   
           
       </form>

    
         <form method="POST" action="" name="Tabla">                                                                                  
       <div class="row">
        <div class="col l12 s12 m12">
          <div class="card blue-grey darken-1">
            <div class="card-content white-text">
                <span class="card-title"><center>Personas Tabla</center></span>
              <table border="1">
                
                    <th>Cons</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                     <th>Algo</th>
                     <th>Algo 2</th>
                     <th>Algo 3</th>
                     <th>Algo 4</th>
                     <th>Algo 5</th>
                     <th>Algo 6</th>
                     <th>Algo 7</th>
                     <th>Algo 8</th>
                     <th>Algo 9</th>
                     <th>Algo 27</th>

                
                <%
                 for(Personas temp : new PersonaCtrl().consTodo())
                 {
                     
            %>
                   
                <tr>
                    <td><input id="<%=temp.getCodiPers()%>" name="codiEquiRadi" type="radio" value="<%=temp.getCodiPers()%>"/>
                     <label for="<%=temp.getCodiPers()%>"></label></td>
                    <td><%=temp.getNombPers()%></td>
                    <td><%=temp.getApelPers()%></td>
                 <!--   <td>< %=temp.getFotoPers()%></td>-->
                    <td><%=temp.getEmail()%></td>
                    <td><%=temp.getTipoPers()%></td>
                    <td><%=temp.getGenePers()%></td>
                    <td><%=temp.getFechaNaciPers()%></td>
                    <td><%=temp.getDuiPers()%></td>
                    <td><%=temp.getNitPers()%></td>
                    <td><%=temp.getTipoSangPers()%></td>
                    <td><%=temp.getUbicPers()%></td>
                    <td><%=temp.getFechAlta()%></td>
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
        </body>    
</html>
