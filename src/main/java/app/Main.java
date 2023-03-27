package app;

import session.*;
import queries.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    
    public static void main(String[] args) {
        SessionHandler sessionHandler = new SessionHandlerImpl();
       /* try (Connection conn = DriverManager.getConnection("jdbc:postgresql://vcm-30710.vm.duke.edu:5432/ACC_BBALL", "postgres", "passw0rd")) {
            assert(conn != null);
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }*/
        QueryHandler queryHandler = new QueryHandlerImpl(sessionHandler);
        queryHandler.query1(1, 35, 40, 1, 10, 20, 1, 2, 10, 0, 0, 0, 0, 0, 0, 1, 0, 1.0);
        queryHandler.query1(1, 35, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        queryHandler.query2("Gold");
        queryHandler.query3("Duke");
        queryHandler.query3("GeorgiaTech");
        queryHandler.query4("NC", "DarkBlue");
        queryHandler.query5(10) ;
    }
}
