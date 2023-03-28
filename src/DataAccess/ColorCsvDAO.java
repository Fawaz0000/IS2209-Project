package DataAccess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BusinessLogic.Color;
import BusinessLogic.Product;

public class ColorCsvDAO extends ColorDAO {
 
    public ColorCsvDAO(String filePath) {
        super( new InputOutput(filePath));
    }

    @Override
    public List<Color> getAll() {
        ArrayList<Color> colors = new ArrayList();
        CsvResultSet result = io.load(); //
        while(result.next()){
            Color color = new Color();
            color.setColor(result.getString("color"));
            color.setProdId(result.getInt("prodId"));
            color.setColorHex(result.getString("colorHex"));
            colors.add(color);
        }
        return colors;
    }

    public List<Color> getProductColors(int prodId) {
        ArrayList<Color> colors = new ArrayList();
        CsvResultSet result = io.load().where("prodId", prodId);
        while(result.next()){
            Color color = new Color();
            color.setColor(result.getString("color"));
            color.setProdId(result.getInt("prodId"));
            color.setColorHex(result.getString("colorHex"));
            colors.add(color);
        }
        return colors;
    }

    public List<Color> getProductColors(Product prod) {
        return getProductColors(prod.getId());
    }

    @Override
    public Color create(Color item) {
        CsvResultSet result = io.load();
        Map<String, Object> dict = new HashMap();

        dict.put("color", item.getColor());
        dict.put("prodId", item.getProdId());
        dict.put("colorHex", item.getColorHex());
        result.addRow(dict);
        io.save(result);
        return item;
    }


    @Override
    public Color read(String id) {
        CsvResultSet results = io.load().where("color", id);
        if (results.next()) {
            Color color = new Color();
            color.setColor(results.getString("color"));
            color.setProdId(results.getInt("prodId"));
            color.setColorHex(results.getString("colorHex"));
            return color;
        }
        return null;
    }

    @Override
    public boolean update(Color item) {
        // TODO Auto-generated method stub
        //depends on how we want to update, if we want to change the prod id or the hex code
        //no unique id for color
        // let's say we want to change the hex code
        boolean updated = false;
        CsvResultSet result = io.load();
        while (result.next()) {
            if (result.getString("color").equals(item.getColor())) {
                result.updateString("colorHex", item.getColorHex());
                io.save(result);
                updated = true;
            }
        }
        return updated;
    }

    @Override
    public Color read(int id) {
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
    public Color saveAll(ArrayList<Color> items) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

}
