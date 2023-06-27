package cn.tuyucheng.taketoday.feign.clients.header.staticheader.parameterized;

import cn.tuyucheng.taketoday.feign.clients.builder.BookFeignClientBuilder;
import cn.tuyucheng.taketoday.feign.models.Book;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * Consumes https://github.com/Tuyucheng/spring-hypermedia-api
 */
public class BookClientLiveTest {

   private BookClient bookClient;

   private String requester = "test";

   @Before
   public void setup() {
      bookClient = BookFeignClientBuilder.createClient(BookClient.class, "http://localhost:8081/api/books");
   }

   @Test
   public void givenBookClient_shouldFindOneBook() throws Exception {
      Book book = bookClient.findByIsbn(requester, "0151072558")
            .getBook();
      assertThat(book.getAuthor(), containsString("Orwell"));
   }
}