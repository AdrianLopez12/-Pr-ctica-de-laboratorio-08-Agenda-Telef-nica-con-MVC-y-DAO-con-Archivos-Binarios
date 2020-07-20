package ec.edu.ups.dao;

import ec.edu.ups.modelo.Telefono;

import java.util.List;
import javax.swing.DefaultListModel;

public interface IDaoTelfono {
    
    public void create (Telefono telefono);
    public Telefono read(int id);
    public void update(String codigo,Telefono telefono);
    public void delete(String codigo);
    public List<String> findAll();
    public DefaultListModel buscarPorCedula(String cedula);
    public DefaultListModel misTelefonos(String cedula);
    public DefaultListModel listarTelefonos();
}
