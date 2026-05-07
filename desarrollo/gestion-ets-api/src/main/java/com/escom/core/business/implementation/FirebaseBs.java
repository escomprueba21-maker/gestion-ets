package com.escom.core.business.implementation;

import com.escom.core.business.input.FirebaseService;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class FirebaseBs implements FirebaseService {

    public void enviarNotificacion(String fcmToken, String titulo, String cuerpo) throws FirebaseMessagingException {
        
        var message = Message.builder()
                .setToken(fcmToken)
                .setNotification(Notification.builder()
                        .setTitle(titulo)
                        .setBody(cuerpo)
                        .build())
                .build();

        var response = FirebaseMessaging.getInstance().send(message);
        log.info("Notificación enviada: " + response);
    }
}
