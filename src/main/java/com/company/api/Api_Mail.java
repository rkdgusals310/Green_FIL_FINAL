package com.company.api;
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

import org.springframework.stereotype.Component;

import com.company.dto.UserDto;

@Component
public class Api_Mail {
	
public void sendMail(UserDto dto, String sub, String content) {
		
		String host="smtp.naver.com";
		String user="testdump123@naver.com";
		String password="Ljs159753";
		String subject=sub;
		String to=dto.getUser_email();
		Properties props= new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trut", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		Session session= Session.getDefaultInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
			
		});
		
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setContent(""+"<div style='font-size: 20px;"+ "margin-bottom: 40px;'>"
			+"<h3>"+subject+"</h3>"
			+"<p>"+content+"</p>"   
			+"<p>감사합니다.</p>"+"</div>"
			+"<img src='https://ifh.cc/g/rKBfws.png' style='background-color: #f4f4fb;'>", "text/html; charset=euc-kr");
			Transport.send(message);
			System.out.println("@@MAIL SUCCESSSS@@");
		}catch(AddressException e) {
			e.printStackTrace();
		}catch(MessagingException e) {
			e.printStackTrace();
		}
	}
}

