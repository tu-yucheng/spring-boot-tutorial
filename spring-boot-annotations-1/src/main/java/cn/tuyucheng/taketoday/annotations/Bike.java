package cn.tuyucheng.taketoday.annotations;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.DependsOn;

@DependsOn
public class Bike implements Vehicle {

   private String color;

   public String getColor() {
      return color;
   }

   @Required
   public void setColor(String color) {
      this.color = color;
   }
}