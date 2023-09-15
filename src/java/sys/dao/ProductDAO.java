package sys.dao;

import java.util.List;
import sys.model.Producto;

public interface ProductDAO {
    
    public List<Producto> select();    
    public void insert(Producto producto);
    public void update(Producto producto);
    public void delete(Producto producto);
    
}
