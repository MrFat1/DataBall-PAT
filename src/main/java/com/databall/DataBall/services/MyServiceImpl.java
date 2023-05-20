/*******************************************************************************
 * Copyright (c) 2023 Universidad de Comillas ICAI.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the company
 * which accompanies this distribution
 *
 * Contributors:
 *     Universidad de Comillas - ICAI
 *******************************************************************************/


package com.databall.DataBall.services;

import com.databall.DataBall.dao.User;
import com.databall.DataBall.dto.Usuario;
import com.databall.DataBall.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;


@Service
public class MyServiceImpl implements MyService {
	@Autowired
	UserRepository userRepository;

	@Override
	public int SetUSER(User U) { //funciona
		if (U != null) {
			userRepository.save(U);

			return 1;
		}
		return -1;
	}
	@Override
	public void DeleteUserbyID(User u)
	{
		userRepository.deleteById(u.getUSERID());
	}
	@Override
	public  java.lang.Iterable<User> MostrarUsers()
	{
		java.lang.Iterable<User> Users=userRepository.findAll();
		return Users;
	}
	
	@Override
	public boolean findUser(User U)
	{
		if(U!=null)
			return userRepository.existsById(U.getUSERID());
		else
			return false;
	}
	@Override
	public Integer Count()
	{
		Integer i=(int)userRepository.count();
		return i;
	}
	@Override
	public Usuario getUsuario(Integer id) {//Usuarioi es el DTO


			Optional<User> data= userRepository.findById(id);
			Usuario u;

			if (data.isPresent())
				u = new Usuario(data.get().getName(), data.get().getSurname(),data.get().getEmail());
			else
				u= new Usuario("","","");
			return u;

	}
	@Override
	public Optional<User> getUser(Integer id) {
		Optional<User> data = userRepository.findById(id);
		return data;
	}

}
