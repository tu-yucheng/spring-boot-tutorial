package cn.tuyucheng.taketoday.usersservice.adapters.http;

import cn.tuyucheng.taketoday.usersservice.adapters.repository.UserRecord;
import cn.tuyucheng.taketoday.usersservice.service.UnknownUserException;
import cn.tuyucheng.taketoday.usersservice.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
class UsersController {
   @Autowired
   private UsersService usersService;

   @GetMapping("/{id}")
   public UserResponse getUser(@PathVariable("id") String id) {
      var user = usersService.getUserById(id);
      return buildResponse(user);
   }

   @DeleteMapping("/{id}")
   public void deleteUser(@PathVariable("id") String id) {
      usersService.deleteUserById(id);
   }

   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
   public UserResponse createUser(@RequestBody CreateUserRequest body) {
      var user = usersService.createUser(body.name());
      return buildResponse(user);
   }

   @PatchMapping("/{id}")
   public UserResponse patchUser(@PathVariable("id") String id, @RequestBody PatchUserRequest body) {
      var user = usersService.updateUser(id, body.name());
      return buildResponse(user);
   }

   private UserResponse buildResponse(final UserRecord user) {
      return new UserResponse(user.getId(), user.getName());
   }

   @ExceptionHandler(UnknownUserException.class)
   @ResponseStatus(HttpStatus.NOT_FOUND)
   public void handleUnknownUser() {
   }
}