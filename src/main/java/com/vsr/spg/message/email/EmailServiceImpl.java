package com.vsr.spg.message.email;

import com.vsr.spg.config.ApplicationConfig;
import com.vsr.spg.message.MessageConstants;
import com.vsr.spg.message.base.MessengerService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Map;

@Service(MessageConstants.MSG_TYPE_EMAIL)
@Slf4j
public class EmailServiceImpl implements MessengerService<EmailMessage> {


    private String emailSender = "buiducminh111120@gmail.com";

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    @Autowired
    private ApplicationConfig applicationConfig;

    @Override
    public void sendMessageInAsync(EmailMessage message) {
        Context context = new Context();
        sendEmail(message, context);
    }

    @Override
    public void sendMessageInAsync(EmailMessage message, Locale locale) {
        Context context = new Context(locale);
        sendEmail(message, context);
    }

    private void sendEmail(EmailMessage message, Context context) {
        Map<String, String> args = message.getArguments();
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.name());
            helper.setFrom(emailSender);
            helper.setSubject(message.getSubject());
            helper.setTo(message.getReceiver());

            for (Map.Entry<String, String> varEntry : args.entrySet()) {
                context.setVariable(varEntry.getKey(), varEntry.getValue());
            }

            String html = templateEngine.process(message.getTemplate(), context);
            helper.setText(html, true);

            javaMailSender.send(mimeMessage);
        } catch (MessagingException messagingException) {
            log.error("Failed to send the email", messagingException);
        }
    }
}
