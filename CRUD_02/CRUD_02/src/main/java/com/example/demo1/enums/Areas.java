package com.example.demo1.enums;

public enum Areas {

    exatas("Exatas"),
    humanas("Humanas"),
    biologicas("Biológicas"),
    artes("Artes");

    private String nomeArea;

    private Areas(String nomeArea) {
        this.nomeArea = nomeArea;
    }

    public String nomeCurso() {
        return this.nomeArea;
    }

}
