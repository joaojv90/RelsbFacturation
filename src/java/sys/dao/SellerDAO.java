package sys.dao;

import java.util.List;
import sys.model.Vendedor;

public interface SellerDAO {
    
    public List<Vendedor> select();
    public void insert(Vendedor vendedor);
    public void update(Vendedor vendedor);
    public void delete(Vendedor vendedor);
    
}
