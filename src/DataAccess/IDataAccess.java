package DataAccess;

import java.util.ArrayList;
import java.util.List;

public interface IDataAccess<T> {
    T create(T item);
    T read(int id);
    T read(String id);

    boolean update(T item);
    boolean delete(int id);
    boolean delete(String id);

    
    List<T> getAll();
    T saveAll(ArrayList<T> items);
}