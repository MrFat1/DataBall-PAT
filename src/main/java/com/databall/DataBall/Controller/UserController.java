package com.databall.DataBall.Controller;


import com.databall.DataBall.dao.User;
import com.databall.DataBall.services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

import static java.lang.System.out;

@Controller


public class UserController {
    @Autowired
    MyService myService;
    @PostMapping(value = "/enviar")
    public String CrearUser(String nombre,String surname,String email )
    {

        User u=new User(nombre,surname,email);


        agregarUser(u);

        return "redirect:/Html6.html";
    }
    public void agregarUser(@ModelAttribute User U) {

        myService.SetUSER(U);
    }
    @PostMapping(value="/eliminar")
    public void eliminarUser(Integer id, String password)
    {
        //Pongo una "medida de seguridad para que la gente no pueda borrar cuentas aleatorias
        Optional<User> u=myService.getUser(id);
        /*if(u.ge)falta la relacion entre user y cuenta para sacar la password de u y compararla a la que te da */
        //Luego si te da bien borras el usuario y de lo contrario no; se podria poner un codigo o una advertencia al cliente, devolviendo una ACK o una NACK
        //myService.DeleteUserbyID(U);
    }
}
