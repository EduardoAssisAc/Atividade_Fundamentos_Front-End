package br.ufac.sgcm.dao;

import java.util.List;

public interface IDao<T> { // T representa um objeto
    // Definir métodos que seráo implementados nas classes Dao
    List<T> get(); // todos
    T get(Long id); // pesquisar por id 
    List<T> get(String termoBusca); // pesquisar termo de busca
    int insert(T objeto);
    int update(T objeto);
    int delete(T objeto);
}
