package com.example.demo1.dao;


import com.example.demo1.config.ConnectionFactory;
import com.example.demo1.enums.Areas;
import com.example.demo1.model.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CursoDAO implements ICursoDAO{


    @Override
    public Curso create(Curso curso) {
        try (Connection conn = ConnectionFactory.getConnection()) {

            String query = "INSERT INTO Cursos" + "(nome, sigla, area)" + "VALUES (?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, curso.getNome());
            statement.setString(2, curso.getSigla());
            statement.setString(3, curso.getArea().toString());

            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            Long codigo = rs.getLong(1);
            curso.setCodigo(codigo);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return curso;
    }

    @Override
    public Curso update(Curso curso) {

        try(Connection conn = ConnectionFactory.getConnection()) {

            String query = "UPDATE Cursos SET nome = ?, sigla = ?, area = ? WHERE codigo = ?";

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setString(1, curso.getNome());
            statement.setString(2, curso.getSigla());
            statement.setString(3, curso.getArea().toString());
            statement.setLong(4, curso.getCodigo());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Curso não encontrado com código " + curso.getCodigo());
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

        return curso;

    }

    @Override
    public void delete(Long codigo) {
        try(Connection conn = ConnectionFactory.getConnection()) {

            String query = "DELETE FROM cursos where codigo = ?";

            PreparedStatement st = conn.prepareStatement(query);

            st.setLong(1,codigo);
            st.executeUpdate();

        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Curso> findAll() {

        List<Curso> lista = new ArrayList<>();

        String query = "SELECT * FROM cursos";

        try (Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement st = conn.prepareStatement(query);
            st.executeQuery();
            ResultSet rs = st.executeQuery();

            while(rs.next()) {
                Curso curso = new Curso();
                curso.setCodigo(rs.getLong("codigo"));
                curso.setNome(rs.getString("nome"));
                curso.setSigla(rs.getString("sigla"));
                curso.setArea(Areas.valueOf(rs.getString("area")));
                lista.add(curso);
            }
            return lista;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Optional<Curso> findById(Long codigo) {

        String query = "SELECT * FROM cursos WHERE codigo = ?";
        Curso curso;
        try (Connection conn = ConnectionFactory.getConnection()) {

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setLong(1, codigo);
            statement.executeQuery();

            ResultSet rs = statement.executeQuery();
            rs.next();

            curso = new Curso();
            curso.setNome(rs.getString("nome"));
            curso.setCodigo(rs.getLong("codigo"));
            curso.setSigla(rs.getString("sigla"));
            curso.setArea(Areas.valueOf(rs.getString("area")));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.ofNullable(curso);

    }

    @Override
    public List<Curso> findByArea(Areas area) {

        String query = "SELECT * FROM cursos WHERE area = ?";
        List<Curso> cursos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, area.toString());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Curso curso = new Curso();
                curso.setNome(rs.getString("nome"));
                curso.setCodigo(rs.getLong("codigo"));
                curso.setSigla(rs.getString("sigla"));
                curso.setArea(Areas.valueOf(rs.getString("area")));
                cursos.add(curso);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cursos;

    }

    @Override
    public List<Curso> findBySigla(String sigla) {

        String query = "SELECT * FROM cursos WHERE sigla = ?";
        List<Curso> cursos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, sigla);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Curso curso = new Curso();
                curso.setNome(rs.getString("nome"));
                curso.setCodigo(rs.getLong("codigo"));
                curso.setSigla(rs.getString("sigla"));
                curso.setArea(Areas.valueOf(rs.getString("area")));
                cursos.add(curso);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cursos;

    }

}
