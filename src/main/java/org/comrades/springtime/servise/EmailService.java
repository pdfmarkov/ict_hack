package org.comrades.springtime.servise;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text);
}
