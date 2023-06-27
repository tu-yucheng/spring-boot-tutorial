package cn.tuyucheng.taketoday.boot.properties.controller;

import cn.tuyucheng.taketoday.boot.properties.service.SizeConverterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TshirtSizeControllerUnitTest {

   @Mock
   private SizeConverterService service;

   @InjectMocks
   private TshirtSizeController tested;

   @Test
   void whenConvertSize_thenOK() {
      // Given
      String label = "S";
      String countryCode = "fr";
      int result = 36;

      // When
      when(service.convertSize(label, countryCode)).thenReturn(result);
      int actual = tested.convertSize(label, countryCode);

      // Then
      assertEquals(actual, result);
   }
}