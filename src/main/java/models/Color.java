package models;

import util.DBConsts;
import javax.persistence.*;

@Entity
@Table(name = DBConsts.COLOR)
public class Color {

    @Id
    @Column(name = DBConsts.COLOR_ID, unique = true, nullable = false)
    private int id;

    @Column(name = DBConsts.NAME)
    private String name;

    public Color() {}

    public Color(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}