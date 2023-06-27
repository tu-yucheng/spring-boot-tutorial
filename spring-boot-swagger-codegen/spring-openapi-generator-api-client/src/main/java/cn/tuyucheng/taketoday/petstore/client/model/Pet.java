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

import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Pet
 */
@JsonPropertyOrder({
      Pet.JSON_PROPERTY_ID,
      Pet.JSON_PROPERTY_CATEGORY,
      Pet.JSON_PROPERTY_NAME,
      Pet.JSON_PROPERTY_PHOTO_URLS,
      Pet.JSON_PROPERTY_TAGS,
      Pet.JSON_PROPERTY_STATUS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-15T06:14:01.568992-05:00[America/Chicago]")
public class Pet {
   public static final String JSON_PROPERTY_ID = "id";
   public static final String JSON_PROPERTY_CATEGORY = "category";
   public static final String JSON_PROPERTY_NAME = "name";
   public static final String JSON_PROPERTY_PHOTO_URLS = "photoUrls";
   public static final String JSON_PROPERTY_TAGS = "tags";
   public static final String JSON_PROPERTY_STATUS = "status";
   private Long id;
   private Category category;
   private String name;
   private List<String> photoUrls = new ArrayList<>();
   private List<Tag> tags = null;
   private StatusEnum status;

   public Pet id(Long id) {

      this.id = id;
      return this;
   }

   /**
    * Get id
    *
    * @return id
    **/
   @javax.annotation.Nullable
   @ApiModelProperty(value = "")
   @JsonProperty(JSON_PROPERTY_ID)
   @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Pet category(Category category) {

      this.category = category;
      return this;
   }

   /**
    * Get category
    *
    * @return category
    **/
   @javax.annotation.Nullable
   @ApiModelProperty(value = "")
   @JsonProperty(JSON_PROPERTY_CATEGORY)
   @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

   public Category getCategory() {
      return category;
   }

   public void setCategory(Category category) {
      this.category = category;
   }

   public Pet name(String name) {

      this.name = name;
      return this;
   }

   /**
    * Get name
    *
    * @return name
    **/
   @ApiModelProperty(example = "doggie", required = true, value = "")
   @JsonProperty(JSON_PROPERTY_NAME)
   @JsonInclude(value = JsonInclude.Include.ALWAYS)

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Pet photoUrls(List<String> photoUrls) {

      this.photoUrls = photoUrls;
      return this;
   }

   public Pet addPhotoUrlsItem(String photoUrlsItem) {
      this.photoUrls.add(photoUrlsItem);
      return this;
   }

   /**
    * Get photoUrls
    *
    * @return photoUrls
    **/
   @ApiModelProperty(required = true, value = "")
   @JsonProperty(JSON_PROPERTY_PHOTO_URLS)
   @JsonInclude(value = JsonInclude.Include.ALWAYS)

   public List<String> getPhotoUrls() {
      return photoUrls;
   }

   public void setPhotoUrls(List<String> photoUrls) {
      this.photoUrls = photoUrls;
   }

   public Pet tags(List<Tag> tags) {

      this.tags = tags;
      return this;
   }

   public Pet addTagsItem(Tag tagsItem) {
      if (this.tags == null) {
         this.tags = new ArrayList<>();
      }
      this.tags.add(tagsItem);
      return this;
   }

   /**
    * Get tags
    *
    * @return tags
    **/
   @javax.annotation.Nullable
   @ApiModelProperty(value = "")
   @JsonProperty(JSON_PROPERTY_TAGS)
   @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

   public List<Tag> getTags() {
      return tags;
   }

   public void setTags(List<Tag> tags) {
      this.tags = tags;
   }

   public Pet status(StatusEnum status) {

      this.status = status;
      return this;
   }

   /**
    * pet status in the store
    *
    * @return status
    **/
   @javax.annotation.Nullable
   @ApiModelProperty(value = "pet status in the store")
   @JsonProperty(JSON_PROPERTY_STATUS)
   @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

   public StatusEnum getStatus() {
      return status;
   }

   public void setStatus(StatusEnum status) {
      this.status = status;
   }

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Pet pet = (Pet) o;
      return Objects.equals(this.id, pet.id) &&
            Objects.equals(this.category, pet.category) &&
            Objects.equals(this.name, pet.name) &&
            Objects.equals(this.photoUrls, pet.photoUrls) &&
            Objects.equals(this.tags, pet.tags) &&
            Objects.equals(this.status, pet.status);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, category, name, photoUrls, tags, status);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Pet {\n");
      sb.append("    id: ").append(toIndentedString(id)).append("\n");
      sb.append("    category: ").append(toIndentedString(category)).append("\n");
      sb.append("    name: ").append(toIndentedString(name)).append("\n");
      sb.append("    photoUrls: ").append(toIndentedString(photoUrls)).append("\n");
      sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
      sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

   /**
    * pet status in the store
    */
   public enum StatusEnum {
      AVAILABLE("available"),

      PENDING("pending"),

      SOLD("sold");

      private String value;

      StatusEnum(String value) {
         this.value = value;
      }

      @JsonCreator
      public static StatusEnum fromValue(String value) {
         for (StatusEnum b : StatusEnum.values()) {
            if (b.value.equals(value)) {
               return b;
            }
         }
         throw new IllegalArgumentException("Unexpected value '" + value + "'");
      }

      @JsonValue
      public String getValue() {
         return value;
      }

      @Override
      public String toString() {
         return String.valueOf(value);
      }
   }

}

