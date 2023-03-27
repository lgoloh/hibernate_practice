package session;

import java.util.List;

public interface SessionHandler {

    public List<Object[]> execQuery(String query);

}