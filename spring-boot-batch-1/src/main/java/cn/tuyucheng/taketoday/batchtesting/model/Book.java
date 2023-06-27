package cn.tuyucheng.taketoday.batchtesting.model;

public class Book {

   private String author;

   private String name;

   public Book() {
   }

   public String getAuthor() {
      return author;
   }

   public void setAuthor(String author) {
      this.author = author;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Override
   public String toString() {
      return "Book [author=" + author + ", name=" + name + "]";
   }

}
