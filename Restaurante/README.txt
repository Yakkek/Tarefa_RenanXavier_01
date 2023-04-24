Instituição: PUC GOIÁS.
Nome da escola: ANÁLISE E DESENVOLVIMENTO DE SISTEMAS.
Nome da disciplina: DESENVOLVIMENTO DE SOFTWARE CLIENTE/SERVIDOR.
Nome do aluno: RENAN XAVIER FERREIRA PINTO.
Nome do trabalho: RESTAURANTE.
Turma: CMP1119 C02

Explicação de como executar o projeto:

--INTRODUÇÃO--

Restaurante virtual com as especificações mostrados no arquivo anexado (Aula 07).

--INFORMAÇÕES DE SISTEMA--

Banco de dados: PostgreeSql (pgAdmin 4).
Versão do java: "11.0.12" 2021-07-20
IDE: IntelliJ IDEA 2022.3.3

--ADAPTAÇÃO DOS ARQUIVOS (RestauranteDono)--

1° Vá para Pasta: src > Main > com.example.restaurantformanagers > config > ConnectionFactory
2° Adapte a linha 15 para o seu banco de dados.
3° Vá para Pasta: src > pom.xml
4° Adapte as depencidas da linha 18-22 (Verificar todas as outras dependencias também é recomendado).

--ADAPTAÇÃO DOS ARQUIVOS (RestauranteDono)--

1° Vá para Pasta: src > Main > com.example.restaurantforusers > config > ConnectionFactory
2° Adapte a linha 10 para o seu banco de dados.
3° Vá para Pasta: src > pom.xml
4° Adapte as depencidas da linha 18-22 (Verificar todas as outras dependencias também é recomendado).

--SCRIPT DE CRIAÇÃO DE DADOS--

CREATE DATABASE restaurante;


CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    nick VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE prato (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    order_number INT NOT NULL
);


--COMO EXECUTAR--

1° Vá para Pasta: src > Main > br.com.puc > Main

Execute o Classe CursoApplication HelloApplication
 