package com.ssanai.jumplearn.service.login;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;
import java.util.Properties;

public class MailSender {
    //to.수신자이메일 주소  subject.메일 제목 content.메일 내용------------------------------예외처리
    public void sendEmail(String to, String subject, String content) throws MessagingException {
        // 이메일 서버 설정
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // 이메일 세션 생성
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("soopgong1007@gmail.com", "eqyrujffkrecwoqk");
            }
        });

        // 메시지 객체 생성
        Message message = new MimeMessage(session);

        // 보내는 사람 주소 설정
        message.setFrom(new InternetAddress("soopgong1007@gmail.com"));

        // 받는 사람 주소 설정
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

        // 메일 제목 설정
        message.setSubject(subject);

        // 메일 내용 설정
        message.setText(content);

        // 메일 전송
        Transport.send(message);
    }
}
