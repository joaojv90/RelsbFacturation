package sys.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import sys.Impl.ProductDAOImpl;
import sys.dao.ProductDAO;
import sys.model.Producto;

@ManagedBean
@Named(value = "productBean")
@ViewScoped 
public class ProductBean {
    
    private Producto producto=null;
    private List<Producto> productos = null;
    
    public ProductBean(){
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getProductos() {
        ProductDAO datos = new ProductDAOImpl();
        this.productos = datos.select();
        return productos;
    }
    
    public void prepareProducto(){
        this.producto = new Producto();
    }
    
    public void insertProducto(){
        ProductDAO datos = new ProductDAOImpl();
        datos.insert(producto);
    }
    
    public void updateProducto(){
        ProductDAO datos = new ProductDAOImpl();
        datos.update(producto);
        this.producto=new Producto(); 
    }
    
    public void deleteteProducto(){
        ProductDAO datos = new ProductDAOImpl();
        datos.delete(producto);
        this.producto=new Producto();
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }    
}
