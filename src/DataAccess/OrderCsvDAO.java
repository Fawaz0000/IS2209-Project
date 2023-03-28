package DataAccess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BusinessLogic.Color;
import BusinessLogic.Order;
import BusinessLogic.Size;

public class OrderCsvDAO extends OrderDAO {
 
    public OrderCsvDAO(String filePath) {
        super( new InputOutput(filePath));
    }

    @Override
    public Order create(Order item) {
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
        dict.put("date", item.getDate());
        dict.put("userEmail", item.getUser().getEmail());
        dict.put("prodId", item.getProduct().getId());
        dict.put("quantity", item.getQuantity());
        dict.put("price", item.getPrice());
        dict.put("color", item.getColor().getColor());
        dict.put("size", item.getSize().getSize());
        result.addRow(dict);
        io.save(result);
        return item;
    }

    @Override
    public Order read(int id) {
        CsvResultSet result = io.load().where("id", id);
        if (result.next()) {
            Order order = new Order();
            order.setId(result.getInt("id"));
            order.setDate(result.getTimestamp("date"));
            order.setUser(getInstance().getUserDao().read(result.getString("userEmail")));
            order.setProduct(getInstance().getProductDao().read(result.getString("prodId")));

            order.setQuantity(result.getInt("quantity"));
            order.setPrice(result.getDouble("price"));

            order.setColor(new Color(result.getString("color")));
            order.setSize(new Size(result.getString("size")));
            return order;
        }
        return null;
    }

    @Override
    public boolean update(Order item) {
        CsvResultSet result = io.load();
        while (result.next()) {
            if (result.getInt("id") == item.getId()) {
                result.updateInt("id", item.getId());
                result.updateTimestamp("date", item.getDate());
                result.updateString("userEmail", item.getUser().getEmail());
                result.updateInt("prodId", item.getProduct().getId());
                result.updateInt("quantity", item.getQuantity());
                result.updateDouble("price", item.getPrice());
                result.updateString("color", item.getColor().getColor());
                result.updateString("size", item.getSize().getSize());
                io.save(result);
                return true;
            }
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
    public List<Order> getAll() {
        ArrayList<Order> orders = new ArrayList();
        CsvResultSet result = io.load();
        while (result.next()) {
            Order order = new Order();
            order.setId(result.getInt("id"));
            order.setDate(result.getTimestamp("date"));
            order.setUser(getInstance().getUserDao().read(result.getString("userEmail")));
            order.setProduct(getInstance().getProductDao().read(result.getString("prodId")));

            order.setQuantity(result.getInt("quantity"));
            order.setPrice(result.getDouble("price"));

            order.setColor(new Color(result.getString("color")));
            order.setSize(new Size(result.getString("size")));
            orders.add(order);
        }
        return orders;
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
    public Order read(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Order saveAll(ArrayList<Order> items) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

}