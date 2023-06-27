package cn.tuyucheng.taketoday.kong.domain;

/**
 * @author tuyucheng
 */
public class TargetObject {

   private String target;
   private int weight;

   public TargetObject(String target, int weight) {
      this.target = target;
      this.weight = weight;
   }

   public String getTarget() {
      return target;
   }

   public void setTarget(String target) {
      this.target = target;
   }

   public int getWeight() {
      return weight;
   }

   public void setWeight(int weight) {
      this.weight = weight;
   }
}