package or.generation.pessoal.blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import or.generation.pessoal.blogpessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT )
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
	
   @Autowired
   private UsuarioRepository usuarioRepository;
   
   @BeforeAll
   void start(){
	   
	   usuarioRepository.deleteAll();
	   
	   usuarioRepository.save(new Usuario (0L,"leo", "leo@gmail.com","1234456789","https//i.imgur.com/FETvs20.jpg"));
	   
	   usuarioRepository.save(new Usuario (0L,"bruno", "bruno@gmail.com","1234487789","https//i.imgur.com/FEhhs20.jpg"));
	   
	   usuarioRepository.save(new Usuario (0L,"ana", "ana@gmail.com","12344523489","https//i.imgur.com/FETvs5420.jpg"));
	   
	   usuarioRepository.save(new Usuario (0L,"paula", "paula@gmail.com","1234445656789","https//i.imgur.com/FETvsll20.jpg"));	   	   
   }
   
   @Test
   @DisplayName("Retorna 1 usuario")
   public void deveRetornarUmUsuario() {
	   
	   Optional<Usuario> usuario = usuarioRepository.findByUsuario("leo@gmail.com");
	   assertTrue(usuario.get().getUsuario().equals("leo@gmail.com"));
   }
   
   @Test
   @DisplayName("Retorna 3 usuario")
   public void deveRetornarTresUsuario() {
	   
       List<Usuario> ListaDeUsuario = usuarioRepository.findAllByNomeContainingIgnoreCase("ana");
       assertEquals(3, ListaDeUsuario.size());
       assertTrue(ListaDeUsuario.get(0).getNome().equals("leo"));
       assertTrue(ListaDeUsuario.get(1).getNome().equals("bruno"));
       assertTrue(ListaDeUsuario.get(2).getNome().equals("ana"));
   }
   @AfterAll
   public void end() {
	   usuarioRepository.deleteAll();
   }
}
