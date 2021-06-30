package com.example.demo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class NhanHieuDAO {

    /**
     * Save Nhan Hieu
     * @param nhanHieu
     */
    public void saveNhanHieu(NhanHieu nhanHieu) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(nhanHieu);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Update NhanHieu
     * @param nhanHieu
     */
    public void updateNhanHieu(NhanHieu nhanHieu) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(nhanHieu);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Delete NhanHieu
     * @param id
     */
    public void deleteNhanHieu(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            NhanHieu nhanHieu = session.get(NhanHieu.class, id);
            if (nhanHieu != null) {
                session.delete(nhanHieu);
                System.out.println("user is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Get Nhan Hieu By ID
     * @param id
     * @return
     */
    public NhanHieu getNhanHieu(int id) {

        Transaction transaction = null;
        NhanHieu nhanHieu = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            nhanHieu = session.get(NhanHieu.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return nhanHieu;
    }

    /**
     * Get all NhanHieu
     * @return
     */
    @SuppressWarnings("unchecked")
    public List < NhanHieu > getAllNhanHieu() {

        Transaction transaction = null;
        List < NhanHieu > listOfNhanHieu = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listOfNhanHieu = session.createQuery("from NhanHieu ").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfNhanHieu;
    }
}
