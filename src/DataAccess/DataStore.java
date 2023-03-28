package DataAccess;

import BusinessLogic.User;

public class DataStore {
    private static DataStore instance;
    private UserDAO userDAO;
    private ProductDAO productDAO;
    private OrderDAO orderDAO;
    private ColorDAO colorDAO;
    private SizeDAO sizeDAO;
    private static User currentUser = null;
    


    private DataStore(){
        // Initialize DAOs here
        userDAO = new UserCsvDAO("users.csv");
        productDAO = new ProductCsvDAO("products.csv");
        orderDAO = new OrderCsvDAO("orders.csv");
        colorDAO = new ColorCsvDAO("colors.csv");
        sizeDAO = new SizeCsvDAO("sizes.csv");
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

    public SizeDAO getSizeDao() {
        return sizeDAO;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        DataStore.currentUser = currentUser;
    }

}

