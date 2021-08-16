package com.unam.mercadoenlinea.utils;

import javax.mail.*;
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
        message.setSubject("¡Registro en Mercadoenlinea! \uD83D\uDE80 ");
        message.setText(
                "Nos alegra que te unas a esta gran iniciativa, " + username.toUpperCase() + "! \uD83E\uDD73 " +
                        "\n\nEscribimos para informarte que tu registro en nuestra plataforma fue exitoso." +
                        "\n\nPuedes ingresar con los siguientes datos: " +
                        "\nCorreo: " + email +
                        "\nContraseña: " + pwd +
                        "\n\nEstamos emocionados por ayudarte a hacer tus compras en línea de una forma rápida y " +
                        " amigable. \n\n\n\nGracias por contar con nosotros,\nEl equipo de mercadoenlinea."
        );

        // Send message
        Transport.send(message);
    }

    public static void notificacionCompra(String email,
                                          String username,
                                          String titulo, String descripcion, String precio, String foto) throws MessagingException{
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

        // Set up message
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("¡Compra en Mercadoenlinea! \uD83C\uDF81 ");
        message.setText(
                        "¡Felicidades, " + username.toUpperCase() + " tu pedido está en proceso! " +
                        "\n\nTítulo: " + titulo +
                        "\nDescripción: " + descripcion +
                        "\nPrecio: $" + precio +
                        "\n\n¿Curiosidad por ver tu pedido? \uD83D\uDC40 " +
                        "\nConócelo aquí: "+ foto +
                        "\n\n\n\nGracias por comprar con nosotros,\nEl equipo de mercadoenlinea."
        );

        // Send message
        Transport.send(message);
    }

    public static void notificacionVenta(String email,
                                          String username,
                                          String titulo, String descripcion, String precio, String foto) throws MessagingException{
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

        // Set up message
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("¡Vendiste un producto en Mercadoenlinea! \uD83D\uDCAA \uD83D\uDCB0 ");
        message.setText(
                "¡Hola, " + username.toUpperCase() + "!" +
                        "\nUn usuario quiere adquirir tu producto" +
                        "\n\nTítulo: " + titulo +
                        "\nDescripción: " + descripcion +
                        "\nPrecio: $" + precio +
                        "\nFoto: " + foto +
                        "\n¡Tu esfuerzo está rindiendo frutos, sigue así!"+
                        "\n\n\nNos alegra haber sido parte de tu venta." +
                        "\nEl equipo de mercadoenlinea."
        );

        // Send message
        Transport.send(message);
    }
}