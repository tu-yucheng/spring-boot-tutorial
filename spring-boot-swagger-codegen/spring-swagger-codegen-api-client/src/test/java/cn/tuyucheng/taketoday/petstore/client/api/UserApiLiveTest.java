/*
 * Swagger Petstore
 * This is a sample server Petstore server.  You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).  For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: apiteam@swagger.io
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package cn.tuyucheng.taketoday.petstore.client.api;

import cn.tuyucheng.taketoday.petstore.client.model.User;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 * API tests for UserApi
 */
@Ignore
public class UserApiLiveTest {

   private final UserApi api = new UserApi();


   /**
    * Create user
    * <p>
    * This can only be done by the logged in user.
    *
    * @throws ApiException if the Api call fails
    */
   @Test
   public void createUserTest() {
      User body = null;
      api.createUser(body);

      // TODO: test validations
   }

   /**
    * Creates list of users with given input array
    *
    * @throws ApiException if the Api call fails
    */
   @Test
   public void createUsersWithArrayInputTest() {
      List<User> body = null;
      api.createUsersWithArrayInput(body);

      // TODO: test validations
   }

   /**
    * Creates list of users with given input array
    *
    * @throws ApiException if the Api call fails
    */
   @Test
   public void createUsersWithListInputTest() {
      List<User> body = null;
      api.createUsersWithListInput(body);

      // TODO: test validations
   }

   /**
    * Delete user
    * <p>
    * This can only be done by the logged in user.
    *
    * @throws ApiException if the Api call fails
    */
   @Test
   public void deleteUserTest() {
      String username = null;
      api.deleteUser(username);

      // TODO: test validations
   }

   /**
    * Get user by user name
    *
    * @throws ApiException if the Api call fails
    */
   @Test
   public void getUserByNameTest() {
      String username = null;
      User response = api.getUserByName(username);

      // TODO: test validations
   }

   /**
    * Logs user into the system
    *
    * @throws ApiException if the Api call fails
    */
   @Test
   public void loginUserTest() {
      String username = null;
      String password = null;
      String response = api.loginUser(username, password);

      // TODO: test validations
   }

   /**
    * Logs out current logged in user session
    *
    * @throws ApiException if the Api call fails
    */
   @Test
   public void logoutUserTest() {
      api.logoutUser();

      // TODO: test validations
   }

   /**
    * Updated user
    * <p>
    * This can only be done by the logged in user.
    *
    * @throws ApiException if the Api call fails
    */
   @Test
   public void updateUserTest() {
      String username = null;
      User body = null;
      api.updateUser(username, body);

      // TODO: test validations
   }

}
