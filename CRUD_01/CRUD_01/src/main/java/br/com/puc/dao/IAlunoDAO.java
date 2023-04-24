//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package br.com.puc.dao;

import br.com.puc.model.Aluno;
import java.util.List;

public interface IAlunoDAO {
    Aluno create(Aluno var1);

    Aluno update(Aluno var1);

    void delete(Long var1);

    static List<Aluno> findAll() {
        return null;
    }

    List<Aluno> findById(Long var1);

    List<Aluno> findByCurso(String var1);
}
