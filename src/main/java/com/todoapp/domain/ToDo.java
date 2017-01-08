package com.todoapp.domain;


import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;


public class ToDo {

    @NotNull
    private int id;
    @NotBlank
    private String title;
    private boolean complete;

    public ToDo() {
        super();
    }

    public ToDo(int id, String title, boolean complete) {
        this.id = id;
        this.title = title;
        this.complete = complete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ToDo)) return false;

        ToDo toDo = (ToDo) o;

        if (getId() != toDo.getId()) return false;
        if (isComplete() != toDo.isComplete()) return false;
        return getTitle().equals(toDo.getTitle());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + (isComplete() ? 1 : 0);
        return result;
    }
}
