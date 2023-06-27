package cn.tuyucheng.taketoday.application.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

   private final String name;
   private final String email;
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;

   public User() {
      this.name = "";
      this.email = "";
   }

   public User(String name, String email) {
      this.name = name;
      this.email = email;
   }

   public long getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public String getEmail() {
      return email;
   }

   @Override
   public String toString() {
      return "User{" + "id=" + id + ", name=" + name + ", email=" + email + '}';
   }
}