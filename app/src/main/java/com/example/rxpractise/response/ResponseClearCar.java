package com.example.rxpractise.response;

public class ResponseClearCar extends ResponeData{

    private int total;
    private String updated_at;
    private int user_id;
    private int count;
    private String created_at;
    private int id;
    private int version;

    public void setTotal(int total) {
        this.total = total;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getTotal() {
        return total;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getCount() {
        return count;
    }

    public String getCreated_at() {
        return created_at;
    }

    public int getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }
}
