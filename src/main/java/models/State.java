package models;
import resources.DBConsts;
import javax.persistence.*;

@Entity
@Table(name = DBConsts.STATE)
public class State {
    @Id
    @Column(name = DBConsts.STATE_ID, unique = true, nullable = false)
    private int id;
    @Column(name = DBConsts.NAME)
    private String name;

    public State() {}

    public State(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}