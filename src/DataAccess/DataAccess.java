package DataAccess;

import java.sql.Connection;
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

    @Override
    public abstract T create(T item);

    @Override
    public abstract T read(int id);

    @Override
    public abstract boolean update(T item);

    @Override
    public abstract boolean delete(int id);

    @Override
    public abstract List<T> getAll();
}