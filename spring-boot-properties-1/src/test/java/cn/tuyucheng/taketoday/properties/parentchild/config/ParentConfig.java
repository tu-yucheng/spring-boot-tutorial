package cn.tuyucheng.taketoday.properties.parentchild.config;

import cn.tuyucheng.taketoday.properties.parentchild.ParentValueHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:parent.properties")
public class ParentConfig {

   @Bean
   public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
      return new PropertySourcesPlaceholderConfigurer();
   }

   @Bean
   public ParentValueHolder parentValueHolder() {
      return new ParentValueHolder();
   }
}