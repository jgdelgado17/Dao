package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Conexion.Conexion;
import interfaces.DaoPersona;
import model.Persona;

public class PersonaImpl extends Conexion implements DaoPersona {

    @Override
    public void registar(Persona persona) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.connection.prepareStatement("INSERT INTO persona (nombre) VALUES (?)");
            st.setString(1, persona.getNombre());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public void actualizar(Persona persona) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.connection.prepareStatement("UPDATE persona SET nombre = ? WHERE id = ?");
            st.setString(1, persona.getNombre());
            st.setInt(2, persona.getId());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public void eliminar(Persona persona) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.connection.prepareStatement("DELETE FROM persona WHERE id = ?");
            st.setInt(1, persona.getId());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public List<Persona> listarTodo() throws Exception {
        List<Persona> listPersonas = null;
        try {
            this.conectar();
            PreparedStatement st = this.connection.prepareStatement("SELECT * FROM persona");
            ResultSet rs = st.executeQuery();

            listPersonas = new ArrayList<>();
            while (rs.next()) {
                Persona persona = new Persona();
                persona.setId(rs.getInt("id"));
                persona.setNombre(rs.getString("nombre"));
                listPersonas.add(persona);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrarConexion();
        }
        return listPersonas;
    }

    @Override
    public Persona buscarPorId(Integer id) throws Exception {
        Persona persona = null;
        try {
            this.conectar();
            PreparedStatement st = this.connection.prepareStatement("SELECT * FROM persona WHERE id = ?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                persona = new Persona();
                persona.setId(rs.getInt("id"));
                persona.setNombre(rs.getString("nombre"));
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrarConexion();
        }
        return persona;
    }
}
