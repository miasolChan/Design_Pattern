package com.service.strategy;

import com.entity.Login;
import com.entity.LoginDto;
import com.service.LoginService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

public interface LoginWayService {

    //返回登录结果对象
    public Login wayResult(LoginDto dto);


}
