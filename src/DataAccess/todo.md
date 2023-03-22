Sure! Here's an example implementation of the 5 components I mentioned earlier:

1. `IDataAccess`: This interface defines the common methods for accessing data.

```java
public interface IDataAccess<T> {
    T create(T item);
    T read(int id);
    boolean update(T item);
    boolean delete(int id);
    List<T> getAll();
}
```

2. `DataAccess`: This abstract class implements the `IDataAccess` interface and provides a base implementation for common data access methods.

```java
public abstract class DataAccess<T> implements IDataAccess<T> {
    protected Connection connection;

    public DataAccess(Connection connection) {
        this.connection = connection;
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
```

3. `UserDataAccess` and `ProductDataAccess`: These concrete classes extend the `DataAccess` abstract class and provide specific implementations for accessing user and product data respectively.

```java
public class UserDataAccess extends DataAccess<User> {
    
   // Constructor and implementation of abstract methods

}

public class ProductDataAccess extends DataAccess<Product> {

   // Constructor and implementation of abstract methods

}
```

4. Configuration file: You can use a configuration file to specify which data storage system to use and provide any necessary connection details. Here's an example configuration file in JSON format:

```json
{
  "dataStorageSystem": "mysql",
  "connectionDetails": {
      "host": "localhost",
      "port": 3306,
      "database": "ecommerce",
      "username": "root",
      "password": ""
  }
}
```

5. Strategy classes: For each data storage system you want to support, you can create a strategy class that implements the `IDataAccess` interface and provides the necessary code to interact with that specific data storage system. Here's an example strategy class for MySQL:

```java
public class MysqlUserDataAccess extends UserDataAccess {

   // Constructor and implementation of abstract methods

}
```

This is just one way to implement a DAL for an e-commerce site with users and products. You can adapt this example to fit your specific needs.