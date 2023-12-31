package cn.tuyucheng.taketoday.annotations.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class Java9Condition implements Condition {

   @Override
   public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
      return ConditionalUtils.isJava9();
   }
}