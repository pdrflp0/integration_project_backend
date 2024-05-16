package br.eletra.backend.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "categories")
public class CategoryEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Short id;

    @Column(name = "name")
    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "line_id")
    private LineEntity line;

    public CategoryEntity(String name , Short id) {
        setCategoryName(name);
        setId(id);
    }

    public CategoryEntity() {

    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getLine() {
        return line.getLineName();
    }

    public void setLine(LineEntity line) {
        this.line = line;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", line=" + line +
                '}';
    }
}