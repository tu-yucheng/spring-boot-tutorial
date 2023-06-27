/*
 * Swagger Petstore
 * This is a sample server Petstore server.  You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).  For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * The version of the OpenAPI document: 1.0.3
 * Contact: apiteam@swagger.io
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package cn.tuyucheng.taketoday.petstore.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * ModelApiResponse
 */
@JsonPropertyOrder({
      ModelApiResponse.JSON_PROPERTY_CODE,
      ModelApiResponse.JSON_PROPERTY_TYPE,
      ModelApiResponse.JSON_PROPERTY_MESSAGE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-15T06:14:01.568992-05:00[America/Chicago]")
public class ModelApiResponse {
   public static final String JSON_PROPERTY_CODE = "code";
   public static final String JSON_PROPERTY_TYPE = "type";
   public static final String JSON_PROPERTY_MESSAGE = "message";
   private Integer code;
   private String type;
   private String message;


   public ModelApiResponse code(Integer code) {

      this.code = code;
      return this;
   }

   /**
    * Get code
    *
    * @return code
    **/
   @javax.annotation.Nullable
   @ApiModelProperty(value = "")
   @JsonProperty(JSON_PROPERTY_CODE)
   @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

   public Integer getCode() {
      return code;
   }


   public void setCode(Integer code) {
      this.code = code;
   }


   public ModelApiResponse type(String type) {

      this.type = type;
      return this;
   }

   /**
    * Get type
    *
    * @return type
    **/
   @javax.annotation.Nullable
   @ApiModelProperty(value = "")
   @JsonProperty(JSON_PROPERTY_TYPE)
   @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

   public String getType() {
      return type;
   }


   public void setType(String type) {
      this.type = type;
   }


   public ModelApiResponse message(String message) {

      this.message = message;
      return this;
   }

   /**
    * Get message
    *
    * @return message
    **/
   @javax.annotation.Nullable
   @ApiModelProperty(value = "")
   @JsonProperty(JSON_PROPERTY_MESSAGE)
   @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

   public String getMessage() {
      return message;
   }


   public void setMessage(String message) {
      this.message = message;
   }


   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      ModelApiResponse _apiResponse = (ModelApiResponse) o;
      return Objects.equals(this.code, _apiResponse.code) &&
            Objects.equals(this.type, _apiResponse.type) &&
            Objects.equals(this.message, _apiResponse.message);
   }

   @Override
   public int hashCode() {
      return Objects.hash(code, type, message);
   }


   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ModelApiResponse {\n");
      sb.append("    code: ").append(toIndentedString(code)).append("\n");
      sb.append("    type: ").append(toIndentedString(type)).append("\n");
      sb.append("    message: ").append(toIndentedString(message)).append("\n");
      sb.append("}");
      return sb.toString();
   }

   /**
    * Convert the given object to string with each line indented by 4 spaces
    * (except the first line).
    */
   private String toIndentedString(java.lang.Object o) {
      if (o == null) {
         return "null";
      }
      return o.toString().replace("\n", "\n    ");
   }

}

