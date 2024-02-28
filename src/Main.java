import DAO.IDao;
import DAO.implementacion.OdontologoDAOH2;
import DAO.implementacion.OdontologoDAOList;
import Entidades.Odontologo;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Odontologo odontologo1 = new Odontologo("mat123", "Tomas", "Martinolich");
        Odontologo odontologo2 = new Odontologo("mat456", "Marina", "Barrovecchio");

        IDao<Odontologo> dbH2 = new OdontologoDAOH2();
        IDao<Odontologo> dbList = new OdontologoDAOList();

        dbH2.guardar(odontologo1);
        dbH2.guardar(odontologo2);
        dbList.guardar(odontologo1);
        dbList.guardar(odontologo2);

        List<Odontologo> odontologosH2 = dbH2.listarTodos();

        List<Odontologo> odontologosList = dbList.listarTodos();

        System.out.println("Odontologos guardados en h2 son : " + odontologosH2);
        System.out.println("Odontologos guardados en List son : " + odontologosList);

    }
}