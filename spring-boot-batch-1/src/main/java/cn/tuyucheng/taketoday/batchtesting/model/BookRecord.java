package cn.tuyucheng.taketoday.batchtesting.model;

public class BookRecord {

   private String bookName;

   private String bookAuthor;

   private String bookFormat;

   private String bookISBN;

   private String publishingYear;

   public String getBookName() {
      return bookName;
   }

   public void setBookName(String bookName) {
      this.bookName = bookName;
   }

   public String getBookAuthor() {
      return bookAuthor;
   }

   public void setBookAuthor(String bookAuthor) {
      this.bookAuthor = bookAuthor;
   }

   public String getBookFormat() {
      return bookFormat;
   }

   public void setBookFormat(String bookFormat) {
      this.bookFormat = bookFormat;
   }

   public String getBookISBN() {
      return bookISBN;
   }

   public void setBookISBN(String bookISBN) {
      this.bookISBN = bookISBN;
   }

   public String getPublishingYear() {
      return publishingYear;
   }

   public void setPublishingYear(String publishingYear) {
      this.publishingYear = publishingYear;
   }

   @Override
   public String toString() {
      return "BookRecord [bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookFormat=" + bookFormat + ", bookISBN=" + bookISBN + ", publishingYear=" + publishingYear + "]";
   }

}
