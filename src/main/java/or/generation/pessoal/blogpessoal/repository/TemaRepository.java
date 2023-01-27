
package or.generation.pessoal.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import or.generation.pessoal.blogpessoal.model.Tema;

@Repository 
public interface TemaRepository extends JpaRepository<Tema, Long>{
	 public List<Tema> findAllByDescricaoContainingIgnoreCase(@Param("descricao") String descricao);

}
