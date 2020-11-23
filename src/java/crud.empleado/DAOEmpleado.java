package crud.empleado;

import crud.factory.IDAOGeneral;
import crud.utils.ConexionDB;
import crud.utils.HibernateUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author flor
 */
public class DAOEmpleado implements IDAOGeneral<Empleado> {
    private Session session;
    private ConexionDB con = ConexionDB.getInstance();
    //private List<Empleado> List;

    public DAOEmpleado() {
    }

    @Override
    public boolean guardar(Empleado pojo) {
        boolean res = false;
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(pojo);
            res = true;
            transaction.commit();
            System.out.print("Guardado");
        } catch (HibernateException e) {
            transaction.rollback();
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, e);
            System.out.print("No se pudo guardar");
        } finally{
            session.close();
        }
        return res;
    }

    @Override
    public boolean borrar(Empleado pojo) {
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
    public boolean actualizar(Empleado pojo) {
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
    public Empleado mostrarByID(Empleado pojo) {
        Empleado empleado = new Empleado();
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            empleado = (Empleado) session.createQuery("SELECT pojo FROM Empleado pojo WHERE id = " + pojo.getId()).uniqueResult();
        } catch (HibernateException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            session.close();
        }
        return empleado;
    }

    @Override
    public List<Empleado> mostrarTodos() {
        List<Empleado> List = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("SELECT em FROM Empleado em");
            List = query.list();
        } catch (HibernateException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            session.close();
        }
        return List;

    }

}
