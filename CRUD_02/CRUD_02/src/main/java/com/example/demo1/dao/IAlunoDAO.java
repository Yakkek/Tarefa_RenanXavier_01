package com.example.demo1.dao;


import com.example.demo1.enums.Cursos;
import com.example.demo1.model.Aluno;

import java.util.List;
import java.util.Optional;

public interface IAlunoDAO {

    Aluno create(Aluno aluno);
    Aluno update(Aluno aluno);

    void delete(Long matricula);

    List<Aluno> findAll();

    Optional<Aluno> findById(Long matricula);

    List<Aluno> findByCurso(Cursos curso);



}
