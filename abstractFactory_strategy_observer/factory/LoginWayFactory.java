package com.service.factory;

import com.service.strategy.NameLoginService;
import com.service.strategy.PhoneLoginService;
import com.service.strategy.LoginWayService;
import com.util.JustPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LoginWayFactory implements AbstarctFactory<LoginWayService,String> {

    @Autowired
    @Qualifier("NameLoginService")
    LoginWayService loginWayService;//默认NameLoginService


    @Override
    public LoginWayService create(String account) {
        if(JustPhone.justPhone(account)){
            loginWayService = new PhoneLoginService();
        }else
        {
            loginWayService = new NameLoginService();
        }

        return loginWayService;
    }

}
