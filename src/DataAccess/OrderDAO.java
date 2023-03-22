package DataAccess;

import java.sql.Connection;

import BusinessLogic.Order;

public abstract class OrderDAO extends DataAccess<Order>{
    public OrderDAO(InputOutput io) {
        super(io);
    }

    public OrderDAO(Connection conn) {
        super(conn);
    }
    //add all specific to orders here
}