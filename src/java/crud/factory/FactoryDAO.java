package crud.factory;

import javax.swing.JOptionPane;
import crud.departamento.DAODepartamento;
import crud.empleado.DAOEmpleado;
/**
 *
 * @author alberto
 */
    public class FactoryDAO {
    public enum TypeDAO{EMPLEADO,DEPARTAMENTO,USUARIO};
    public static IDAOGeneral create(TypeDAO tipo){
        IDAOGeneral dao=null;
        switch(tipo){
            case EMPLEADO:
                dao=new DAOEmpleado();
                break;
            case DEPARTAMENTO:
                dao=new DAODepartamento();
                break;
            default:
                JOptionPane.showMessageDialog(null,"Error Factory");
        }
        return dao;
    }
    
}
