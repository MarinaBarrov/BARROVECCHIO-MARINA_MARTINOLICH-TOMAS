package test;

import DAO.IDao;
import DAO.implementacion.OdontologoDAOList;
import Entidades.Odontologo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoDAOListTest {

    @Test
    public void testListarOdontologos() {
        Odontologo odontologo1 = new Odontologo("mat123", "Tomas", "Martinolich");
        Odontologo odontologo2 = new Odontologo("mat456", "Marina", "Barrovecchio");

        IDao<Odontologo> dbList = new OdontologoDAOList();

        List<Odontologo> odontologosList = dbList.listarTodos();

        dbList.guardar(odontologo1);
        dbList.guardar(odontologo2);

        assertEquals(2, odontologosList.size());
        assertTrue(odontologosList.contains(odontologo1));
        assertTrue(odontologosList.contains(odontologo2));
    }

}