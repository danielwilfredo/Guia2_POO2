/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelos;

/**
 *
 * @author DanielWilfredo
 */
public class Personas {
    private int codiPers;
    private String nombPers;
    private String apelPers;
    private byte[] foto;
    private String email;
    private int codiTipoPers;
    private String tipoPers;
    private String genePers;
    private String fechaNaciPers;
    private String duiPers;
    private String nitPers;
    private String tipoSangPers;
    private int codiUbicPers;
    private String ubicPers;
    private String fechaAlta;
    private String fechaBaja;

    public int getCodiPers() {
        return codiPers;
    }

    public void setCodiPers(int codiPers) {
        this.codiPers = codiPers;
    }

    public String getNombPers() {
        return nombPers;
    }

    public void setNombPers(String nombPers) {
        this.nombPers = nombPers;
    }

    public String getApelPers() {
        return apelPers;
    }

    public void setApelPers(String apelPers) {
        this.apelPers = apelPers;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCodiTipoPers() {
        return codiTipoPers;
    }

    public void setCodiTipoPers(int codiTipoPers) {
        this.codiTipoPers = codiTipoPers;
    }

    public String getTipoPers() {
        return tipoPers;
    }

    public void setTipoPers(String tipoPers) {
        this.tipoPers = tipoPers;
    }

    public String getGenePers() {
        return genePers;
    }

    public void setGenePers(String genePers) {
        this.genePers = genePers;
    }

    public String getFechaNaciPers() {
        return fechaNaciPers;
    }

    public void setFechaNaciPers(String fechaNaciPers) {
        this.fechaNaciPers = fechaNaciPers;
    }

    public String getDuiPers() {
        return duiPers;
    }

    public void setDuiPers(String duiPers) {
        this.duiPers = duiPers;
    }

    public String getNitPers() {
        return nitPers;
    }

    public void setNitPers(String nitPers) {
        this.nitPers = nitPers;
    }

    public String getTipoSangPers() {
        return tipoSangPers;
    }

    public void setTipoSangPers(String tipoSangPers) {
        this.tipoSangPers = tipoSangPers;
    }

    public int getCodiUbicPers() {
        return codiUbicPers;
    }

    public void setCodiUbicPers(int codiUbicPers) {
        this.codiUbicPers = codiUbicPers;
    }

    public String getUbicPers() {
        return ubicPers;
    }

    public void setUbicPers(String ubicPers) {
        this.ubicPers = ubicPers;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(String fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public Personas(int codiPers, String nombPers, String apelPers, byte[] foto, String email, int codiTipoPers, String tipoPers, String genePers, String fechaNaciPers, String duiPers, String nitPers, String tipoSangPers, int codiUbicPers, String ubicPers, String fechaAlta, String fechaBaja) {
        this.codiPers = codiPers;
        this.nombPers = nombPers;
        this.apelPers = apelPers;
        this.foto = foto;
        this.email = email;
        this.codiTipoPers = codiTipoPers;
        this.tipoPers = tipoPers;
        this.genePers = genePers;
        this.fechaNaciPers = fechaNaciPers;
        this.duiPers = duiPers;
        this.nitPers = nitPers;
        this.tipoSangPers = tipoSangPers;
        this.codiUbicPers = codiUbicPers;
        this.ubicPers = ubicPers;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
    }

    public Personas(String nombPers, String email) {
        this.nombPers = nombPers;
        this.email = email;
    }
    public Personas()
    {
        
    }

    public Personas(int codiTipoPers, String tipoPers) {
        this.codiTipoPers = codiTipoPers;
        this.tipoPers = tipoPers;
    }

    public Personas(int codiUbicPers, String ubicPers, String fechaAlta) {
        this.codiUbicPers = codiUbicPers;
        this.ubicPers = ubicPers;
        this.fechaAlta = fechaAlta;
    }
    
    
    
    
    
    
    
    
}
