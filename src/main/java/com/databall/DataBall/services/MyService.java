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

import java.util.Optional;

public interface MyService {



    Object getHealthCheck(String s);

    int SetUSER(User U); // insert User

    void DeleteUserbyID(User u);

    Iterable<User> MostrarUsers();

    boolean findUser(User U);

    Integer Count();

    Usuario getUsuario(Integer id); //Select User

    Optional<User> getUser(Integer id);
}
