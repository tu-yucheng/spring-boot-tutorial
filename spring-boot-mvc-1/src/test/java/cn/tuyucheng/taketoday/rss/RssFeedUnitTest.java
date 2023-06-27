package cn.tuyucheng.taketoday.rss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RssFeedApplication.class)
class RssFeedUnitTest {

   /**
    * Application context.
    */
   @Autowired
   private WebApplicationContext context;

   /**
    * Mock to perform tests on Spring Web Controller.
    */
   private MockMvc mvc;

   /**
    * Sets the test up.
    */
   @BeforeEach
   void setup() {
      mvc = MockMvcBuilders.webAppContextSetup(context).build();
   }

   /**
    * Calls the RSS feed endpoint and checks that the result matches an
    * expected one.
    *
    * @throws Exception
    */
   @Test
   void givenRssFeed_whenComparedWithExisting_thenEquals() throws Exception {
      // The expected response.
      String expectedResult = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><rss version=\"2.0\"> <channel> <title>Tuyucheng RSS Feed</title> <link>http://www.tuyucheng.com</link> <description>Learn how to program in Java</description> <item> <title>JUnit 5 @Test Annotation</title> <link>http://www.tuyucheng.com/junit-5-test-annotation</link> <pubDate>Tue, 19 Dec 2017 00:00:00 GMT</pubDate> <author>donatohan.rimenti@gmail.com</author> </item> <item> <title>Creating and Configuring Jetty 9 Server in Java</title> <link>http://www.tuyucheng.com/jetty-java-programmatic</link> <pubDate>Tue, 23 Jan 2018 00:00:00 GMT</pubDate> <author>donatohan.rimenti@gmail.com</author> </item> <item> <title>Flyweight Pattern in Java</title> <link>http://www.tuyucheng.com/java-flyweight</link> <pubDate>Thu, 01 Feb 2018 00:00:00 GMT</pubDate> <author>donatohan.rimenti@gmail.com</author> </item> <item> <title>Multi-Swarm Optimization Algorithm in Java</title> <link>http://www.tuyucheng.com/java-multi-swarm-algorithm</link> <pubDate>Fri, 09 Mar 2018 00:00:00 GMT</pubDate> <author>donatohan.rimenti@gmail.com</author> </item> <item> <title>A Simple Tagging Implementation with MongoDB</title> <link>http://www.tuyucheng.com/mongodb-tagging</link> <pubDate>Tue, 27 Mar 2018 00:00:00 GMT</pubDate> <author>donatohan.rimenti@gmail.com</author> </item> <item> <title>Double-Checked Locking with Singleton</title> <link>http://www.tuyucheng.com/java-singleton-double-checked-locking</link> <pubDate>Mon, 23 Apr 2018 00:00:00 GMT</pubDate> <author>donatohan.rimenti@gmail.com</author> </item> <item> <title>Introduction to Dagger 2</title> <link>http://www.tuyucheng.com/dagger-2</link> <pubDate>Sat, 30 Jun 2018 00:00:00 GMT</pubDate> <author>donatohan.rimenti@gmail.com</author> </item> </channel></rss>";

      // Performs a post against the RSS feed endpoint and checks that the
      // result is equals to the expected one.
      mvc.perform(MockMvcRequestBuilders.get("/rss"))
            .andExpect(status().isOk())
            .andExpect(content().xml(expectedResult));
   }
}