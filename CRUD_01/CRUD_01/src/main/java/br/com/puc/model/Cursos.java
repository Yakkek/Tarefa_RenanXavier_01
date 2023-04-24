//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package br.com.puc.model;

public class Cursos {
    private long codigo;
    private String nome;
    private String sigla;
    private String area;

    public Cursos(long codigo, String nome, String sigla, String area) {
        this.codigo = codigo;
        this.nome = nome;
        this.sigla = sigla;
        this.area = area;
    }

    public Cursos() {
    }

    public long getCodigo() {
        return this.codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return this.sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) { this.area = area; }
}
