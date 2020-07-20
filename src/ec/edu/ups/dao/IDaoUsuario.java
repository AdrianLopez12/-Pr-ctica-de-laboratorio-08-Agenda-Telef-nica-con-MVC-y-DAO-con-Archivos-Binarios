package ec.edu.ups.dao;

import ec.edu.ups.modelo.Usuario;
import java.util.List;

public interface IDaoUsuario {
    public void create (Usuario usuario);
    public Usuario read(String cedula);
    public void update(Usuario usuario);
    public void delete(Usuario usuario);
    public List<Usuario> findAll();
    public Usuario login(String correo, String contrasena);
}
