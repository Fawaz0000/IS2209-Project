package DataAccess;

import java.util.ArrayList;
import java.util.List;

import BusinessLogic.Product;

public class ProductCsvDAO extends ProductDAO {
 
    public ProductCsvDAO(String filePath) {
        super( new InputOutput(filePath));
    }

    //here is where we wil be using the resultset object to populate our DAO


    @Override
    public Product saveAll(ArrayList<Product> items) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

    @Override
    public Product create(Product item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Product read(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public boolean update(Product item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Product> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

}