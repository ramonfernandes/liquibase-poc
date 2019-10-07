package com.ramonfernandes.javaeepoc.rest.dao;

import com.ramonfernandes.javaeepoc.rest.dto.Book;

import javax.persistence.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;

public class DAO {

    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public Collection<Book> get() throws SQLException {
        stabblishConnection();

        Query query = entityManager.createQuery("SELECT x FROM Book x");
        Collection<Book> books = (Collection<Book>) query.getResultList();

        closesConnection(entityManager, factory);

        return books;
    }

    public void delete(int id) throws SQLException {
        stabblishConnection();

        Book book = entityManager.find(Book.class, id);

        entityManager.getTransaction().begin();
        entityManager.remove(book);
        entityManager.getTransaction().commit();

        closesConnection(entityManager, factory);

    }

    public void update(int id, Book book) throws SQLException {

        stabblishConnection();

        Book newBook = entityManager.find(Book.class, id);

        entityManager.getTransaction().begin();
        newBook.setName(book.getName());
        entityManager.getTransaction().commit();

        closesConnection(entityManager, factory);
    }

    public void create(Book book) throws SQLException {
        stabblishConnection();

        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();

        closesConnection(entityManager, factory);
    }

    private void stabblishConnection() {
        factory = Persistence.createEntityManagerFactory("Library");
        entityManager = factory.createEntityManager();
    }


    private void closesConnection(EntityManager entityManager, EntityManagerFactory factory) {
        entityManager.close();
        factory.close();
    }

}
