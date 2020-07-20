package ups.edu.ec.usuario;
import ec.edu.ups.dao.*;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
public class ControladorUsuario {
    private IDaoTelfono telefonoDao;
    private IDaoUsuario usuarioDao;
    
    private Telefono telefono;
    public Usuario usuario;
    
    public ControladorUsuario(UsuarioDao usuariodao, TelefonDao telefonodao){
        this.usuarioDao=usuariodao;
        this.telefonoDao=telefonodao;
        
        
    }
    public void registrar(String cedula, String nombre,String apellido, String correo, String contrasena){
        
        this.usuario=new Usuario(cedula, nombre, apellido, correo, contrasena);
        usuarioDao.create(usuario);
      
    }
    public String devolvercedula(){
        return usuario.getCedula();
    }
    
    public void verUsuario(){
        
    }
    
    public void actualizar(){
        
    }
    
    public void eliminar(){
        
    }
    
    public void verClientes(){
        
    }
    public void cerrarSesion(){
        this.usuario=null;
    }
    
    public void agregarTelefono(int codigo){
       
        
    }
    public boolean validarUsuario(String correo, String contrasena){
       
        usuario=usuarioDao.login(correo, contrasena);
        if(usuario!=null){
            return true;
        }else{
            return false;
        }
        
        
    }
    
}
