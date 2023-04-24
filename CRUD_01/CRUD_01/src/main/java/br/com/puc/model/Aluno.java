//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package br.com.puc.model;

public class Aluno {
    private Long matricula;
    private String nome;
    private boolean maioridade;
    private String curso;
    private String sexo;

    public Aluno() {
    }

    public Aluno(Long matricula, String nome, boolean maioridade, String curso, String sexo) {
        this.matricula = matricula;
        this.nome = nome;
        this.maioridade = maioridade;
        this.curso = curso;
        this.sexo = sexo;
    }

    public Long getMatricula() {
        return this.matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isMaioridade() {
        return this.maioridade;
    }

    public void setMaioridade(boolean maioridade) {
        this.maioridade = maioridade;
    }

    public String getCurso() {
        return this.curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
