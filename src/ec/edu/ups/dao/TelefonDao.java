package ec.edu.ups.dao;

import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
import ups.edu.ec.usuario.ControladorUsuario;

public class TelefonDao implements IDaoTelfono {
    
    private RandomAccessFile archivo;
    ControladorUsuario controladorUsuario;
    
    public TelefonDao() {
        try {
            archivo = new RandomAccessFile("datos/telefonos.dat", "rw");            
        } catch (IOException e) {
            System.out.println("Error de lectura y escritura");
            e.printStackTrace();
        }
    }
    
    @Override
    public void create(Telefono telefono) {
        
        try {
            archivo.seek(archivo.length());
            
            archivo.writeUTF(telefono.getCodigo());
            archivo.writeUTF(telefono.getNumero());
            archivo.writeUTF(telefono.getTipo());
            archivo.writeUTF(telefono.getOperadora());
            archivo.writeUTF(telefono.getCedula());            
            
        } catch (IOException e) {
            System.out.println("Error de lectura y escritura");
            e.printStackTrace();;
        }
        
    }
    
    @Override
    public Telefono read(int codigo) {
        
        return null;
    }
    
    @Override
    public void update(String codigo, Telefono telefono) {
        
        try {
            long salto = 0;
            int registro = 82;
            while (salto < archivo.length()) {
                archivo.seek(salto);
                
                String codigoArchivo = archivo.readUTF();
                archivo.seek(archivo.getFilePointer() - 4);
                
                if (codigo.equals(codigoArchivo.trim())) {
                    
                    salto = archivo.length() + 1;
                    
                    archivo.writeUTF(telefono.getCodigo());
                    
                    archivo.writeUTF(telefono.getNumero());
                    
                    archivo.writeUTF(telefono.getTipo());
                    
                    archivo.writeUTF(telefono.getOperadora());
                    
                    archivo.writeUTF(telefono.getCedula());                    
                    
                }
                salto = salto + 82;
            }
        } catch (IOException e) {
            System.out.println("Error login");
            e.printStackTrace();
        }
        
    }
    
    @Override
    public void delete(String codigo) {
        
        try {
            long salto = 0;
            int registro = 82;
            while (salto < archivo.length()) {
                archivo.seek(salto);
                
                String codigoArchivo = archivo.readUTF();
                archivo.seek(archivo.getFilePointer() - 4);
                
                if (codigo.equals(codigoArchivo.trim())) {
                    
                   
                  
                    archivo.writeUTF("  ");
                    archivo.writeUTF("          ");
                    archivo.writeUTF("                    ");                 
                    archivo.writeUTF("                              ");  
                    archivo.writeUTF("          "); 
                    salto=archivo.length()+1;
                    
                }
                salto = salto + 82;
            }
        } catch (IOException e) {
            System.out.println("Error login");
            e.printStackTrace();
        }
        
        
        
        
        
        
        
        
        
    }
    
    @Override
    public List<String> findAll() {
        List<String> Lista = new ArrayList<String>();
        
        try {
            int salto = 0;
            while (salto < archivo.length()) {
                archivo.seek(salto);
                String codigo = archivo.readUTF();
                
                Lista.add(codigo.trim());
                
               
                salto = salto + 82;
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Lista;
        
    }

    @Override
    public DefaultListModel buscarPorCedula(String cedula) {
        DefaultListModel modelo = new DefaultListModel<>();
        try {
            int salto = 70;
            
            
            while (salto < archivo.length()) {
                
                archivo.seek(salto);
               
                String cedulaArchivo = archivo.readUTF();
                if (cedula.equals(cedulaArchivo.trim())) {
                    salto = salto - 70;
                    archivo.seek(salto);
                    String codigo = archivo.readUTF();
                    String numero = archivo.readUTF();
                    String tipo = archivo.readUTF();
                    String operadora = archivo.readUTF();
                    salto=salto+70;
                    Telefono telf = new Telefono(codigo.trim(), numero.trim(), tipo.trim(), operadora.trim(), cedulaArchivo.trim());
                    modelo.addElement(telf);
                }
                salto = salto + 82;
            }
            return modelo;
        } catch (IOException e) {
            System.out.println("Error login");
            e.printStackTrace();
        }
        
        return null;
        
    }
    @Override
    public DefaultListModel misTelefonos(String cedula){
        
        return null;
        
    }
    @Override
    public DefaultListModel listarTelefonos(){
        DefaultListModel modelo = new DefaultListModel<>();
        
        try {
        int salto = 0;
        while (salto < archivo.length()) {
            archivo.seek(salto);
            
                    String codigo = archivo.readUTF();
                    String numero = archivo.readUTF();
                    String tipo = archivo.readUTF();
                    String operadora = archivo.readUTF();
                    String cedulaArchivo = archivo.readUTF();
                    
                    Telefono telf=new Telefono(codigo, numero, tipo, operadora, cedulaArchivo);
                    if(codigo.trim().equalsIgnoreCase("")){
                        
                    }else{
                       modelo.addElement(telf); 
                    }
                    
                    salto=salto+82;
                    
        }
        return modelo;
        } catch (IOException e) {
            System.out.println("Error login");
            e.printStackTrace();
        }
        
        
        return null;
    }
}
