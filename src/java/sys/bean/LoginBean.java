package sys.bean;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.PrimeFaces;
import sys.Impl.UsuarioDAOImpl;
import sys.dao.UsuarioDAO;
import sys.model.Usuario;

@ManagedBean
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable{

    private Usuario usuario; //creamos el objeto que se va a manipular en la vista y que mantiene la información
    private String nombreUsuario;
    private String password;
    
    public LoginBean() {
        this.usuario=new Usuario();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
       
    public void login() {
        FacesMessage message = null; //FacesMessages es como joptionpanel
        boolean loggedIn = false;
        String ruta="";
        
        //instanciamos la clase a partir de la interfas
        UsuarioDAO datos = new UsuarioDAOImpl();
        this.usuario = datos.login(usuario);
         
        if(this.usuario != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario",this.usuario.getNombreUsuario());
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getNombreUsuario());
            ruta="/RelsbFacturation/faces/Views/Home.xhtml";
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de Acceso", "Usuario y/o password incorrecta/s");
            usuario=new Usuario();
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn); //addCallbackParam permite enviar parametros a la vista para evaluar
        PrimeFaces.current().ajax().addCallbackParam("ruta", ruta);
    }
    
    public String logout(){
        this.nombreUsuario = null;
        this.password = null;
        HttpSession httpsession = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false); //casteamos la session
        httpsession.invalidate(); //borramos la session
        return "/Login";
    }
    
}
