package br.eletra.backend.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "models")
public class ModelEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Short id;

    @Column(name = "name")
    private String modelName;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private CategoryEntity category;

    public ModelEntity(String modelName , Short id) {
        setModelName(modelName);
        setId(id);
    }

    public ModelEntity() {
    }

    public void ModelEntity(CategoryEntity category , String modelName){
        this.category = category;
        this.modelName = modelName;
    }

    @Override
    public String toString(){
        return modelName;
    }

    public Short getId() {
        return id;
    }

    public Short setId(Short id) {
        this.id = id;
        return id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getCategory() {

        return category.getCategoryName();
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}