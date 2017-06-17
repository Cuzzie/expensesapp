package org.cuzzie.expensesapp.model;

public class CategoryBuilder {
    private String name;
    private String type;

    public CategoryBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CategoryBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public Category createCategory() {
        return new Category(name, type);
    }
}