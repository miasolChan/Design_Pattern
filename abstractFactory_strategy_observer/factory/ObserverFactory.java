package com.service.factory;

import com.entity.Comment;
import com.entity.Commodity;
import com.entity.UserRole;
import com.service.observer.CheckNoticeObserver;
import com.service.observer.CommentNoticeObserver;
import com.service.observer.Observer;
import com.service.observer.SystemNoticeObserver;
import org.springframework.beans.factory.annotation.Autowired;

public class ObserverFactory implements AbstarctFactory{

    @Autowired
    Observer observer;

    @Override
    public Object create(Object param) {

        if(param instanceof UserRole){//系统通知
            observer = new SystemNoticeObserver();
        }else if(param instanceof Commodity){//审核通知
            observer = new CheckNoticeObserver();
        }else if (param instanceof Comment){//评论通知
            observer = new CommentNoticeObserver();
        }
        return observer;
    }
}
