package id.example.training.controller;

import id.example.training.domain.dto.request.CreateUpdateUserDto;
import id.example.training.domain.dto.response.UserInfoDto;
import id.example.training.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

//class for handle routing only & minim logic

//rest controller annotation to set this class as controller
//request mapping annotation to set base url for all endpoint in this class
@RestController
@RequestMapping("/user")
public class UserController {

    //service that will used in this class
    private final UserService userService;


    //class constructor
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*
    function: get all user info
    endpoint: localhost:8080/user (inherit from request mapping from this class)
    method: GET
    request: none
    response: list of UserInfoDto
     */
    @GetMapping
    public ResponseEntity<List<UserInfoDto>> getAllInfo(){
        List<UserInfoDto> userInfoDtoList = userService.getAllInfo();
        return ResponseEntity.ok(userInfoDtoList);
    }

    /*
    function: create new user
    endpoint: localhost:8080/user
    method: POST
    request: CreateUpdateUserDto
    response: String
     */

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody CreateUpdateUserDto createUpdateUserDto){
        userService.createUser(createUpdateUserDto);
        return ResponseEntity.ok("User Created");
    }

    /*
    function: get user detail by id
    endpoint: localhost:8080/user/detail
    method: GET
    params: userId
    response: UserInfoDto
     */

    @GetMapping("/detail")
    public ResponseEntity<UserInfoDto> getUserDetail(UUID userId){
        UserInfoDto userInfoDto = userService.getDetail(userId);
        return ResponseEntity.ok(userInfoDto);
    }

    /*
    function: update user by id
    endpoint: localhost:8080/user/update/{userId}
    method: PUT
    path variable: userId
    request: CreateUpdateUserDto
    response: String
     */

    @PutMapping("/update/{userId}")
    public ResponseEntity<String> updateUser(
            @PathVariable UUID userId,
            @RequestBody CreateUpdateUserDto updateUserDto
    ){
        userService.updateUser(userId, updateUserDto);
        return ResponseEntity.ok("User Updated");
    }

    /*
    function: hard delete user by id
    endpoint: localhost:8080/user/{userId}
    method: DELETE
    path variable: userId
    response: String
     */

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable UUID userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok("User Deleted");
    }

}
