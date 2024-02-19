package com.khm.api;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Component;

import com.khm.dto.BoardDto;
import com.khm.dto.BoardVoDto;

@Component
public class EMail {

	public static void naverMailSend(BoardVoDto dto) throws IOException {
		String HOST = "smtp.naver.com";
		String USER = "gusals310@naver.com";
		String PASSWORD = "BMZRT28NVY4M";
		String to=dto.getUser_email();
		System.out.println("--------------------------");
		System.out.println(to);
		System.out.println("--------------------------");
		
		// SMTP 서버 정보를 설정한다.
		Properties props = new Properties();
		props.put("mail.smtp.host", HOST);
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trut", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(USER, PASSWORD);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(USER));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// 메일 제목
			message.setSubject("[날씨의 일기] 답변완료 안내");

			// 메일 내용
//			message.setText(" test Success!!");
			/*message.setContent("<h1>안녕하세요 고객님 날씨의 일기 고객센터입니다.</h1>"
					+ "<p>고객님이 문의주신 내용의 답변이 완료되어 안내드립니다.</p>"
					+ "<p>다음에는 더 빠른 답변으로 찾아뵙겠습니다.</p>"
					+ "<p>감사합니다.</p>"+"<hr><hr><hr>"
					+"<img src='${pageContext.request.contextPath}/resources/image/newLogo.png'>","text/html;charset=UTF-8");*/

			
			
			message.setContent("<div style='font-size: 20px;"
					+ "margin-bottom: 40px;'>"+"<h3>안녕하세요 고객님 날씨의 일기 고객센터입니다.</h3>"
                    + "<p>고객님이 문의주신 내용의 답변이 완료되어 안내드립니다.</p>"
                    + "<p>다음에는 더 빠른 답변으로 찾아뵙겠습니다.</p>"
                    + "<p>감사합니다.</p>"+"</div>"
                   + "<img src='https://ifh.cc/g/rKBfws.png' style='background-color: #f4f4fb;'>","text/html;charset=UTF-8");

			// ...

//			// 이미지를 MimeBodyPart로 첨부
//			MimeBodyPart imagePart = new MimeBodyPart();
//			imagePart.attachFile(new File("newLogo.png"));
//			imagePart.setContentID("<newLogo>");
//
//			// 메시지에 이미지 첨부		
//			Multipart multipart = new MimeMultipart();
//			multipart.addBodyPart(imagePart);
//			message.setContent(multipart);

			
			

			// send the message
			Transport.send(message);
			System.out.println("Success Message Send");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
}
/*
 * "to": "admin@example.com", "subject": "테스트 테스트", "body": "메일 본문",
 * "contentType": "html", "userName": "admin", "isSaveSentMail": true,
 * "isSaveTracking": true, "isSendSeparately": false, "attachments": [ {
 * "filename": "index.html", "fileType": "text/html", "data":
 * "PCFET0NUWVBFIGh0bWw+CjxodG1sIGxhbmc9ImphIj4KPGhlYWQ+Cjx0aXRsZT5XZWxjb21lIHRvIFdPUktTIEFQSTwvdGl0bGU+CjwvaGVhZD4KPGJvZHk+CjxoMT5XZWxjb21lIFRvIFdPUktTIEFQSTwvaDE+CldlbGNvbWUgdG8gdGhlIFdPUktTIEFQSSB3b3JsZC4KPC9ib2R5Pgo8L2h0bWw+"
 * } ] }
 */