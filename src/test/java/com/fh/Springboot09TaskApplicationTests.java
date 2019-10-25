package com.fh;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot09TaskApplicationTests {

    // 创建邮箱发送对象
    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    public void sendSimpleEmail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        // 设置标题
        simpleMailMessage.setSubject("测试邮件");
        // 设置内容
        simpleMailMessage.setText("测试邮件内容");
        // 设置发送给谁
        simpleMailMessage.setTo("amazingzlei@163.com");
        // 设置发件人是谁 不设置会报错
        simpleMailMessage.setFrom("1298466704@qq.com");

        javaMailSender.send(simpleMailMessage);
    }

    @Test
    public void sendMimeEmail() throws Exception {
        // 通过javaMailSender.createMimeMessage()创建复杂邮件对象
        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
        // MimeMessage对象能设置邮件内容等，需要MimeMessageHelper对象进行设置，在
        // 创建该对象时必须传入true否则报错
        MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage, true);
        // 设置标题
        helper.setSubject("测试邮件");
        // 设置内容
        helper.setText("测试邮件内容");
        // 设置发送给谁
        helper.setTo("amazingzlei@163.com");
        // 设置发件人是谁 不设置会报错
        helper.setFrom("1298466704@qq.com");
        // 设置附件
        helper.addAttachment("1.doc",
                new File("C:/Users/admin/Desktop/曾磊毕业材料/曾磊_20150505128_开题报告.doc"));
        helper.addAttachment("2.doc",
                new File("C:/Users/admin/Desktop/曾磊毕业材料/曾磊_20150505128_论文.doc"));
        javaMailSender.send(mimeMailMessage);
    }

}
