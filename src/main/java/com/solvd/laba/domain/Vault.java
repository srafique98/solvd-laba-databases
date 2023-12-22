package com.solvd.laba.domain;

import java.util.List;

public class Vault {
    private long id;
    private int capacity;
    private List<String> items;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Vault{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", items=" + items +
                '}';
    }
}
