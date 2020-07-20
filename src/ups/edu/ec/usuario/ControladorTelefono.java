package ups.edu.ec.usuario;

import ec.edu.ups.dao.IDaoTelfono;
import ec.edu.ups.dao.TelefonDao;
import ec.edu.ups.dao.UsuarioDao;
import ec.edu.ups.modelo.Telefono;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import ups.edu.ec.usuario.ControladorUsuario;

public class ControladorTelefono {
    private IDaoTelfono telefonoDao;
    
    private Telefono telefono;

    private ControladorUsuario controladorUsuario;
    public ControladorTelefono(IDaoTelfono telefonoDao, ControladorUsuario controladorUsuario) {
        this.telefonoDao = telefonoDao;
        this.controladorUsuario=controladorUsuario;
    }
    
    
    public void registrar(String codigo, String numero, String tipo, String operadora){
        
        this.telefono=new Telefono(codigo, numero, tipo, operadora,controladorUsuario.devolvercedula());
        telefonoDao.create(telefono);
        
    }
    
    public void verUsuario(){
        
    }
    
    public void actualizar(){
        
    }
    public DefaultListModel ListarTelefonos(){
        DefaultListModel modelo=telefonoDao.listarTelefonos();
        
        return modelo;
    }
    
    public boolean eliminar(String codigo){
        List<String> lista=telefonoDao.findAll();
        for (int i = 0; i <lista.size() ; i++) {
            if(lista.get(i).equalsIgnoreCase(codigo)){
                telefonoDao.delete(codigo);
                return true;
            }
        }
          
         return false; 
        
        
    }
    
    public void verClientes(){
        
    }
    public DefaultListModel modelo(String cedula){
        DefaultListModel model=telefonoDao.buscarPorCedula(cedula);
        return model;
        
    }
    public boolean actualizarTelefono(String codigo, String nombre, String tipo, String operadora){
          List<String> lista=telefonoDao.findAll();
        
          for (int i = 0; i <lista.size() ; i++) {
           
          if(lista.get(i).equalsIgnoreCase(codigo)){
              Telefono telf=new Telefono(codigo, nombre, tipo, operadora, controladorUsuario.devolvercedula());
              telefonoDao.update(codigo, telf);
              return true;
          }
          
          }
        
        return false;
    }
public   DefaultListModel misTelefonos(){
    System.out.println(controladorUsuario.devolvercedula().trim());
   DefaultListModel model=telefonoDao.buscarPorCedula(controladorUsuario.devolvercedula().trim());
        return model;
}  
    
    
    
}
