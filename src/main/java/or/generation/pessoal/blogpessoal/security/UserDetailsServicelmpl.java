package or.generation.pessoal.blogpessoal.security;

import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import or.generation.pessoal.blogpessoal.model.Usuario;
import or.generation.pessoal.blogpessoal.repository.UsuarioRepository;

@Service
public class UserDetailsServicelmpl implements UserDetailsService {

	
	@Autowired
	private UsuarioRepository usuariorepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Optional<Usuario> usuario = usuariorepository.findByUsuario(userName);

		if (usuario.isPresent())
			return new UserDetailslmpl(usuario.get());
		else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
	}
}

