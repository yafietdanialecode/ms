package com.yaco.Logger.Controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class HomeController {

    private record Person(long id, String name) {}
    private record AuthResponse(int status, String message) {};
    private record UserInfo(String username, String password) {};
    private record AccountInfo(String username, String password) {};
    private record LoginResponse(Boolean success, String message, String sessionID) {};
    private Person person = new Person(2, "Thomas Muller"); 
    
    private record UserSignUpForm(String username, String password) {};

    // simple route for testing
    @GetMapping("/")
    public Person hiThere() {
        return person;
    }

    @PostMapping("/auth")
    public UserInfo auth(@RequestBody UserInfo user) {
        return new UserInfo(user.username, user.password);
    }
    
    @PostMapping("/sign-up")
    public String signUp(@RequestBody UserSignUpForm form) {
        return "Account Created with username " + form.username + " successfully";
    }    

    @PostMapping("/login")
    public LoginResponse login(@RequestBody AccountInfo account) {
        
        return new LoginResponse(true, "Successfully Logged In As " + account.username, "34lkwerkweroi32uo4i2u3o4i");
    }
    

}