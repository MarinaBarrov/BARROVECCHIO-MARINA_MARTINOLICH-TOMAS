package DAO.implementacion;

import DAO.IDao;
import Entidades.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOList implements IDao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDAOH2.class);

    private List<Odontologo> odontologos;


    public OdontologoDAOList() {
        this.odontologos = new ArrayList<>();
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        LOGGER.info("Estamos persistiendo un odontologo");
        odontologo.setId(this.odontologos.size() + 1);
        this.odontologos.add(odontologo);

        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        LOGGER.info("Estamos listando todos los odontologos");
        return this.odontologos;
    }
}
