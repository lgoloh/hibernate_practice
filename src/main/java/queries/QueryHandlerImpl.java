package queries;

import java.util.List;
import java.util.ArrayList;

import session.SessionHandler;
import resources.DBConsts;
import models.*;

public class QueryHandlerImpl implements QueryHandler {
    SessionHandler sessionHandler;

    public QueryHandlerImpl(SessionHandler sessionHandler) {
        this.sessionHandler = sessionHandler;
    }

    @Override
    public void query1(int use_mpg, int min_mpg, int max_mpg,
                       int use_ppg, int min_ppg, int max_ppg,
                       int use_rpg, int min_rpg, int max_rpg,
                       int use_apg, int min_apg, int max_apg,
                       int use_spg, double min_spg, double max_spg,
                       int use_bpg, double min_bpg, double max_bpg) {
        String query = "from Player";
        String conditions = "";
        conditions = addConditions(conditions, use_mpg, max_mpg, min_mpg, "mpg");
        conditions = addConditions(conditions, use_ppg, max_ppg, min_ppg, "ppg");
        conditions = addConditions(conditions, use_rpg, max_rpg, min_rpg, "rpg");
        conditions = addConditions(conditions, use_apg, max_apg, min_apg, "apg");
        conditions = addConditions(conditions, use_spg, max_spg, min_spg, "spg");
        conditions = addConditions(conditions, use_bpg, max_bpg, min_bpg, "bpg");

        if (conditions != "") {
            query += " where " + conditions;
        } else {
            return;
        }
        List<Object[]> res = sessionHandler.execQuery(query);
        printQueryResults(res, DBConsts.getPlayerAttr());
    }

    @Override
    public void query2(String team_color) {
        String query = "select t.name from Team t INNER JOIN t.color c where c.name = " + team_color;
        List<Object[]> res = sessionHandler.execQuery(query);
        ArrayList<String> attr = new ArrayList<String>();
        attr.add(DBConsts.getAttr(DBConsts.NAME));
        printQueryResults(res, attr);
    }

    @Override
    public void query3(String team_name) {
        String query = "select p.firstName, p.lastName from Player p INNER JOIN p.team t where t.name = " + team_name
                + " ORDER BY p.ppg ASC";
        List<Object[]> res = sessionHandler.execQuery(query);
        ArrayList<String> attr = new ArrayList<String>();
        attr.ensureCapacity(2);
        attr.add(DBConsts.getAttr(DBConsts.FIRST_NAME));
        attr.add(DBConsts.getAttr(DBConsts.LAST_NAME));
        printQueryResults(res, attr);
    }

    @Override
    public void query4(String team_state, String team_color) {
        String query = "select p.uniform_num, p.firstName, p.lastName from Player p "
        + "INNER JOIN p.team t INNER JOIN t.state s INNER JOIN t.color c where s.name = " + team_state +
                " AND c.name = " + team_color;
        List<Object[]> res = sessionHandler.execQuery(query);
        ArrayList<String> attr = new ArrayList<String>();
        attr.ensureCapacity(3);
        attr.add(DBConsts.getAttr(DBConsts.UNIFORM_NUM));
        attr.add(DBConsts.getAttr(DBConsts.FIRST_NAME));
        attr.add(DBConsts.getAttr(DBConsts.LAST_NAME));
        printQueryResults(res, attr);
    }

    @Override
    public void query5(int num_wins) {
        String query = "select p.firstName, p.lastName, t.name, t.wins " +
                " from Player p INNER JOIN p.team t where t.wins > " + num_wins;
        List<Object[]> res = sessionHandler.execQuery(query);
        ArrayList<String> attr = new ArrayList<String>();
        attr.ensureCapacity(4);
        attr.add(DBConsts.getAttr(DBConsts.FIRST_NAME));
        attr.add(DBConsts.getAttr(DBConsts.LAST_NAME));
        attr.add(DBConsts.getAttr(DBConsts.NAME));
        attr.add(DBConsts.getAttr(DBConsts.WINS));
        printQueryResults(res, attr);
    }

    private void printAttributes(List<String> attributes) {
        for (int i = 0; i < attributes.size(); i++) {
            System.out.print(attributes.get(i));
            if (i == attributes.size() - 1) {
                System.out.print("\n");
            } else {
                System.out.print(" ");
            }
        }
    }

    private void printQueryResults(List<Object[]> res, List<String> attributes) {
        printAttributes(attributes);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).length; j++) {
                System.out.print(res.get(i)[j]);
                if (i == res.get(i).length - 1) {
                    System.out.print("\n");
                } else {
                    System.out.print(" ");
                }
            }
        }
    }

    public String addConditions(String conditions, int isEnabled, double max_val, double min_val, String attr) {
        if (isEnabled == 1) {
            if (conditions == "") {
                conditions += "(" + min_val + " <= " + attr + " AND " + attr + " <= " + max_val + ")";
            } else {
                conditions += " AND " + "(" + min_val + " <= " + attr + " AND " + attr + " <= " + max_val + ")";
            }
        }
        return conditions;
    }


}