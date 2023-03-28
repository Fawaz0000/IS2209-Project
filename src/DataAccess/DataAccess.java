package DataAccess;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public abstract class DataAccess<T> implements IDataAccess<T> {
    protected Connection connection;
    protected InputOutput io;

    public DataAccess(Connection connection) {
        this.connection = connection;
    }

    public DataAccess(InputOutput io) {
        this.io = io;
    }

}