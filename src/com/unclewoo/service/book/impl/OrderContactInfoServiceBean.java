package com.unclewoo.service.book.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.unclewoo.bean.book.OrderContactInfo;
import com.unclewoo.service.base.DaoSupport1;
import com.unclewoo.service.book.OrderContactInfoService;

@Service
public class OrderContactInfoServiceBean extends DaoSupport1<OrderContactInfo> implements OrderContactInfoService{

}
