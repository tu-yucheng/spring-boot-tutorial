package cn.tuyucheng.taketoday.failureanalyzer;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MyService {

   @Resource(name = "myDAO")
   private MyDAO myDAO;
}