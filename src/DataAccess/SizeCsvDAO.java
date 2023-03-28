package DataAccess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BusinessLogic.Product;
import BusinessLogic.Size;

public class SizeCsvDAO extends SizeDAO {

    
    public SizeCsvDAO(String filePath) {
        super( new InputOutput(filePath));
    }

    @Override
    public List<Size> getAll() {
        CsvResultSet result = io.load();
        ArrayList<Size> sizes = new ArrayList();
        while(result.next()){
            Size size = new Size();
            size.setSize(result.getString("size"));
            size.setProdId(result.getInt("prodId"));
            sizes.add(size);
        }
        return sizes;
    }

    public List<Size> getProductSizes(int prodId) {
        CsvResultSet result = io.load().where("prodId", prodId);
        ArrayList<Size> sizes = new ArrayList();
        while(result.next()){
            Size size = new Size();
            size.setSize(result.getString("size"));
            size.setProdId(result.getInt("prodId"));
            sizes.add(size);
        }
        return sizes;
    }

    public List<Size> getProductSizes(Product prod) {
        return getProductSizes(prod.getId());
    }

    @Override
    public Size create(Size item) {
        CsvResultSet result = io.load();
        Map<String, Object> dict = new HashMap();

        dict.put("size", item.getSize());
        dict.put("prodId", item.getProdId());
        result.addRow(dict);
        io.save(result);
        return item;
    }

   
    @Override
    public Size read(String id) {
        CsvResultSet result = io.load().where("size", id);
        
        if(result.next()){
            Size size = new Size();
            size.setSize(result.getString("size"));
            size.setProdId(result.getInt("prodId"));
            return size;
        }
        return null;
    }

    @Override
    public boolean update(Size item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
    @Override
    public Size read(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Size saveAll(ArrayList<Size> items) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

    

}
