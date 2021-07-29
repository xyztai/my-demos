package com.javat.service.impl;

import com.javat.service.IMessageService;
import org.springframework.stereotype.Service;

/**
 * @Author tai
 * @create 2021-07-29 13:27
 */
@Service
public class MessageService implements IMessageService {
    @Override
    public String echo(String msg) {
        return "[echo]" + msg;
    }
}