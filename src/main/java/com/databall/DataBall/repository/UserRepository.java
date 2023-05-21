package com.databall.DataBall.repository;

import com.databall.DataBall.dao.User;
import com.databall.DataBall.dao.cuenta;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    < S extends User > S save(S entity);
    < S extends User > Iterable< S> saveAll(Iterable< S> entities);
    @Query("SELECT * FROM USERS") //Sin parámetros
    List< User> myQuery();
    @Modifying
    @Query("UPDATE USERS SET " +
            "FIRST_NAME= :nombre ,EMAIL= :email, LAST_NAME= :lastName WHERE ID= :id")
    int updateUSERname(
            @Param("nombre") String nombre,
            @Param("lastName") String apellido,
            @Param("email") String email,
            @Param("id") int id);
    @Query("SELECT * FROM USERS WHERE EMAIL = :correo")
    User getUserCorreo(
            @Param("correo") String correo
    );
    void deleteById(Integer id);
    @Modifying
    @Query("INSERT INTO CUENTA VALUES( :id, :password)")
    void savePassword(
            @Param("id") int id,
            @Param("password") String password
    );
    @Modifying
    @Query("SELECT * FROM CUENTA WHERE ID =:id")
    cuenta getPassword(
            @Param("id") int id
    );
}