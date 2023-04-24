Instituição: PUC GOIÁS.
Nome da escola: ANÁLISE E DESENVOLVIMENTO DE SISTEMAS.
Nome da disciplina: DESENVOLVIMENTO DE SOFTWARE CLIENTE/SERVIDOR.
Nome do aluno: RENAN XAVIER FERREIRA PINTO.
Nome do trabalho: CRUD sem SceneBuilder (CRUD_01).
Turma: CMP1119 C02

Explicação de como executar o projeto:

--INTRODUÇÃO--

CRUD De Alunos e Cursos SEM o SceneBuilder com Banco de Dados PostgreeSql (pgAdmin 4).

--INFORMAÇÕES DE SISTEMA--

Banco de dados: PostgreeSql (pgAdmin 4).
Versão do java: "11.0.12" 2021-07-20
IDE: IntelliJ IDEA 2022.3.3

--ADAPTAÇÃO DOS ARQUIVOS--

1° Vá para Pasta: src > Main > br.com.puc > config > ConnectionFactory
2° Adapte a linha 18 para o seu banco de dados.
3° Vá para Pasta: src > pom.xml
4° Adapte as depencidas da linha 18-22 (Verificar todas as outras dependencias Maven após também é recomendado).

--SCRIPT DE CRIAÇÃO DE DADOS--

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

--COMO EXECUTAR--

1° Vá para Pasta: src > Main > br.com.puc > Main

As execuções do CRUD estão entre as linhas 24-116 apenas leias os comentários... e faça uma execusão por vez.
 