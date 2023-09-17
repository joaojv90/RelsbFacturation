package sys.Impl;

import org.hibernate.Query;
import org.hibernate.Session;
import sys.componentes.EncriptarPassword;
import sys.dao.UsuarioDAO;
import sys.model.Usuario;
import sys.util.HibernateUtil;


public class UsuarioDAOImpl implements UsuarioDAO{

    @Override
    public Usuario search(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql="FROM Usuario WHERE nombreUsuario=:nombreUsuario"; //con hibernate se coloca simpre =: para comparación
        Query query = session.createQuery(hql);
        query.setParameter("nombreUsuario", usuario.getNombreUsuario()); //se coloca la misma variable que está después del =:
        return (Usuario) query.uniqueResult(); //castear-transformar el objeto Usuario, si no encuentra devuelve un null
    }

    @Override
    public Usuario login(Usuario usuario) {
        Usuario usuarioLogin = search(usuario);
        if(usuarioLogin != null){
            if(!usuarioLogin.getPassword().equals(EncriptarPassword.sha512(usuario.getPassword()))){ //encripta lo ingresado para comparar con la base
                usuarioLogin = null;
            }
        }
        return usuarioLogin;
    }
    
}
