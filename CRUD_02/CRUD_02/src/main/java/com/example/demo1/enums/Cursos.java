package com.example.demo1.enums;

import java.io.Serializable;

public enum Cursos implements Serializable {

    ADS("Análise e Desenvolvimento de Sistemas"),
    ECMP("Engenharia da Computação"),
    CCMP("Ciências da computação"),
    OUTROS("Outros");


    private String nomeCurso;

    private Cursos (String nomeCurso) {

        this.nomeCurso = nomeCurso;
    }
    public String nomeCurso() {
        return this.nomeCurso;
    }
}
