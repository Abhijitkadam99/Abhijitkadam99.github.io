package com.ezio.Comman;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;

@Controller
public class SendMail {
	
	
	    private static final int BUFFER_SIZE = 4096;
	
		public int sendMail(String subject, String mail,String clmessage) {
	
			final String username = "abkadam099@gmail.com";
			final String password = "xyrqalixpfojpgir";
	
		
			Properties props = new Properties();
     		props.put("mail.smtp.user", username);
		    props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");// 465
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			//	Session s = Session.getInstance(props,new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
			}
				
			});
			
			try {
	
				Message message = new  MimeMessage(session);
				message.setFrom(new InternetAddress(mail));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
			    System.out.println("mail " + mail);
				message.setSubject(subject);
				//message.setSubject("New IB Order Received #"+ orderid);
				/* System.out.println("user_id "+user_id); */
				/*
				 * String
				 * link="<a href='http://35.200.142.134/DentaLinks/admin/verificationcheck?user_id="
				 * +user_id+"'>Click Here For Verification</a>";
				 * System.out.println("link "+link);
				 */
			  message.setContent("<br>Message:- " + clmessage +"", "text/html");
	
				Transport.send(message);
				/* System.out.println("user_id"+user_id); */
				System.out.println("Done");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 1;
		}
	
	
	
	

}
