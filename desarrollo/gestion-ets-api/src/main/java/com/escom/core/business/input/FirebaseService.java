package com.escom.core.business.input;

import com.google.firebase.messaging.FirebaseMessagingException;

public interface FirebaseService {
   void enviarNotificacion(String fcmToken, String titulo, String cuerpo) throws FirebaseMessagingException;
}
