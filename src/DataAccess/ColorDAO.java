package DataAccess;

import java.sql.Connection;
import java.util.List;

import BusinessLogic.Color;
import BusinessLogic.Product;

public abstract class ColorDAO extends DataAccess<Color>{
    public ColorDAO(InputOutput io) {
        super(io);
    }

    public ColorDAO(Connection conn) {
        super(conn);
    }

    public abstract List<Color> getProductColors(int prodId);
    public abstract List<Color> getProductColors(Product prod);
    //add all specific to colors here
}
