package com.databall.DataBall.dao;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;



@Table("USERS")
public class User {
        private @Column("ID") @Id
        Integer USER_ID;
        private @Column("FIRST_NAME")
        String Name;
        private @Column("LAST_NAME")
        String Surname;
        private @Column("EMAIL")
        String email;
        public Integer getUSERID() {
            return USER_ID;
        }

        public String getName() {
            return Name;
        }
        public String getSurname() {
            return Surname;
        }
        public String getEmail() {
            return email;
        }

        public void setUSER_ID(Integer User_ID) {
            USER_ID = User_ID;
        }

        public void setName(String name) {
            Name = name;
        }
        public void setSurname(String surname) {
            Surname = surname;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public User( String name, String surname, String email) {

            Name = name;
            Surname = surname;
            this.email = email;
        }
        public User() {
            this.USER_ID =0;
            Name = "";
            Surname = "";
            this.email = "";
        }
 }

