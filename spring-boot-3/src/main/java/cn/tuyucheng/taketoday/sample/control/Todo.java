package cn.tuyucheng.taketoday.sample.control;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record Todo(
      Long id,
      @NotNull @Size(min = 1) String title,
      String description,
      LocalDate dueDate,
      @NotNull Status status
) {

   public Todo(Long id, String title) {
      this(id, title, null, null, Status.NEW);
   }

   public enum Status {
      NEW, PROGRESS, COMPLETED, ARCHIVED
   }
}