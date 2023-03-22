package DataAccess;

import java.util.ArrayList;
import java.util.List;

import BusinessLogic.Color;

public class ColorCsvDAO extends ColorDAO {
 
    public ColorCsvDAO(String filePath) {
        super( new InputOutput(filePath));
    }

    //here is where we wil be using the resultset object to populate our DAO


    @Override
    public Color saveAll(ArrayList<Color> items) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

    @Override
    public Color create(Color item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Color read(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public boolean update(Color item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Color> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

}
