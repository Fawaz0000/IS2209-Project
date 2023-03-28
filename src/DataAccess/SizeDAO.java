package DataAccess;

import java.sql.Connection;
import java.util.List;

import BusinessLogic.Product;
import BusinessLogic.Size;

public abstract class SizeDAO extends DataAccess<Size>{
    public SizeDAO(InputOutput io) {
        super(io);
    }

    public SizeDAO(Connection conn) {
        super(conn);
    }

    public abstract List<Size> getProductSizes(int prodId);
    public abstract List<Size> getProductSizes(Product prod);
}

