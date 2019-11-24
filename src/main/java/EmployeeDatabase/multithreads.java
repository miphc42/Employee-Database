/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeeDatabase;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author miphc
 */
public class multithreads implements Runnable{
    String email = "";
    String name = "";
    public multithreads(String email, String name){
        this.email = email;
        this.name = name;
    }
   @Override
    public void run(){
        try {
            if(name.equals("Terminate")){
                SendingEmail.send(email, "You Have Been Terminated", "We regret to inform you that you have been terminated. "
                        + "Please visit the Human Resources office immediately."
                        + "\nFrom, Computer Science Agency Inc.");
            }
            else if(name.equals("Regular")){
                 SendingEmail.send(email,MyHashTable.subject, MyHashTable.text);
            }else{
            SendingEmail.send(email, "Welcome to ComputerScienceAgency", "Thank you for being part of our team "+name+"!"+
                    "\nFrom, Computer Science Agency Inc.");
            }
        } catch (MessagingException ex) {
            Logger.getLogger(multithreads.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
}
