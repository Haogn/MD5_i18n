package com.ra.model.repository;

import com.ra.model.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CategoryRepositoryIMPL implements CategoryRepository{
    @Autowired
    private SessionFactory sessionFactory ;

    @Override
    public List<Category> findAll() {
        List<Category> list = new ArrayList<>() ;
        Session session = sessionFactory.openSession() ;

        try {
            session.beginTransaction();
            list = session.createQuery("from Category").list() ;
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null ) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public Category findById(Integer id) {
        Session session = sessionFactory.openSession() ;
        Category category = new Category() ;
        try {
             session.beginTransaction() ;
            Query<Category> query = session.createQuery("from Category where id = :id") ;
            query.setParameter("id" , id) ;
            category = query.uniqueResult() ;
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return category;
    }

    @Override
    public Category saveOrUpdate(Category category) {
        Session session = sessionFactory.openSession();
        try {
             session.beginTransaction();

            Category existingCategory = session.get(Category.class, category.getId());

            if (existingCategory != null) {
                session.update(category);
            } else {
                session.save(category);
            }

            session.getTransaction().commit();

        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();

        } finally {
            session.close();
        }

        return category;
    }


    @Override
    public Boolean delete(Integer id) {
        Session session = sessionFactory.openSession();
        Boolean isDelete = false ;
        try {
             session.beginTransaction() ;
            Query<Category> query = session.createQuery("delete from Category where id = :id", Category.class) ;
            query.setParameter("id" , id) ;
            if (query.executeUpdate() > 0 ) {
                isDelete = true ;
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return isDelete;
    }
}
