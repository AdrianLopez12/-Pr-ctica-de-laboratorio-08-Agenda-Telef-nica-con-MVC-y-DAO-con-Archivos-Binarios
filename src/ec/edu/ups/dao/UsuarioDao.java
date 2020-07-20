package ec.edu.ups.dao;

import java.util.List;
import ec.edu.ups.modelo.Usuario;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;

public class UsuarioDao implements IDaoUsuario{
    private RandomAccessFile archivo;
    
   
    
    
    public UsuarioDao(){
        
        try{
          archivo=new RandomAccessFile("datos/usuarios.dat","rw");  
        }catch(IOException e){
            System.out.println("Error de lectura y escritura");
            e.printStackTrace();
        }
        
    }

    @Override
    public void create(Usuario usuario) {
        
        try{
    archivo.seek(archivo.length());
            
    archivo.writeUTF(usuario.getCedula());
    archivo.writeUTF(usuario.getNombre());
    archivo.writeUTF(usuario.getApellido());
    archivo.writeUTF(usuario.getCorreo());
            
    archivo.writeUTF(usuario.getContrasena());
        }catch(IOException e){
            System.out.println("Error de lectura y escritura");
            e.printStackTrace();;
        }
    
    }

    @Override
    public Usuario read(String cedula) {
       
        return null;
    }

    @Override
    public void update(Usuario usuario) {
      
    
    
    }

    @Override
    public void delete(Usuario usuario) {
      
    }
    
    
    
    @Override
    public Usuario login (String correo, String contrasena){
       try{
           int salto=66;
         
          
           while(salto<archivo.length()){
                archivo.seek(salto);
       String correoArchivo = archivo.readUTF();
       String contrasenaArchivo=archivo.readUTF();
               
       if(correo.equals(correoArchivo.trim())&&contrasena.equals(contrasenaArchivo.trim())){
          salto=salto-66;
          archivo.seek(salto);
           String cedulaArchivo = archivo.readUTF();
           System.out.println(cedulaArchivo);
           String nombreArchivo = archivo.readUTF();
           String apellidoArchivo = archivo.readUTF();
        
           Usuario usu=new Usuario(cedulaArchivo, nombreArchivo, apellidoArchivo, correo, contrasena);
           return usu;
          
       }
       salto=salto+128;
           }
       
       }catch(IOException e){
           System.out.println("Error login");
           e.printStackTrace();
       }
        
        return null;
    }

   
    public List<Usuario> findAll() {
return null;      

    }
    
    
}
