package com.service.observer;
import com.entity.Login;
import com.entity.Notices;
import com.entity.UserRole;
import com.service.LoginService;
import com.service.NoticesService;
import com.service.UserRoleService;
import com.util.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;


public class SystemNoticeObserver implements Observer<UserRole>{

    @Autowired
    LoginService loginService;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    NoticesService noticesService;
    /**
     * 系统通知
     * 用户身份变更
     * @param op
     */
    @Override
    public void update(UserRole op) {
        String userid = op.getUserid();
        Integer roleid = op.getRoleid();
        //修改登录信息
        Integer i = loginService.updateLogin(new Login().setUserid(userid).setRoleid(roleid));
        if(roleid==2){//设为管理员
            userRoleService.UpdateUserRole(new UserRole().setUserid(userid).setRoleid(2).setIdentity("网站管理员"));
            /**发出设置为管理员的系统通知*/
            Notices notices = new Notices().setId(KeyUtil.genUniqueKey()).setUserid(userid).setTpname("系统通知")
                    .setWhys("恭喜您已被设置为网站管理员，努力维护网站的良好氛围。");
            noticesService.insertNotices(notices);
        }else if(roleid==1){//设置为用户
            userRoleService.UpdateUserRole(new UserRole().setUserid(userid).setRoleid(1).setIdentity("网站用户"));
            /**发出设置为网站用户的系统通知*/
            Notices notices = new Notices().setId(KeyUtil.genUniqueKey()).setUserid(userid).setTpname("系统通知")
                    .setWhys("您已被设置为网站用户，希望您再接再厉。");
            noticesService.insertNotices(notices);
        }

    }
}
