/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.recursos;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.InternetAddress;
import javax.swing.JOptionPane;

/**
 *
 * @author DanielWilfredo
 */
public class EnviarCorreo {//declaración de nuestras variables
//correo electrónico que se utilizara para enviar los mail
    private String Usua = "danielwilfredo1109@gmail.com";
//contraseña de correo electrónico
    private String Contr = "lokibonito";
//mensaje
    String Mensage = "";
//destino de mail
    String para = "";
//asunto a tratar
    String asunto = "";
    
    public EnviarCorreo(String men, String para, String tema)
    {
        this.Mensage = men;
        this.para = para;
        this.asunto = tema;
    }
  
  
  
//métodos para obtener o cambiar información de nuestras variables

    public void mensaje(String mensaje) {
        this.Mensage = mensaje;
    }

    public void para(String para) {
        this.para = para;
    }

    public void asunto(String asunto) {
        this.asunto = asunto;
    }

// este método autentifica el usuario y contraseña y enviar el mail a el destinatario

    public boolean SendMail() {
        boolean resp;
	 Properties props = new Properties();
	 props.put("mail.smtp.host", "smtp.gmail.com");
	 props.put("mail.smtp.socketFactory.port", "465");
	 props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	 props.put("mail.smtp.auth", "true");
	 props.put("mail.smtp.port", "465");

        Session session;
        session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Usua, Contr);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Usua));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(para));
            message.setSubject(asunto);
            message.setText(Mensage);
            Transport.send(message);
            resp = true;
        } catch (MessagingException e) {
            resp = false;
        }
        return resp;
    }

//este método enviar un mail al destinatario adjuntando un archivo (pdf), con la diferencia que nos pedirá nombre del archivo, ruta del archivo y asunto del porque envía el archivo

    public void enviarpdf(String archivo, String nombre, String asunto) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465"); 
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Usua, Contr);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Usua));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(para));
            BodyPart adjunto = new MimeBodyPart();
            BodyPart texto = new MimeBodyPart();
            texto.setText(asunto);
            adjunto.setDataHandler(new DataHandler(new FileDataSource(archivo)));
            adjunto.setFileName(nombre);
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(adjunto);
            multiParte.addBodyPart(texto);
            message.setSubject(asunto);
            message.setText(Mensage);
            message.setContent(multiParte);
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}