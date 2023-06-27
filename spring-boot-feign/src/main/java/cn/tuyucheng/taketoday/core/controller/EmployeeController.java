package cn.tuyucheng.taketoday.core.controller;

import cn.tuyucheng.taketoday.core.client.EmployeeClient;
import cn.tuyucheng.taketoday.core.model.Employee;
import feign.Feign;
import feign.form.spring.SpringFormEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

   private static final String HTTP_FILE_EMPLOYEE_URL = "http://localhost:8081";

   @GetMapping("/employee/{id}")
   public Employee getEmployee(@RequestParam("id") long id) {
      EmployeeClient employeeResource = Feign.builder().encoder(new SpringFormEncoder())
            .target(EmployeeClient.class, HTTP_FILE_EMPLOYEE_URL);
      return employeeResource.getEmployee(id, true);
   }
}