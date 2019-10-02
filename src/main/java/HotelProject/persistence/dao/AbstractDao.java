/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelProject.persistence.dao;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Jackson
 * @param <T>
 */
public interface AbstractDao<T> {

    EntityManager getEntityManager();

    void persist(T entity);

    void remove(T entity);

    T merge(T entity);

    T getReference(String id);

    T find(String id);

    T find(String id, boolean refresh);

    List<T> getList(String qlString, Object[] params);

    List<T> getList(String qlString, Object[] params, int[] range);

    long getCount(String qlString, Object[] params);

    int excuteUpdate(String qlString, Object[] params);

}