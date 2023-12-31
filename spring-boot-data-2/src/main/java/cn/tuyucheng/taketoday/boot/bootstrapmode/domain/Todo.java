package cn.tuyucheng.taketoday.boot.bootstrapmode.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String label;

   public Todo() {
   }

   public Todo(String label) {
      this.label = label;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getLabel() {
      return label;
   }

   public void setLabel(String label) {
      this.label = label;
   }
}
