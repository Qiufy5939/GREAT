package org.great.entity;

public class Administrator {
    private String id;
    private String password="!%(!&!^^^$&_!&#^^&%()$$";

    public Administrator(){

    }
    public Administrator(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
