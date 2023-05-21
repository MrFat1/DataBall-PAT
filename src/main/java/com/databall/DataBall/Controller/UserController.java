package com.databall.DataBall.Controller;


import com.databall.DataBall.dao.User;
import com.databall.DataBall.dao.cuenta;
import com.databall.DataBall.services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

import static java.lang.System.out;

@Controller


public class UserController {
    @Autowired
    MyService myService;
    private static User u=null;
    @PostMapping(value = "/enviar")
    public String CrearUser(String nombre,String surname,String email,String verificacion,String password )
    {

        User u=new User(nombre,surname,email);

        agregarUser(u);
        myService.setPassword(u.getUSERID(),password);

        return "redirect:/login.html";
    }
    public void agregarUser(@ModelAttribute User U) {

        myService.SetUSER(U);
    }
    @PostMapping(value="/eliminar")
    public void eliminarUser(String correo, String password)
    {
        //Pongo una "medida de seguridad para que la gente no pueda borrar cuentas aleatorias
        User u=myService.getUserCorreo(correo);
        /*if(u.ge)falta la relacion entre user y cuenta para sacar la password de u y compararla a la que te da */
        //Luego si te da bien borras el usuario y de lo contrario no; se podria poner un codigo o una advertencia al cliente, devolviendo una ACK o una NACK
        //myService.DeleteUserbyID(U);
    }
    public boolean comprobarUser(User u, String password)
    {

        cuenta c=myService.getPasssword(u.getUSERID());

        if(c.getPassword().equals(password))
        {
            return true;
        }
        return false;
    }
    @GetMapping(path="/logg/{Correo}/{password}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> Log(@PathVariable String Correo, @PathVariable String password)
    {

        User u=myService.getUserCorreo(Correo);
        String id= String.valueOf(u.getUSERID());
        System.out.println(id);
        if(comprobarUser(u,password)==true) {
            this.u=u;
        }
        return ResponseEntity.ok().body(id);
    }
    @GetMapping(path="/Perfi",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> a()
    {
        if(u==null)
            return ResponseEntity.ok().body(0);
        return ResponseEntity.ok().body(u);
    }
    @PostMapping(path="/actualizar/{nombre}/{apellido}/{id}/{email}")
    public void aaaaa(@PathVariable String nombre, @PathVariable String apellido, @PathVariable int id,@PathVariable String email)
    {
        myService.ActualizarUser(nombre, apellido, id, email);
        u=myService.getUserrr(id);

    }
}

