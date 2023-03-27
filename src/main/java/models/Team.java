package models;

import util.DBConsts;

import javax.persistence.*;

@Entity
@Table(name = DBConsts.TEAM)
public class Team {
    @Id
    @Column(name = DBConsts.TEAM_ID, unique = true, nullable = false)
    private int id;
    @Column(name = DBConsts.NAME)
    private String name;
    @Column(name = DBConsts.STATE_ID)
    private int state_id;
    @Column(name = DBConsts.COLOR_ID)
    private int color_id;
    @Column(name = DBConsts.WINS)
    private int wins;
    @Column(name = DBConsts.LOSSES)
    private int losses;

    @ManyToOne
    @JoinColumn(name = DBConsts.COLOR_ID)
    private Color color;

    @ManyToOne
    @JoinColumn(name = DBConsts.STATE_ID)
    private State state;

    public Team() {}

    public Team(int id, String name, int state, int color, int wins, int losses) {
        this.id = id;
        this.name = name;
        this.state_id = state;
        this.color_id = color;
        this.wins = wins;
        this.losses = losses;
    }

    public int getId() { return id; }

    public void setId(int id ) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getStateId() { return state_id; }

    public void setStateId(int id) { state_id = id; }

    public int getColorId() { return color_id; }

    public void setColorId(int id ) { color_id = id; }

    public int getWins() { return wins; }

    public void setWins(int w) { wins = w; }

    public int getLosses() { return losses; }

    public void setLosses(int l) { losses = l; }

    public Color getColor() { return color; }

    public void setColor(Color cl) { color = cl; }

    public State getState() { return state; }

    public void setState(State st) { state = st; }
}