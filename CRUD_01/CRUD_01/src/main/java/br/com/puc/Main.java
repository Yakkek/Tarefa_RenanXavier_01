//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package br.com.puc;

import br.com.puc.dao.AlunoDAO;
import br.com.puc.dao.CursoDAO;
import br.com.puc.model.Aluno;
import br.com.puc.model.Area;
import br.com.puc.model.Cursos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {

        //CREATE CURSO==========================
        /*
        CursoDAO cursoDAO = new CursoDAO();
        Cursos curso = new Cursos();
        curso.setNome("");
        curso.setSigla("");
        curso.setArea("");
        cursoDAO.create(curso);
        System.out.println("CURSO CRIADO COM SUCESSO!");
        */

        //READ CURSOS===========================
        /*
        List<Cursos> lista = CursoDAO.findAll();
        Iterator var6 = lista.iterator();

        while(var6.hasNext()) {
            Cursos a = (Cursos)var6.next();
            System.out.println("_______________________________");
            System.out.println("Codigo: " + a.getCodigo());
            System.out.println("Nome: " + a.getNome());
            System.out.println("Sigla: " + a.getSigla());
            System.out.println("Area: " + a.getArea().toString());
        }
        */

        //UPDATE CURSOS=========================
        /*
        CursoDAO cursoDAO = new CursoDAO();
        Cursos curso = new Cursos();
        curso.setCodigo(4L);
        curso.setNome("teste");
        curso.setSigla("teste");
        curso.setArea("teste");
        cursoDAO.update(curso);
        System.out.println("CURSO EDITADO COM SUCESSO!");
        */

        //DELETE CURSO=========================
        /*
        CursoDAO cursoDAO = new CursoDAO();
        cursoDAO.delete(5L);
        System.out.println("CURSO DELETADO COM SUCESSO!");
        */

        //CREATE ALUNO=========================
        /*
        AlunoDAO alunoDAO = new AlunoDAO();
        Aluno aluno = new Aluno();
        aluno.setMatricula(1L);
        aluno.setCurso("");
        aluno.setMaioridade(true);
        aluno.setNome("");
        aluno.setSexo("");
        alunoDAO.create(aluno);
        System.out.println("ALUNO CRIADO COM SUCESSO!");
        */

        //READ Alunos===========================
        /*
        List<Aluno> lista = AlunoDAO.findAll();
        Iterator var8 = lista.iterator();

        while(var8.hasNext()) {
            Aluno a = (Aluno)var8.next();
            System.out.println("_______________________________");
            System.out.println("Matricula: " + a.getMatricula());
            System.out.println("Nome: " + a.getNome());
            System.out.println("Maioridade: " + a.isMaioridade());
            System.out.println("Sigla Curso: " + a.getCurso());
            System.out.println("Sexo: " + a.getSexo());
        }
        */

        //UPDATE ALUNO=========================
        /*
        AlunoDAO alunoDAO = new AlunoDAO();
        Aluno aluno = new Aluno();
        aluno.setMatricula(4L);
        aluno.setNome("");
        aluno.setMaioridade(false);
        aluno.setCurso("");
        aluno.setSexo("");
        alunoDAO.update(aluno);
        System.out.println("ALUNO EDITADO COM SUCESSO!");
        */
        
        //DELETE ALUNO=========================
        /*
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.delete(1259L);
        System.out.println("ALUNO DELETADO COM SUCESSO!");
        */
    }
}

/*
CREATE TABLE Cursos (
    Codigo SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    sigla VARCHAR(255) UNIQUE,
    area VARCHAR(255)
);

CREATE TABLE Alunos (
    matricula BIGINT PRIMARY KEY,
    nome VARCHAR(255),
    maioridade BOOLEAN,
    sigla_curso VARCHAR(255),
    sexo VARCHAR(1),
    FOREIGN KEY (sigla_curso)
        REFERENCES Cursos (sigla)
);

INSERT INTO cursos(nome, sigla, area) VALUES ('exatas','exa','area1');
INSERT INTO cursos(nome, sigla, area)VALUES ('humanas','hum','area1');
INSERT INTO cursos(nome, sigla, area)VALUES ('biologicas','bio','area1');
INSERT INTO cursos(nome, sigla, area)VALUES ('artes','art','area1');

 */
