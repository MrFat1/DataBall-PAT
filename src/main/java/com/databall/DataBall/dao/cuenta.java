package com.databall.DataBall.dao;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("CUENTA")
public class cuenta {

    public int getId() {
        return id;
    }
    public cuenta(int id, String password){
        this.id=id;
        this.password=password;
    }
    public void setId(int id) {
        this.id = id;}
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    private @Column("ID") @Id
    int id;
    private @Column("PASSWORD")
    String password;
}