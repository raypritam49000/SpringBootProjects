package com.criteria.query.rest.api.ultility.search.dto.base;

public class BaseDTO {
    protected String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseDTO{" +
                "id='" + id + '\'' +
                '}';
    }
}
