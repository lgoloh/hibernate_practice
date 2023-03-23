package resources;
import java.util.ArrayList;

public class DBConsts {
    //Database names
    public static final String PLAYER = "\"PLAYER\"";
    public static final String TEAM = "\"TEAM\"";
    public static final String STATE = "\"STATE\"";
    public static final String COLOR = "\"COLOR\"";

    //Player attributes
    //Team attributes: TEAM_ID, NAME, STATE_ID, COLOR_ID, WINS, LOSSES
    //State attributes: STATE_ID, NAME
    //Color attributes: COLOR_ID, NAME
    public static final String PLAYER_ID = "\"PLAYER_ID\"";
    public static final String TEAM_ID = "\"TEAM_ID\"";
    public static final String UNIFORM_NUM = "\"UNIFORM_NUM\"";
    public static final String FIRST_NAME = "\"FIRST_NAME\"";
    public static final String LAST_NAME = "\"LAST_NAME\"";
    public static final String MPG = "\"MPG\"";
    public static final String PPG = "\"PPG\"";
    public static final String RPG = "\"RPG\"";
    public static final String APG = "\"APG\"";
    public static final String SPG = "\"SPG\"";
    public static final String BPG = "\"BPG\"";
    public static final String STATE_ID = "\"STATE_ID\"";
    public static final String COLOR_ID = "\"COLOR_ID\"";
    public static final String WINS = "\"WINS\"";
    public static final String LOSSES = "\"LOSSES\"";
    public static final String NAME = "\"NAME\"";

    public static ArrayList<String> getPlayerAttr() {
        ArrayList<String> attr = new ArrayList<String>();
        attr.ensureCapacity(11);
        attr.add(PLAYER_ID.substring(1, PLAYER_ID.length() - 1));
        attr.add(TEAM_ID.substring(1, TEAM_ID.length() - 1));
        attr.add(UNIFORM_NUM.substring(1, UNIFORM_NUM.length() - 1));
        attr.add(FIRST_NAME.substring(1, FIRST_NAME.length() - 1));
        attr.add(LAST_NAME.substring(1, LAST_NAME.length() - 1));
        attr.add(MPG.substring(1, MPG.length() - 1));
        attr.add(PPG.substring(1, PPG.length() - 1));
        attr.add(RPG.substring(1, RPG.length() - 1));
        attr.add(APG.substring(1, APG.length() - 1));
        attr.add(SPG.substring(1, SPG.length() - 1));
        attr.add(BPG.substring(1, BPG.length() - 1));
        return attr;
    }

    //Removes the double quotes from the attribute constant for printing purposes
    public static String getAttr(String attr) {
        return attr.substring(1, attr.length() - 1);
    }


}


