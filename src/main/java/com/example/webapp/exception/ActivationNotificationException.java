package com.example.webapp.exception;

import com.example.webapp.shared.Messages;
import org.springframework.context.i18n.LocaleContextHolder;

public class ActivationNotificationException extends RuntimeException {
    public ActivationNotificationException() {
        super(Messages.getMessageForLocale("web-app.create.user.failure", LocaleContextHolder.getLocale()));
    }
}
