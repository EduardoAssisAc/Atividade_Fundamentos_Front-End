package br.ufac.sgcm.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface IController<T> {
    List<T> get();

    T get(Long id);

    List<T> get(String termoBusca);

    int delete(T objeto);

    int save(T objeto); //Insert e Update

    List<T> processListRequest(HttpServletRequest request);

    T processFormRequest(HttpServletRequest request, HttpServletResponse response);

}
