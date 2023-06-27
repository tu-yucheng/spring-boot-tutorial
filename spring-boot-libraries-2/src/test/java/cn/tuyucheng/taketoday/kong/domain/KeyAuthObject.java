package cn.tuyucheng.taketoday.kong.domain;

/**
 * @author tuyucheng
 */
public class KeyAuthObject {

   private String key;

   public KeyAuthObject(String key) {
      this.key = key;
   }

   public String getKey() {
      return key;
   }

   public void setKey(String key) {
      this.key = key;
   }
}