package com.service.strategy;

import com.entity.Login;
import com.entity.LoginDto;
import com.service.LoginService;
import com.service.strategy.LoginWayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("PhoneLoginService ")
public class PhoneLoginService implements LoginWayService {

    @Override
    public Login wayResult(LoginDto dto) {
        Login login = new Login();
        login.setMobilephone(dto.getAccount());
        login.setPassword(dto.getPassword());
        return login;
    }
}
