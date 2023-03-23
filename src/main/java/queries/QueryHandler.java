package queries;

import session.SessionHandler;

public interface QueryHandler {

    public void query1(int use_mpg, int min_mpg, int max_mpg,
                       int use_ppg, int min_ppg, int max_ppg,
                       int use_rpg, int min_rpg, int max_rpg,
                       int use_apg, int min_apg, int max_apg,
                       int use_spg, double min_spg, double max_spg,
                       int use_bpg, double min_bpg, double max_bpg);
    
    //SELECT "TEAM"."NAME" FROM "TEAM", "COLOR" WHERE "TEAM"."COLOR_ID" = "COLOR"."COLOR_ID" AND "COLOR"."NAME" = team_color;
    public void query2(String team_color);

    //SELECT "FIRST_NAME", "LAST_NAME" FROM "PLAYER", "TEAM" WHERE "PLAYER"."TEAM_ID" = "TEAM"."TEAM_ID" AND "NAME" = 'Duke' ORDER BY "PPG" DESC;
    public void query3(String team_name);

    //SELECT "UNIFORM_NUM", "FIRST_NAME", "LAST_NAME" FROM "PLAYER", "TEAM", "STATE", "COLOR" WHERE "PLAYER"."TEAM_ID" = "TEAM"."TEAM_ID" AND "TEAM"."STATE_ID" = "STATE"."STATE_ID" AND "TEAM"."COLOR_ID" = "COLOR"."COLOR_ID" AND "STATE"."NAME" = 'VA' AND "COLOR"."NAME" = 'Maroon';
    public void query4(String team_state, String team_color);

    //SELECT "FIRST_NAME", "LAST_NAME", "TEAM"."NAME", "WINS" FROM "PLAYER", "TEAM" WHERE "PLAYER"."TEAM_ID" = "TEAM"."TEAM_ID" AND "WINS" > 2;
    public void query5(int num_wins);
}