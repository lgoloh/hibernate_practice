import session.*;
import queries.*;


public class Main {
    
    public static void main(String[] args) {
        SessionHandler sessionHandler = new SessionHandlerImpl();
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
