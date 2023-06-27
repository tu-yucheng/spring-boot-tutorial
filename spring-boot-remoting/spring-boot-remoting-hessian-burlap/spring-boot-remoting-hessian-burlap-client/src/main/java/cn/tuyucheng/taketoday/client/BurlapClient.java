package cn.tuyucheng.taketoday.client;

import cn.tuyucheng.taketoday.api.BookingException;
import cn.tuyucheng.taketoday.api.CabBookingService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.BurlapProxyFactoryBean;

import static java.lang.System.out;

@Configuration
public class BurlapClient {

   public static void main(String[] args) throws BookingException {
      CabBookingService service = SpringApplication.run(BurlapClient.class, args).getBean(CabBookingService.class);
      out.println(service.bookRide("13 Seagate Blvd, Key Largo, FL 33037"));
   }

   @Bean
   public BurlapProxyFactoryBean burlapInvoker() {
      BurlapProxyFactoryBean invoker = new BurlapProxyFactoryBean();
      invoker.setServiceUrl("http://localhost:8032/b_booking");
      invoker.setServiceInterface(CabBookingService.class);
      return invoker;
   }

}
