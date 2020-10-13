package com.kuang.asynctask;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.awt.print.Book;
import java.io.File;

@SpringBootTest
class AsynctaskApplicationTests {
    @Autowired
    JavaMailSender mailSender;

    @Test
    void contextLoads() {
        //一个简单的邮件
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("少司命你好");
        simpleMailMessage.setText("感谢来到我的人生");
        simpleMailMessage.setTo("1600767556@qq.com");
        simpleMailMessage.setFrom("1909114122@qq.com");
        mailSender.send(simpleMailMessage);
    }

    @Test
    void contextLoads2() throws MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        //组装
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setSubject("少司命你好!");
        mimeMessageHelper.setText("<p style='color:red'>谢谢你来到我的人生</p>", true);
        //附件
        //mimeMessageHelper.addAttachment("1.jpg",new File("C:\\Users\\shaoshao\\Pictures\\Q版壁纸"));
        mimeMessageHelper.setTo("1600767556@qq.com");
        mimeMessageHelper.setFrom("1909114122@qq.com");
        mailSender.send(mimeMessage);
    }

    /**
     * @param html
     * @param subject
     * @param text
     * @param to
     * @param from
     * @throws MessagingException
     * @Author 少司命
     */
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
