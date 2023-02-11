///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package br.com.tads.model.utils;
//
//
//
//import java.util.Properties;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
///**
// *
// * @author juann
// */
//public class SendMail {
//    public static void  send(String emailTo, String subject, String mailBody){
//        final String from = "tads.webmail@gmail.com";
//        final String password = "rxcnqukpwxpfmfjj";
//        
//        Properties properties = System.getProperties ();
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//        properties.put("mail.smtp.host", "smtp.gmail.com");
//        properties.put("mail.smtp.port", "587");
//        properties.put("mail.smtp.ssl.trust", "*");
//        
//        Session session = Session.getInstance(properties,
//                new javax.mail.Authenticator() {
//                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
//                        return new javax.mail.PasswordAuthentication(from, password);
//                    }
//                });
//        session.setDebug (true);
//
//        try{
//            Message message = new MimeMessage (session);
//            message.setFrom (new InternetAddress (from));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress (emailTo));
//            message.setSubject (subject);
//            message.setText (mailBody);
//
//            Transport.send (message);
//            System.out.println ("Mensagem enviada com sucesso ....");
//        } catch (MessagingException mex) {
//            mex.printStackTrace ();
//        }
//    }
//}
