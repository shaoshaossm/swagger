package com.kuang.asynctask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2020/10/10 20:49
 */
@Service
public class SendMailService {
    @Autowired
    JavaMailSender mailSender;

    public void sendMail(Boolean html, String subject, String text, String to, String from) throws MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        //组装
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, html);

        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(text, true);
        //附件
        //mimeMessageHelper.addAttachment("1.jpg",new File("C:\\Users\\shaoshao\\Pictures\\Q版壁纸"));
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setFrom(from);
        mailSender.send(mimeMessage);
    }
}
