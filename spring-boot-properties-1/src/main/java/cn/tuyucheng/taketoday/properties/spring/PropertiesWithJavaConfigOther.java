package cn.tuyucheng.taketoday.properties.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:bar.properties")
public class PropertiesWithJavaConfigOther {

   public PropertiesWithJavaConfigOther() {
      super();
   }
}