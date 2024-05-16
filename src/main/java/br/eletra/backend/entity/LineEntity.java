package br.eletra.backend.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "lines")
public class LineEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Short id;

    @Column(name = "name")
    private String lineName;

    public LineEntity(String name , Short id) {
        setLineName(name);
        setId(id);
    }

    public LineEntity() {}

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LineEntity{" +
                "id=" + id +
                ", lineName='" + lineName + '\'' +
                '}';
    }
}