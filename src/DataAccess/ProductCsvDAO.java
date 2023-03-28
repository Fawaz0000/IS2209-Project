package DataAccess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import BusinessLogic.Product;
import static DataAccess.DataStore.getInstance;

public class ProductCsvDAO extends ProductDAO {

    public ProductCsvDAO(String filePath) {
        super(new InputOutput(filePath));
    }

    @Override
    public Product create(Product item) {

        CsvResultSet result = io.load();
        while (result.next()) {
            if (result.getInt("id") == item.getId()) {
                return null;
            }
        }
        Map<String, Object> dict = new HashMap();
        
        if (item.getId() == 0) {
            item.setId(generateId());
        }
        
        dict.put("id", item.getId());
        dict.put("name", item.getName());
        dict.put("description", item.getDescription());
        dict.put("price", item.getPrice());

        result.addRow(dict);
        io.save(result);
        return item;

    }

    @Override
    public Product read(int id) {
        CsvResultSet result = io.load().where("id", id);
        if (result.next()) {
            Product product = new Product();
            product.setId(result.getInt("id"));
            product.setName(result.getString("name"));
            product.setDescription(result.getString("description"));
            product.setPrice(result.getDouble("price"));
            
            product.setColors(getInstance().getColorDao().getProductColors(id));
            product.setSizes(getInstance().getSizeDao().getProductSizes(id));
            
            return product;
        }
        return null;
        
    }

    @Override
    public boolean update(Product item) {
        CsvResultSet result = io.load().where("id", item.getId());
        if (result.next()) {
            result.updateString("name", item.getName());
            result.updateString("description", item.getDescription());
            result.updateDouble("price", item.getPrice());
            
            io.save(result);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        CsvResultSet result = io.load();
        while (result.next()) {
            if (result.getInt("id") == id) {
                result.deleteRow();
                io.save(result);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Product> getAll() {
        CsvResultSet result = io.load();
        List<Product> products = new ArrayList();
        while (result.next()) {
            Product product = new Product();
            product.setId(result.getInt("id"));
            product.setName(result.getString("name"));
            product.setDescription(result.getString("description"));
            product.setPrice(result.getDouble("price"));
            
            product.setColors(getInstance().getColorDao().getProductColors(product.getId()));
            product.setSizes(getInstance().getSizeDao().getProductSizes(product.getId()));
            
            products.add(product);
        }
        return products;
    }

    public int generateId() {
        CsvResultSet result = io.load();
        int id = 0;
        while (result.next()) {
            if (result.getInt("id") > id) {
                id = result.getInt("id");
            }
        }
        return id + 1;
    }

    @Override
    public Product read(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Product saveAll(ArrayList<Product> items) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }
}
