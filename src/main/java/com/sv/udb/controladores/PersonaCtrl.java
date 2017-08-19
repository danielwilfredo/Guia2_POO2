/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controladores;

import com.sv.udb.modelos.Personas;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DanielWilfredo
 */
public class PersonaCtrl {
      public List<Personas> consTodo()
    {
       List<Personas> resp = new ArrayList();
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("select * from pers");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
              resp.add(new Personas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBytes(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getInt(13) , rs.getString(14) , rs.getString(15) , rs.getString(16), rs.getInt(17)));
            }
            //Se carga el 
        }
        catch(Exception err)
        {
            err.printStackTrace();
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    } 
      
       public List<Personas> ConsEmail()
    {
       List<Personas> resp = new ArrayList();
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("select nomb_pers, mail_pers from pers where mail_pers like '%@%'");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp.add(new Personas(rs.getString(1), rs.getString(2)));
            }
            //Se carga el 
        }
        catch(Exception err)
        {
            err.printStackTrace();
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    } 
    
    
    //Codigo para consultar segun el id del registro
    
         public Personas consTodo2(int id)
    {
      Personas resp = null;
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("select * from pers where codi_pers=?");
            cmd.setString(1, String.valueOf(id));
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp = (new Personas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBytes(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getInt(13) , rs.getString(14) , rs.getString(15) , rs.getString(16), rs.getInt(17)));
            }
            //Se carga el 
        }
        catch(Exception err)
        {
            err.printStackTrace();
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    } 
         
         
         //Codigo para guardar
         
         public boolean guar(Personas obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("insert into pers values(?,?, ?, ?, ?, ?, ?,?, ?, ?, ?,?, now(), ?, 'asgfasfasfas');");
            cmd.setInt(1, obje.getCodiPers());
            cmd.setString(2, obje.getNombPers());
            cmd.setString(3, obje.getApelPers());
            cmd.setBytes(4, obje.getFotoPers());
            cmd.setString(5, obje.getEmail());
            cmd.setInt(6, obje.getCodiTipoPers());
            cmd.setString(7, obje.getGenePers());
            cmd.setString(8, obje.getFechaNaciPers());
            cmd.setString(9, obje.getDuiPers());
            cmd.setString(10, obje.getNitPers());
            cmd.setString(11, obje.getTipoSangPers());
            cmd.setInt(12, obje.getCodiUbicPers());
            cmd.setString(13, obje.getFechAlta());
            cmd.setString(14, obje.getFechaBaja());
            cmd.setInt(15, obje.getEsta());
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al guardar Miembros: " + ex.getMessage());
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    }
         
         public boolean elim(Personas obje)
    {
         boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("delete from pers where codi_pers =?");
            cmd.setString(1, String.valueOf(obje.getCodiPers()));
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al Eliminar el Miembros " + ex.getMessage());
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    }
        
         //Codigo para modificar registros
         
          public boolean modi(Personas obje)
    {
         boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("update pers set NOMB_PERS=?, APEL_PERS=?, FOTO_PERS=?, mail_pers=?, CODI_TIPO_PERS=?, GENE_PERS=?, FECH_NACI_PERS=?, DUI_PERS=?, NIT_PERS=?, TIPO_SANG_PERS=?, CODI_UBIC_GEOG=?, FECH_ALTA=?, FECH_BAJA=?, ESTA='saasff' where codi_pers=?;");
            cmd.setString(1, String.valueOf(obje.getNombPers())); 
            cmd.setString(2, String.valueOf(obje.getApelPers()));
            cmd.setString(3, String.valueOf(obje.getFotoPers()));
            cmd.setString(4, String.valueOf(obje.getEmail()));
            cmd.setString(5, String.valueOf(obje.getCodiTipoPers()));
            cmd.setString(6, String.valueOf(obje.getGenePers()));
            cmd.setString(7, String.valueOf(obje.getFechaNaciPers()));
            cmd.setString(8, String.valueOf(obje.getDuiPers()));
            cmd.setString(9, String.valueOf(obje.getNitPers()));
            cmd.setString(10, String.valueOf(obje.getTipoSangPers()));
            cmd.setString(11, String.valueOf(obje.getCodiUbicPers()));
            cmd.setString(12, String.valueOf(obje.getFechAlta()));
            cmd.setString(13, String.valueOf(obje.getFechaBaja()));
            cmd.setString(14, String.valueOf(obje.getEsta()));
            cmd.setString(15, String.valueOf(obje.getCodiPers()));
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al modificar el Jugador " + ex.getMessage());
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    }
    
    
}
