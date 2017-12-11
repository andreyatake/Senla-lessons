package com.testHotel.dao;

import java.util.List;

/**
 * Created by андрей on 11.12.2017.
 */
public interface IBaseDAO <T> {
    List<T> getAllEntities();
    void addEntity(T object);
    void removeEntity(T object);
    T getEntity(int id);
    void updateEntity(T object);
}
