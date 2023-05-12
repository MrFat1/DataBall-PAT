/*******************************************************************************
 * Copyright (c) 2023 Universidad de Comillas ICAI.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the company
 * which accompanies this distribution
 *
 * Contributors:
 *     Universidad de Comillas - ICAI
 *******************************************************************************/


package edu.comillas.icai.pat.ejemplopat.service;

import edu.comillas.icai.pat.ejemplopat.DAO.User;
import edu.comillas.icai.pat.ejemplopat.DTO.Usuario;

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
