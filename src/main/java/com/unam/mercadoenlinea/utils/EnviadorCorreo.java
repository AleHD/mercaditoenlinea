package com.unam.mercadoenlinea.utils;

import com.unam.mercadoenlinea.dtos.UsuarioDto;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EnviadorCorreo {
	public static void sendWelcomeMessage(String username, String email, String pwd) throws MessagingException {
		// Prepare message info
		String to = email;
		String from = "notificaciones.mercadoenlinea@gmail.com";
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		Session session = Session.getInstance(properties,
				new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(from, "zxhulfwnrnvjtpja");
					}
				}
		);

		// Setup message
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject("Bienvenido a mercadoenlinea, " + username);
		message.setText(
			"Estimado " + username + ":\n\nHemos guardado su registro en " +
			"mercadoenlinea. La contraseña asignada para su usuario es: " +
			pwd + "\n\nUn saludo cordial,\nEl equipo de mercadoenlinea"
		);

		// Send message
		Transport.send(message);
	}
}
