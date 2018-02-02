package com.dao;

import com.dao.api.IBaseDAO;
import com.entity.WebEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDAO<T extends WebEntity> implements IBaseDAO<T> {


    @Autowired
    private SessionFactory sessionFactory;
    private Class<T> persistentClass;
    public BaseDAO(Class clazz) {
        this.persistentClass = clazz;
    }

    public BaseDAO(){}


    public Class getEntityClass() {
        return this.persistentClass;
    }


    public void addEntity(T entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public void updateEntity(T entity) {
        getSession().update(entity);
    }



    public void deleteEntity(Integer id) {
        T entity = null;
        entity = (T) getSession().load(getEntityClass(), id);
        getSession().delete(entity);
    }

    public T getEntityById(Integer id) {
        T entity = null;
        entity = (T) getSession().load(getEntityClass(), id);
        return entity;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public void setPersistentClass(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    /*
    public void deleteEntity(Integer id) {
        Transaction transaction = getSession().beginTransaction();
        Query createQuery = getSession().createQuery(" delete "+getTableName()+" where id =:param ");
        createQuery.setParameter("param", id);
        createQuery.executeUpdate();
        transaction.commit();
    }

    public List<T> getAllEntities( TypeSorting sorting) {

        Transaction transaction = getSession().beginTransaction();
        Query createQuery = getSession().createQuery(" from "+getTableName() );

        if(sorting!=TypeSorting.NO_SORTING){
            createQuery.getQueryString().concat(" order by :sorting");
            createQuery.setParameter("sorting",sorting.getType());
        }
        List <T> entityList=createQuery.list();
        transaction.commit();
        return entityList;
    }
*/


    public Session getSession() {
        return Factory.getSession();
    }

}
