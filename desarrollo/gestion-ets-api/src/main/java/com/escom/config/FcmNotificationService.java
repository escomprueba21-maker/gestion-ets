package com.escom.config;

import com.google.firebase.messaging.*;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;

@ApplicationScoped
@Slf4j
public class FcmNotificationService {

    public void enviarNotificacion(List<String> fcmTokens, String titulo, String cuerpo) {
        if (fcmTokens == null || fcmTokens.isEmpty()) {
            return;
        }

        List<Message> messages = fcmTokens.stream()
                .filter(token -> token != null && !token.isBlank())
                .map(token -> Message.builder()
                        .setToken(token)
                        .setNotification(Notification.builder()
                                .setTitle(titulo)
                                .setBody(cuerpo)
                                .build())
                        .build())
                .toList();

        try {
            BatchResponse response = FirebaseMessaging.getInstance().sendEach(messages);
            log.info("FCM enviados: {} exitosos, {} fallidos",
                    response.getSuccessCount(), response.getFailureCount());

            if (response.getFailureCount() > 0) {
                response.getResponses().forEach(r -> {
                    if (!r.isSuccessful()) {
                        log.warn("Error FCM: {}", r.getException().getMessage());
                    }
                });
            }
        } catch (FirebaseMessagingException e) {
            log.error("Error enviando notificaciones FCM", e);
        }
    }
}