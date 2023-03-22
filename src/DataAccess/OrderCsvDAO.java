package DataAccess;

import java.util.ArrayList;
import java.util.List;

import BusinessLogic.Order;

public class OrderCsvDAO extends OrderDAO {
 
    public OrderCsvDAO(String filePath) {
        super( new InputOutput(filePath));
    }

    //here is where we wil be using the resultset object to populate our DAO


    @Override
    public Order saveAll(ArrayList<Order> items) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

    @Override
    public Order create(Order item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Order read(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public boolean update(Order item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Order> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

}