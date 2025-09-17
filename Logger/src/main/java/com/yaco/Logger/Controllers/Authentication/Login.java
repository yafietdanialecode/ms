package com.yaco.Logger.Controllers.Authentication;

import com.yaco.Logger.Controllers.Authentication.JSON.LoginJSONs;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {



    @PostMapping("/auth/login")
    public LoginJSONs.loginResponse loginHandler(@RequestHeader String username) {
        return new LoginJSONs.loginResponse(true, "Successfully Logged In as " + username);
    }

}
