package br.eletra.backend.models;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class Model {

    @Column(name = "name")
    private String name;

    public Model() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
