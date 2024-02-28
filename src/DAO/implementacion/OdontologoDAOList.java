package DAO.implementacion;

import DAO.IDao;
import Entidades.Odontologo;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOList implements IDao<Odontologo> {

    private List<Odontologo> odontologos;

    public OdontologoDAOList() {
        this.odontologos = new ArrayList<>();
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologo.setId(this.odontologos.size() + 1);
        this.odontologos.add(odontologo);

        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {

        return this.odontologos;
    }
}
