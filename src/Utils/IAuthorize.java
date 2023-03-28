package Utils;

import BusinessLogic.User;
import static DataAccess.DataStore.getInstance;
import static DataAccess.DataStore.setCurrentUser;

public interface IAuthorize {

    //checks if user exists and if password and email is correct
    public static boolean login(String email, String password) {
        User user = getInstance().getUserDao().read(email);

        if (user == null) {
            //user does not exist
            return false;
        }

        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            //user exists and password is correct
            setCurrentUser(user);
            return true;
        }

        //user exists but password is incorrect
        return false;
    }
    
    public static boolean login(User user) {
        return login(user.getEmail(), user.getPassword());
    }
    
    //password and username validation should be done in the controller
    public static boolean register(User newUser){
        //validation for whether the user already exists
        User res = getInstance().getUserDao().create(newUser);
        if(res == null){
            //user already exists
            return false;
        }
        //user created successfully
        return true;
    }

    public static void logout() {
        setCurrentUser(null);
    }

}
