package models;
import resources.DBConsts;
import javax.persistence.*;

@Entity
@Table(name = DBConsts.PLAYER)
public class Player {
    @Id
    @Column(name = DBConsts.PLAYER_ID, unique = true, nullable = false)
    private int id;
    @Column(name = DBConsts.TEAM_ID)
    private int team_id;
    @Column(name = DBConsts.UNIFORM_NUM)
    private int uniform_num;
    @Column(name = DBConsts.FIRST_NAME)
    private String firstName;
    @Column(name = DBConsts.LAST_NAME)
    private String lastName;
    @Column(name = DBConsts.MPG)
    private float mpg;
    @Column(name = DBConsts.PPG)
    private float ppg;
    @Column(name = DBConsts.RPG)
    private float rpg;
    @Column(name = DBConsts.APG)
    private float apg;
    @Column(name = DBConsts.SPG)
    private float spg;
    @Column(name = DBConsts.BPG)
    private float bpg;

    @ManyToOne //Many players associated with one team
    @JoinColumn(name = DBConsts.TEAM_ID)
    private Team team;

    @ManyToOne //Many players associated with one state
    @JoinColumn(name = DBConsts.STATE_ID)
    private State state;

    @ManyToOne //Many players associated with one COLOR
    @JoinColumn(name = DBConsts.COLOR_ID)
    private Color color;

    public Player() {}

    public Player(int id, int team_id, int uniform_num, String fname, String lname,
    float mpg, float ppg, float rpg, float apg, float spg, float bpg) {
        this.id = id;
        this.team_id = team_id;
        this.uniform_num = uniform_num;
        this.firstName = fname;
        this.lastName = lname;
        this.mpg = mpg;
        this.ppg = ppg;
        this.rpg = rpg;
        this.apg = apg;
        this.spg = spg;
        this.bpg = bpg;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeamId() {
        return team_id;
    }

    public void setTeamId(int t_id) { team_id = t_id; }

    public int getUniformNum() {
        return uniform_num;
    }

    public void setUniformNum(int u_num) {
        uniform_num = u_num;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) { firstName = name; }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String name) { lastName = name; }

    public float getMpg() { return mpg; }

    public void setMpg(float m) {
        mpg = m;
    }

    public float getPpg() {
        return ppg;
    }

    public void setPpg(float p) {
        ppg = p;
    }

    public float getRpg() {
        return rpg;
    }

    public void setRpg(float r) {
        rpg = r;
    }

    public float getApg() {
        return apg;
    }

    public void setApg(float a) { apg = a; }

    public float getSpg() {
        return spg;
    }

    public void setSpg(float s) {
        spg = s;
    }

    public float getBpg() {
        return bpg;
    }

    public void setBpg(float b) {
        bpg = b;
    }

    public Team getTeam() { return team; }

    public void setTeam(Team team) { this.team = team; }

    public State getState() { return state; }

    public void setState(State st) { state = st; }

    public Color getColor() { return color; }

    public void setColor(Color cl) { color = cl; }

}