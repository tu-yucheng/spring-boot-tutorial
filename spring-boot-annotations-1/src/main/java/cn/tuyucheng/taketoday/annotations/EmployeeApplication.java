package cn.tuyucheng.taketoday.annotations;

import cn.tuyucheng.taketoday.annotations.componentscanautoconfigure.teacher.Teacher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(
      basePackages = {
            "cn.tuyucheng.taketoday.annotations.componentscanautoconfigure.healthcare",
            "cn.tuyucheng.taketoday.annotations.componentscanautoconfigure.employee"},
      basePackageClasses = Teacher.class)
@EnableAutoConfiguration(exclude = {JdbcTemplateAutoConfiguration.class})
//@EnableAutoConfiguration(excludeName = {"org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration"})
public class EmployeeApplication {

   public static void main(String[] args) {
      SpringApplication.run(EmployeeApplication.class, args);
   }
}