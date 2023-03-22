package DataAccess;

import java.sql.Connection;

import BusinessLogic.Color;

public abstract class ColorDAO extends DataAccess<Color>{
    public ColorDAO(InputOutput io) {
        super(io);
    }

    public ColorDAO(Connection conn) {
        super(conn);
    }
    //add all specific to colors here
}
