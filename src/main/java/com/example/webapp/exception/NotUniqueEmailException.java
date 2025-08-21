package com.example.webapp.exception;

public class NotUniqueEmailException extends RuntimeException {
  public NotUniqueEmailException(String message) {
    super(message);
  }
}
