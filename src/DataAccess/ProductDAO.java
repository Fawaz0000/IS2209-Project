package DataAccess;

import java.sql.Connection;

import BusinessLogic.Product;

public abstract class ProductDAO extends DataAccess<Product>{
    public ProductDAO(InputOutput io) {
        super(io);
    }

    public ProductDAO(Connection conn) {
        super(conn);
    }
    //add all specific to products here
}
