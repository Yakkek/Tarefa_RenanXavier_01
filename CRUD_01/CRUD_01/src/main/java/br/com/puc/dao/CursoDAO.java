//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package br.com.puc.dao;

import br.com.puc.config.ConnectionFactory;
import br.com.puc.model.Area;
import br.com.puc.model.Cursos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CursoDAO implements ICursoDAO {
    public CursoDAO() {
    }

    public Cursos create(Cursos curso) {
        try {
            Connection connection = ConnectionFactory.getConnection();

            try {
                String query = "INSERT INTO Cursos(nome, sigla, area)VALUES (?,?,?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, curso.getNome());
                statement.setString(2, curso.getSigla());
                statement.setString(3, curso.getArea().toString());
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

            return curso;
        } catch (SQLException var7) {
            throw new RuntimeException(var7);
        }
    }

    public Cursos update(Cursos curso) {
        try {
            Connection connection = ConnectionFactory.getConnection();

            try {
                String query = "Update cursos SET nome = ?, sigla = ?, area = ? WHERE codigo = ?;";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, curso.getNome());
                statement.setString(2, curso.getSigla());
                statement.setString(3, curso.getArea().toString());
                statement.setLong(4, curso.getCodigo());
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

            return curso;
        } catch (SQLException var7) {
            throw new RuntimeException();
        }
    }

    public void delete(Long codigo) {
        try {
            Connection connection = ConnectionFactory.getConnection();

            try {
                String query = "Delete FROM cursos Where codigo = ?;";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setLong(1, codigo);
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

    public static List<Cursos> findAll() {
        String query = "SELECT * FROM cursos";
        List<Cursos> lista = new ArrayList();

        try {
            Connection connection = ConnectionFactory.getConnection();

            try {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.executeQuery();
                ResultSet rs = statement.executeQuery();

                while(rs.next()) {
                    Cursos curso = new Cursos();
                    curso.setCodigo(rs.getLong("codigo"));
                    curso.setNome(rs.getString("nome"));
                    curso.setSigla(rs.getString("sigla"));
                    curso.setArea(rs.getString("area"));
                    lista.add(curso);
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

    public Optional<Cursos> findById(Long codigo) {
        String query = "SELECT * FROM cursos WHERE codigo = ? ";

        Cursos curso;
        try {
            Connection connection = ConnectionFactory.getConnection();

            try {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setLong(1, codigo);
                statement.executeQuery();
                ResultSet rs = statement.executeQuery();
                rs.next();
                curso = new Cursos(rs.getLong("codigo"), rs.getString("nome"), rs.getString("sigla"), rs.getString("area"));
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

        return Optional.ofNullable(curso);
    }


    public List<Cursos> findByArea(String area) {
        String query = "SELECT * FROM cursos WHERE area = ? ";
        List<Cursos> lista = new ArrayList();

        try {
            Connection connection = ConnectionFactory.getConnection();

            try {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, area.toString());
                ResultSet rs = statement.executeQuery();

                while(rs.next()) {
                    Cursos curso = new Cursos();
                    curso.setCodigo(rs.getLong("codigo"));
                    curso.setNome(rs.getString("nome"));
                    curso.setSigla(rs.getString("sigla"));
                    curso.setArea(rs.getString("area"));
                    lista.add(curso);
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

    public List<Cursos> findBySigla(String sigla) {
        String query = "SELECT * FROM cursos WHERE sigla = ? ";
        List<Cursos> lista = new ArrayList();

        try {
            Connection connection = ConnectionFactory.getConnection();

            try {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, sigla);
                ResultSet rs = statement.executeQuery();

                while(rs.next()) {
                    Cursos curso = new Cursos();
                    curso.setCodigo(rs.getLong("codigo"));
                    curso.setNome(rs.getString("nome"));
                    curso.setSigla(rs.getString("sigla"));
                    curso.setArea(rs.getString("area"));
                    lista.add(curso);
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
