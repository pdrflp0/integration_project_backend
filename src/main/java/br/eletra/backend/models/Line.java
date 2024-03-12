package br.eletra.backend.models;

import javax.persistence.*;

@Entity
@Table(name = "lines")
public class Line {

    @Column(name = "name")
    private String name;

    public Line() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
