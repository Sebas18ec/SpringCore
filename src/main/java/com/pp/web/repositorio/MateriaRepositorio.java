package com.pp.web.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pp.web.entidad.*;

@Repository
public interface MateriaRepositorio extends JpaRepository<Materia, Long>{
	
	
	@Query(value="select * from materia m where m.facultad like %:keyword%", nativeQuery=true)
	List<Materia> findByKeyword(@Param("keyword") String keyword);

}
