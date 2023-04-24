//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package br.com.puc.dao;

import br.com.puc.config.ConnectionFactory;
import br.com.puc.model.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlunoDAO implements IAlunoDAO {
    public AlunoDAO() {
    }

    public Aluno create(Aluno aluno) {
        try {
            Connection connection = ConnectionFactory.getConnection();

            try {
                String query = "INSERT INTO alunos(matricula,nome, maioridade, sigla_curso, sexo)VALUES (?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setLong(1, aluno.getMatricula());
                statement.setString(2, aluno.getNome());
                statement.setBoolean(3, aluno.isMaioridade());
                statement.setString(4, aluno.getCurso());
                statement.setString(5, aluno.getSexo());
                statement.executeUpdate();
            } catch (Throwable var6) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var5) {
                        var6.addSuppressed(var5);
                    }
                }

                throw var6;
            }

            if (connection != null) {
                connection.close();
            }

            return aluno;
        } catch (SQLException var7) {
            throw new RuntimeException(var7);
        }
    }

    public Aluno update(Aluno aluno) {
        try {
            Connection connection = ConnectionFactory.getConnection();

            try {
                String query = "Update alunos SET nome = ?, maioridade = ?, curso_sigla = ?, sexo = ? WHERE matricula = ?;";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, aluno.getNome());
                statement.setBoolean(2, aluno.isMaioridade());
                statement.setString(3, aluno.getCurso());
                statement.setString(4, aluno.getSexo());
                statement.setLong(5, aluno.getMatricula());
                statement.executeUpdate();
            } catch (Throwable var6) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var5) {
                        var6.addSuppressed(var5);
                    }
                }

                throw var6;
            }

            if (connection != null) {
                connection.close();
            }

            return aluno;
        } catch (SQLException var7) {
            throw new RuntimeException();
        }
    }

    public void delete(Long matricula) {
        try {
            Connection connection = ConnectionFactory.getConnection();

            try {
                String query = "Delete FROM alunos Where matricula = ?;";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setLong(1, matricula);
                statement.executeUpdate();
            } catch (Throwable var6) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var5) {
                        var6.addSuppressed(var5);
                    }
                }

                throw var6;
            }

            if (connection != null) {
                connection.close();
            }

        } catch (SQLException var7) {
            throw new RuntimeException(var7);
        }
    }

    public static List<Aluno> findAll() {
        String query = "SELECT * FROM alunos";
        List<Aluno> lista = new ArrayList();

        try {
            Connection connection = ConnectionFactory.getConnection();

            try {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.executeQuery();
                ResultSet rs = statement.executeQuery();

                while(rs.next()) {
                    Aluno aluno = new Aluno();
                    aluno.setMatricula(rs.getLong("matricula"));
                    aluno.setNome(rs.getString("nome"));
                    aluno.setMaioridade(rs.getBoolean("maioridade"));
                    aluno.setCurso(rs.getString("sigla_curso"));
                    aluno.setSexo(rs.getString("sexo"));
                    lista.add(aluno);
                }
            } catch (Throwable var8) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var7) {
                        var8.addSuppressed(var7);
                    }
                }

                throw var8;
            }

            if (connection != null) {
                connection.close();
            }

            return lista;
        } catch (SQLException var9) {
            throw new RuntimeException(var9);
        }
    }

    public List<Aluno> findById (Long matricula) {
        String query = "SELECT * FROM alunos WHERE matricula = ? ";

        Aluno aluno;
        try {
            Connection connection = ConnectionFactory.getConnection();

            try {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setLong(1, matricula);
                statement.executeQuery();
                ResultSet rs = statement.executeQuery();
                rs.next();
                aluno = new Aluno(rs.getLong("matriucla"), rs.getString("nome"), rs.getBoolean("maioridade"), rs.getString("curso_sigla"), rs.getString("sexo"));
            } catch (Throwable var8) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var7) {
                        var8.addSuppressed(var7);
                    }
                }

                throw var8;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var9) {
            throw new RuntimeException(var9);
        }

        return null;
    }

    public List<Aluno> findByCurso(String curso) {
        String query = "SELECT * FROM alunos WHERE sigla_curso = ? ";
        List<Aluno> lista = new ArrayList();

        try {
            Connection connection = ConnectionFactory.getConnection();

            try {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, curso.toString());
                ResultSet rs = statement.executeQuery();

                while(rs.next()) {
                    Aluno aluno = new Aluno();
                    aluno.setMatricula(rs.getLong("matricula"));
                    aluno.setNome(rs.getString("nome"));
                    aluno.setMaioridade(rs.getBoolean("maioridade"));
                    aluno.setCurso(rs.getString("sigla_curso"));
                    aluno.setSexo(rs.getString("sexo"));
                    lista.add(aluno);
                }
            } catch (Throwable var9) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var8) {
                        var9.addSuppressed(var8);
                    }
                }

                throw var9;
            }

            if (connection != null) {
                connection.close();
            }

            return lista;
        } catch (SQLException var10) {
            throw new RuntimeException(var10);
        }
    }
}
