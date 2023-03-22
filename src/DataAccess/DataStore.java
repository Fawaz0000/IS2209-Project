package DataAccess;

public class DataStore {
    private static DataStore instance;
    private UserDAO userDAO;
    private ProductDAO productDAO;
    private OrderDAO orderDAO;
    private ColorDAO colorDAO;
    
    private DataStore(){
        // Initialize DAOs here
        userDAO = new UserCsvDAO("users.csv");
        productDAO = new ProductCsvDAO("products.csv");
        orderDAO = new OrderCsvDAO("orders.csv");
        colorDAO = new ColorCsvDAO("colors.csv");
    }

    public static DataStore getInstance() {
        if (instance == null) {
            instance = new DataStore();
        }
        return instance;
    }

    public UserDAO getUserDao() {
        return userDAO;
    }

    public ProductDAO getProductDao() {
        return productDAO;
    }

    public OrderDAO getOrderDao() {
        return orderDAO;
    }

    public ColorDAO getColorDao() {
        return colorDAO;
    }
}

