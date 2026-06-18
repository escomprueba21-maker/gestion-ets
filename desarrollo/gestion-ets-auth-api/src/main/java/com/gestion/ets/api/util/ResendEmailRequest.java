package com.gestion.ets.api.util;

import java.util.List;

public class ResendEmailRequest {
    public String from;
    public List<String> to;
    public String subject;
    public String html;

    public ResendEmailRequest(String from, String to, String subject, String html) {
        this.from = from;
        this.to = List.of(to);
        this.subject = subject;
        this.html = html;
    }
}