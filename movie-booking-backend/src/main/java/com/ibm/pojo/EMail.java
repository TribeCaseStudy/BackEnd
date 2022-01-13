package com.ibm.pojo;

import javax.mail.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EMail {
	
	public void conn(String recipient,String name)
	{
		String sender="deepshikha4862@gmail.com";
		
		String host= "smtp.gmail.com";
		
		Properties properties=System.getProperties();
		
		properties.setProperty("mail.smtp.auth", "true");
		
		properties.setProperty("mail.smtp.ssl.enable", "true");
		
		properties.setProperty("mail.smtp.host", host);
		
		properties.setProperty("mail.smtp.port", "465");//tsl=587
		
		Session session=Session.getDefaultInstance(properties,new javax.mail.Authenticator()
				{
					protected PasswordAuthentication getPasswordAuthentication()
					{
						return new PasswordAuthentication("deepshikha4862@gmail.com", "Deep@1999#");
					}
				});
		
		
		try {
			MimeMessage message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(sender));
			
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			
			message.setSubject("Blockbusters");
			
			message.setContent(name,"text/html");
			
			//message.setText("text mail test");
			
			Transport.send(message);
			
			System.out.println("mail successfully sent");
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
