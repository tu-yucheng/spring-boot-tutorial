package cn.tuyucheng.taketoday.javaxval.container.validation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.Map;

public class CustomerMap {

   private Map<@Email(message = "Must be a valid email") String, @NotNull Customer> customers;

   public Map<String, Customer> getCustomers() {
      return customers;
   }

   public void setCustomers(Map<String, Customer> customers) {
      this.customers = customers;
   }
}
