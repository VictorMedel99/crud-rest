package crud.departamento;

import crud.empleado.DAOEmpleado;
import crud.factory.IDAOGeneral;
import crud.utils.ConexionDB;
import crud.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DAODepartamento implements IDAOGeneral<Departamento> {
    private Session session;
    private List<Departamento> List;

    @Override
    public boolean guardar(Departamento pojo) {
        boolean res = false;
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {    
            session.save(pojo);
            res = true;
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            session.close();
        }
        return res;

    }

    @Override
    public boolean borrar(Departamento pojo) {
        boolean res = false;
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(pojo);
            res = true;
            transaction.commit();
            
        } catch (HibernateException e) {
            transaction.rollback();
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            session.close();
        }

        return res;

    }

    @Override
    public boolean actualizar(Departamento pojo) {
        boolean res = false;
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(pojo);
            res = true;
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            session.close();
        }
        return res;

    }

    @Override
    public Departamento mostrarByID(Departamento pojo) {
        Departamento dep = new Departamento();
        session = HibernateUtil.getSessionFactory().openSession();
        try {
             dep = (Departamento) session.createQuery("SELECT dep FROM Departamento dep WHERE id = " + pojo.getId() ).uniqueResult();
        } catch (HibernateException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            session.close();
        }
        return dep;

    }

    @Override
    public List<Departamento> mostrarTodos() {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("SELECT dep FROM Departamento dep");
            List = query.list();
        } catch (HibernateException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            session.close();
        }
        return List;

    }

}
