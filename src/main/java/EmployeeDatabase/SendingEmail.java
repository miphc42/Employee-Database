/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeeDatabase;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author miphc
 */
public class SendingEmail {
    final static String myEmail = "ComputerScienceAgency@gmail.com";
    final static String myPassword = "PC20020402";
    public static void send(String receive, String subject, String text) throws MessagingException{
        Properties pro = new Properties();
        pro.put("mail.smtp.auth","true");// smtp = Simple Mail Transfer Protocol
        pro.put("mail.smtp.starttls.enable","true");
        pro.put("mail.smtp.host","smtp.gmail.com");
        pro.put("mail.smtp.port","587");
        System.out.println("EMAIL "+receive);
        Session session = Session.getInstance(pro, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                 return new PasswordAuthentication(myEmail, myPassword);
        }
        });
        Message m = new MimeMessage(session);
         try{
            System.out.println("email"+myEmail);
            m.setFrom(new InternetAddress(myEmail));
            m.setRecipient(Message.RecipientType.TO, new InternetAddress(receive));
            m.setSubject(subject);
            m.setText(text);
        }catch(MessagingException e){
            System.out.println("Error");
        }
        Transport.send(m);
    }
}
