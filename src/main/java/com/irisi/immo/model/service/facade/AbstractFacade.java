package com.irisi.immo.model.service.facade;

import java.util.List;

public interface AbstractFacade<T> {

    T insert(T t);

    T findByRef(Long id);

    List<T> findAll();

    int delete(Long id);


}
