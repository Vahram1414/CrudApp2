
package com.vahram.crudapp.model;

public class Skill {
    private String name;
    private Integer id;

    public Skill() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Skill(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
