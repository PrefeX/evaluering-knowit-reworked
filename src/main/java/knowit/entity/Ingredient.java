package knowit.entity;

import knowit.util.IdGenerator;


/**
 * Represents a single ingredient
 *
 * @author Christian
 */
public class Ingredient {

    private Long id;
    private String name;


    /**
     * Set the constructor to private to force the users to use the constructors
     * with parameters
     */
    private Ingredient() {
    }


    public Ingredient(String name) {
        this.id = IdGenerator.generateId();
        this.name = name;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name != null ? name : "";
    }


    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Ingredient{" + "id=" + id + ", name=" + name + '}';
    }

}
