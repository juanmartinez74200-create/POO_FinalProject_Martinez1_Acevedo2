package domain;

public class Category {
    private int categoryId;
    private String name;
    private String description;

    // metodos
    public Category(int categoryId, String name, String decription) {
        setCategoryId(categoryId);
        setName(name);
        setDescription(decription);
    }

    // getters y setters
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    

}
