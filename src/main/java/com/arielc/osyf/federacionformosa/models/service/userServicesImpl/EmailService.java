package com.arielc.osyf.federacionformosa.models.service.userServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendResetPasswordEmail(String to, String resetUrl) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("admin@caritaschiclayo.org.pe"); 
        message.setTo(to);
        message.setSubject("Restablecimiento de contraseña");
        message.setText("Para restablecer tu contraseña, haz clic en el siguiente enlace: " + resetUrl);
        mailSender.send(message);
    }
}