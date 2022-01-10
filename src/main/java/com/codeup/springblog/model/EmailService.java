package com.codeup.springblog.model;

public class EmailService {
    private final EmailService emailService;

    public EmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    public EmailService getEmailService() {
        return emailService;
    }
}
