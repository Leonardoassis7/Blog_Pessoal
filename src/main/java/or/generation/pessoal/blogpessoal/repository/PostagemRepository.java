package or.generation.pessoal.blogpessoal.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import or.generation.pessoal.blogpessoal.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
   public List<Postagem> findAllByTituloContainingIgnoreCase (String Titulo);
}
 