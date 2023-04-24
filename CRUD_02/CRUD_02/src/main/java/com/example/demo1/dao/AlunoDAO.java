package com.example.demo1.dao;



import com.example.demo1.config.ConnectionFactory;
import com.example.demo1.enums.Cursos;
import com.example.demo1.model.Aluno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlunoDAO implements IAlunoDAO {


    @Override
    public Aluno create(Aluno aluno) {

        try (Connection conn = ConnectionFactory.getConnection()) {

            String query = "INSERT INTO alunos(nome, maioridade, sigla_curso, sexo)VALUES (?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, aluno.getName());
            statement.setBoolean(2, aluno.isMaioridade());
            statement.setString(3, aluno.getCurso());
            statement.setString(4, aluno.getSexo());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return aluno;
    }

    @Override
    public Aluno update(Aluno aluno) {

        try(Connection conn = ConnectionFactory.getConnection()) {

            String query = "UPDATE Alunos SET nome = ?, maioridade = ?, sigla_curso = ?, sexo = ? WHERE matricula = ?";

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setString(1, aluno.getName());
            statement.setBoolean(2, aluno.isMaioridade());
            statement.setString(3, aluno.getCurso());
            statement.setString(4, aluno.getSexo());
            statement.setLong(5, aluno.getMatricula());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Aluno não encontrado com matricula " + aluno.getMatricula());
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

        return aluno;

    }

    @Override
    public void delete(Long matricula) {

        try(Connection conn = ConnectionFactory.getConnection()) {

            String query = "DELETE FROM Alunos where matricula = ?";

            PreparedStatement st = conn.prepareStatement(query);

            st.setLong(1,matricula);
            st.executeUpdate();

        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Aluno> findAll() {

        List<Aluno> lista = new ArrayList<>();

        String query = "SELECT * FROM alunos";

        try (Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement st = conn.prepareStatement(query);
            st.executeQuery();
            ResultSet rs = st.executeQuery();

            while(rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setName(rs.getString("nome"));
                aluno.setMatricula(rs.getLong("matricula"));
                aluno.setCurso(rs.getString("sigla_curso"));
                aluno.setMaioridade(rs.getBoolean("maioridade"));
                aluno.setSexo(rs.getString("sexo"));
                lista.add(aluno);
            }
            return lista;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Optional<Aluno> findById(Long matricula) {
        String query = "SELECT * FROM alunos WHERE matricula = ?";
        Aluno aluno;
        try (Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(query);

            statement.setLong(1, matricula);
            statement.executeQuery();

            ResultSet rs = statement.executeQuery();
            rs.next();

            aluno = new Aluno();
            aluno.setName(rs.getString("nome"));
            aluno.setMatricula(rs.getLong("matricula"));
            aluno.setCurso(rs.getString("sigla_curso"));
            aluno.setMaioridade(rs.getBoolean("maioridade"));
            aluno.setSexo(rs.getString("sexo"));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.ofNullable(aluno);
    }

    @Override
    public List<Aluno> findByCurso(Cursos curso) {
        String query = "SELECT * FROM alunos WHERE curso = ?";
        List<Aluno> alunos = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, curso.toString());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setName(rs.getString("nome"));
                aluno.setMatricula(rs.getLong("matricula"));
                aluno.setCurso(rs.getString("sigla_curso"));
                aluno.setMaioridade(rs.getBoolean("maioridade"));
                aluno.setSexo(rs.getString("sexo"));
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alunos;
    }

}
