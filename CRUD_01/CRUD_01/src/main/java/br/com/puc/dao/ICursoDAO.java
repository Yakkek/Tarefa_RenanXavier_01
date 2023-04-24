//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package br.com.puc.dao;

import br.com.puc.model.Area;
import br.com.puc.model.Cursos;
import java.util.List;
import java.util.Optional;

public interface ICursoDAO {
    Cursos create(Cursos var1);

    Cursos update(Cursos var1);

    void delete(Long var1);

    static List<Cursos> findAll() {
        return null;
    }

    Optional<Cursos> findById(Long var1);

    List<Cursos> findByArea(String var1);

    List<Cursos> findBySigla(String var1);
}
