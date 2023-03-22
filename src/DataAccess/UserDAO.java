package DataAccess;

import java.sql.Connection;

import BusinessLogic.User;

public abstract class UserDAO extends DataAccess<User>{
    public UserDAO(InputOutput io) {
        super(io);
    }

    public UserDAO(Connection conn) {
        super(conn);
    }
    //add all specific to users here
}
