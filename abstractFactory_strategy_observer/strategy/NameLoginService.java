package com.service.strategy;

import com.entity.Login;
import com.entity.LoginDto;
import com.service.strategy.LoginWayService;
import org.springframework.stereotype.Service;

@Service("NameLoginService")
public class NameLoginService implements LoginWayService{

    @Override
    public Login wayResult(LoginDto dto) {
        Login login = new Login();
        login.setUsername(dto.getAccount());
        login.setPassword(dto.getPassword());
        return login;
    }
}
