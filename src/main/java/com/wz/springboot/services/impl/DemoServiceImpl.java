package com.wz.springboot.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wz.springboot.entities.User;
import com.wz.springboot.mappers.UserMapper;
import com.wz.springboot.services.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    UserMapper userMapper;

    @Override
    public String selectedUserById(int id) {
	User user = userMapper.selectByPrimaryKey(id);
	
	String tmp = "{";
	tmp += "\n\t";
	tmp += "id: ";
	tmp += user.getId();
	tmp += "\n\t";
	tmp += "username: ";
	tmp += user.getUsername();
	tmp += "\n\t";
	tmp += "password: ";
	tmp += user.getPassword();
	tmp += "\n\t";
	tmp += "identity_card: ";
	tmp += user.getIdentityCard();
	tmp += "\n\t";
	tmp += "phone_number: ";
	tmp += user.getPhoneNumber();
	tmp += "\n\t";
	tmp += "job: ";
	tmp += user.getJob();
	tmp += "\n";
	tmp += "}";
	
	System.out.println(tmp);
	
	return tmp;
    }

}
