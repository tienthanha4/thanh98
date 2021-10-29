package com.devpro.shop16.services;

import org.springframework.stereotype.Service;

import com.devpro.shop16.entities.Contact;

@Service
public class ContactService extends BaseService<Contact>{

	@Override
	protected Class<Contact> clazz() {
		// TODO Auto-generated method stub
		return Contact.class;
	}
	

}
