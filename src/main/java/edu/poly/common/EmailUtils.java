package edu.poly.common;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import edu.poly.domain.Email;

public class EmailUtils {
	public static void send(Email email) 
			throws Exception {  // gui thong tin email di
		
		Properties prop = new Properties();  // cau hinh thong qua dia chi
		
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.host", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		
		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email.getFrom(), email.getFromPassword());  // su dung do xac thuc truyen vao
			}
		});
		
		try {
			
			Message message = new MimeMessage(session);  // tao doi tuong mes
			
			message.setFrom(new InternetAddress(email.getFrom()));  // thiet ap tham so
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getTo())); // thiet lap danh sach nguoi nhan
		    message.setSubject(email.getSubject());   // t.lap tieu de mail
			message.setContent(email.getContent(), "text/html; charset=utf-8"); // t.lap noi dung mail (nd, dinh dang)
		
		    Transport.send(message);   // send = gui
		    
		    
		} catch (Exception e) {
			e.printStackTrace();
			
			throw e;
		}
	}
}
