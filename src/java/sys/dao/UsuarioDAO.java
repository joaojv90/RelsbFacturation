package sys.dao;

import sys.model.Usuario;


public interface UsuarioDAO {
    
    public Usuario search(Usuario usuario); //metodo para buscar
    public Usuario login(Usuario usuario);
    
}
