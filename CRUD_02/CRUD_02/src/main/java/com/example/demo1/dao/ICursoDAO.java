package com.example.demo1.dao;




import com.example.demo1.enums.Areas;
import com.example.demo1.model.Curso;

import java.util.List;
import java.util.Optional;

public interface ICursoDAO {

    Curso create(Curso curso);
    Curso update(Curso curso);
    void delete(Long codigo);

    List<Curso> findAll();
    Optional<Curso> findById(Long codigo);

    List<Curso> findByArea(Areas area);

    List<Curso> findBySigla(String sigla);


}
