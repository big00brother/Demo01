package com.test;

public interface SmsService {
    String send(String message);

    String receive(String message);
}
