package com.kuang.asynctask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2020/10/10 20:34
 */
@Service
public class ScheduledService {
    @Autowired
    private SendMailService sendMailService;
    //cron  表达式
    @Scheduled(cron = "0/20 * * * * ?")
    public void hello() throws MessagingException {
        sendMailService.sendMail(true,"轰炸","你个傻逼","1600767556@qq.com","1909114122@qq.com");
        System.out.println("发送成功");
    }
}
