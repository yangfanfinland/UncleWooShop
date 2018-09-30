package com.unclewoo.service.book.impl;

import org.springframework.stereotype.Service;

import com.unclewoo.bean.book.Message;
import com.unclewoo.service.base.DaoSupport1;
import com.unclewoo.service.book.MessageService;

@Service
public class MessageServiceBean extends DaoSupport1<Message> implements MessageService{

}
