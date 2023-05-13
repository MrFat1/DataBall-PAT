package com.databall.DataBall.repository;

import com.databall.DataBall.dao.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.tokens.Token;

import java.nio.channels.SelectableChannel;
import java.sql.*;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    < S extends User > S save(S entity);
    < S extends User > Iterable< S> saveAll(Iterable< S> entities);
     @Query("SELECT * FROM USERS") //Sin parámetros
     List< User> myQuery();

    @Query("UPDATE USER SET " +
            "USER.FIRST_NAME= :userName , USER.LAST_NAME= :lastName WHERE PERSON.ID= :id ")
    int updateUSERname(
            @Param("userName") String userName,
            @Param("lastName") String lastName,
            @Param("id") Long id);
    @Query("UPDATE USER SET " +
            "USER.EMAIL= :userName WHERE USER.ID= :id ")
    int updateEmail(
            @Param("email") String email,

            @Param("id") Long id);


    void deleteById(Integer id);
}
