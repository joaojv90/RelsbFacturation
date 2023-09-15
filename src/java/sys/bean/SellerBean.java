package sys.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.ViewScoped; 
import sys.Impl.SellerDAOImpl;
import sys.dao.SellerDAO;
import sys.model.Vendedor;

@ManagedBean
@Named(value = "sellerBean")
@ViewScoped 
public class SellerBean {
    
    private Vendedor vendedor=null;
    private List<Vendedor> vendedores = null;
    
    public SellerBean(){
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<Vendedor> getVendedores() {
        SellerDAO datos = new SellerDAOImpl();
        this.vendedores = datos.select();
        return vendedores;
    }
    
    public void prepareVendedor(){
        this.vendedor = new Vendedor();
    }
    
    public void insertVendedor(){
        SellerDAO datos = new SellerDAOImpl();
        datos.insert(vendedor);
    }
    
    public void updateVendedor(){
        SellerDAO datos = new SellerDAOImpl();
        datos.update(vendedor);
        this.vendedor=new Vendedor(); 
    }
    
    public void deleteteVendedor(){
        SellerDAO datos = new SellerDAOImpl();
        datos.delete(vendedor);
        this.vendedor=new Vendedor(); //regresa a un estado por defoult para liberar memoria y que este preparado para una siguiente acción
    }

    public void setVendedores(List<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }
    
    
    
}
