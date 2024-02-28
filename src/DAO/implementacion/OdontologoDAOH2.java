package DAO.implementacion;

import DAO.BD;
import DAO.IDao;
import Entidades.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements IDao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDAOH2.class);

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        LOGGER.info("Estamos persistiendo un odontologo");

        Connection connection = null;

        try {

            connection = BD.getConnection();

            PreparedStatement pStmt = connection.prepareStatement("INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO)  " +
                    "VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pStmt.setString(1, odontologo.getNumMatricula());
            pStmt.setString(2, odontologo.getNombre());
            pStmt.setString(3, odontologo.getApellido());
            pStmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return odontologo;
    }


    @Override
    public List<Odontologo> listarTodos() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Odontologo> odontologos = new ArrayList<>();

        try {
            connection = BD.getConnection();

            preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGOS");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String matricula = resultSet.getString("matricula");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");

                Odontologo odontologo = new Odontologo();
                odontologo.setId(id);
                odontologo.setNumMatricula(matricula);
                odontologo.setNombre(nombre);
                odontologo.setApellido(apellido);

                odontologos.add(odontologo);
            }

            preparedStatement.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return odontologos;
    }
}

