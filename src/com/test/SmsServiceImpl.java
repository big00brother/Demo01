package com.test;

public class SmsServiceImpl implements SmsService{
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }

    @Override
    public String receive(String message) {
        System.out.println("receive message:" + message);
        return message;
    }


}
