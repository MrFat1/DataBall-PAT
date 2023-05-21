package com.databall.DataBall.repository;

import com.databall.DataBall.dao.User;
import com.databall.DataBall.dao.cuenta;
import org.springframework.data.repository.CrudRepository;

public interface CuentaRepository extends CrudRepository<cuenta, Integer> {
}