package DataAccess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BusinessLogic.User;

public class UserCsvDAO extends UserDAO {
 
    public UserCsvDAO(String filePath) {
        super( new InputOutput(filePath));
    }

    @Override
    public User create(User item) {
        CsvResultSet result = io.load();
        while (result.next()) {
            if (result.getString("email").equals(item.getEmail())) {
                return null;
            }
        }

        if (item.getRole() == null || item.getRole().isEmpty()) {
            item.setRole("user");
        }

        Map<String, Object> dict = new HashMap();
        dict.put("name", item.getName());
        dict.put("email", item.getEmail());
        dict.put("password", item.getPassword());
        dict.put("role", item.getRole());
        dict.put("shoeSize", item.getShoeSize().getSize());
        dict.put("shirtSize", item.getShirtSize().getSize());
        dict.put("pantSize", item.getPantSize().getSize());
        result.addRow(dict);
        io.save(result);
        return item;
    }

    @Override
    public User read(String email) {
       CsvResultSet res = io.load().where("email", email);
         if(res.next()){
              User user = new User();
              user.setName(res.getString("name"));
              user.setEmail(res.getString("email"));
              user.setPassword(res.getString("password"));
            user.setRole(res.getString("role"));

              user.setShoeSize(res.getString("shoeSize"));
              user.setShirtSize(res.getString("shirtSize"));
              user.setPantSize(res.getString("pantSize"));
              return user;
         }
            return null;
    }

    @Override
    public boolean update(User item) {
        CsvResultSet result = io.load();
        while (result.next()) {
            if (result.getString("email").equals(item.getEmail())) {
                result.updateString("name", item.getName());
                result.updateString("email", item.getEmail());
                result.updateString("password", item.getPassword());
                result.updateString("role", item.getRole());
                result.updateString("shoeSize", item.getShoeSize().getSize());
                result.updateString("shirtSize", item.getShirtSize().getSize());
                result.updateString("pantSize", item.getPantSize().getSize());
                io.save(result);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String email) {
        CsvResultSet result = io.load();
        while (result.next()) {
            if (result.getString("email").equals(email)) {
                result.deleteRow();
                io.save(result);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<User> getAll() {
        CsvResultSet result = io.load();
        List<User> users = new ArrayList();

        while (result.next()) {
            User user = new User();
            user.setName(result.getString("name"));
            user.setEmail(result.getString("email"));
            user.setPassword(result.getString("password"));
            user.setRole(result.getString("role"));
            user.setShoeSize(result.getString("shoeSize"));
            user.setShirtSize(result.getString("shirtSize"));
            user.setPantSize(result.getString("pantSize"));
            users.add(user);
        }
        return users;

    }

    @Override
    public User read(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public User saveAll(ArrayList<User> items) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }
    
}