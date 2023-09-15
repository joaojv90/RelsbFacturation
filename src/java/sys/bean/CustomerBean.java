package sys.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.ViewScoped; // -> Cambiar javax.faces.view.ViewScoped
import sys.Impl.CustomerDAOImpl;
import sys.dao.CustomerDAO;
import sys.model.Cliente;

@ManagedBean //Esta anotación indica que va esta clase va a trabajar como Controlador
@Named(value = "customerBean")
@ViewScoped //Limpia la memoria al salir de la pag
public class CustomerBean {

    private Cliente cliente=null;
    private List<Cliente> clientes = null;
    
    public CustomerBean() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        CustomerDAO datos = new CustomerDAOImpl();
        this.clientes = datos.select();
        return clientes;
    }

    public void prepareCliente(){
        this.cliente = new Cliente(); //constructor vacío que prepara el objeto para recibir los datos
    }
    
    public void insertCliente(){
        CustomerDAO datos = new CustomerDAOImpl();
        datos.insert(cliente);
    }
    
    public void updateCliente(){
        CustomerDAO datos = new CustomerDAOImpl();
        datos.update(cliente);
        this.cliente=new Cliente(); 
    }
    
    public void deleteteCliente(){
        CustomerDAO datos = new CustomerDAOImpl();
        datos.delete(cliente);
        this.cliente=new Cliente(); //regresa a un estado por defoult para liberar memoria y que este preparado para una siguiente acción
    }
    
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    
    
}
