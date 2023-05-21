package com.databall.DataBall.services;

import com.databall.DataBall.dao.User;
import com.databall.DataBall.dao.cuenta;
import com.databall.DataBall.dto.Usuario;
import com.databall.DataBall.repository.CuentaRepository;
import com.databall.DataBall.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MyServiceImpl implements MyService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	CuentaRepository cuentaRepository;
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
	@Override
	public User getUserrr(int id)
	{
		User w=new User();
		Iterable<User> d=userRepository.findAll();
		for (User q: d
		) {if(q.getUSERID()==id)
			w=q;
		}
		return w;
	}
	@Override
	public void setPassword(int id, String password)
	{
		userRepository.savePassword(id,password);
	}
	@Override
	public cuenta getPasssword(int id)
	{

		Optional<cuenta> c=cuentaRepository.findById(id);
		cuenta C = null;
		if(c.isPresent())
		{
			C=new cuenta(c.get().getId(),c.get().getPassword());
		}
		return C;
	}
	@Override
	public User getUserCorreo(String correo)
	{
		User u =userRepository.getUserCorreo(correo);
		return u;
	}
	@Override
	public void ActualizarUser(String nombre, String apellido, int id, String correo)
	{
		userRepository.updateUSERname(nombre,apellido,correo,id);
	}

}
