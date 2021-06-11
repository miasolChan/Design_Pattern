package com.service.observer;

import com.entity.Comment;
import com.entity.Commodity;
import com.entity.Notices;
import com.mapper.CommentMapper;
import com.mapper.CommodityMapper;
import com.mapper.NoticesMapper;
import com.util.KeyUtil;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentNoticeObserver implements Observer<Comment>{

    @Autowired
    CommentMapper commentService;
    @Autowired
    CommodityMapper commodityService;
    @Autowired
    NoticesMapper noticesService;

    @Override
    public void update(Comment comment) {
        /**插入评论*/

        Integer i = commentService.insertComment(comment);
        if (i == 1){
            /**发出评论通知消息*/
            Commodity commodity = commodityService.LookCommodity(new Commodity().setCommid(comment.getCommid()));
            Notices notices = new Notices().setId(KeyUtil.genUniqueKey()).setUserid(comment.getSpuserid()).setTpname("评论")
                    .setWhys("您的商品 <a href=/product-detail/"+comment.getCommid()+" style=\"color:#08bf91\" target=\"_blank\" >"+commodity.getCommname()+"</a> 被评论了，快去看看吧。");
            noticesService.insertNotices(notices);
        }
    }
}
