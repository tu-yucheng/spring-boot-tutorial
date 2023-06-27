package cn.tuyucheng.taketoday.kong.domain;

/**
 * @author tuyucheng
 */
public class UpstreamObject {

   private String name;

   public UpstreamObject(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}