package cn.tuyucheng.taketoday.conditionalonproperty.service;

public class EmailNotification implements NotificationSender {

   @Override
   public String send(String message) {
      return "Email Notification: " + message;
   }
}