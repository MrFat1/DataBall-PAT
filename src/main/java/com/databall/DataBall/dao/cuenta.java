package com.databall.DataBall.dao;

<<<<<<< HEAD

=======
>>>>>>> 0273240062754dbe5eebc7022ea6c99c9fc935a8
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("CUENTA")
public class cuenta {
<<<<<<< HEAD

=======
>>>>>>> 0273240062754dbe5eebc7022ea6c99c9fc935a8
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
<<<<<<< HEAD
}
=======
}
>>>>>>> 0273240062754dbe5eebc7022ea6c99c9fc935a8
