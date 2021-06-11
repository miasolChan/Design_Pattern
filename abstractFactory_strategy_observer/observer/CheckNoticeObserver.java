package com.service.observer;

import com.entity.Commodity;
import com.entity.Notices;
import com.mapper.CommodityMapper;
import com.mapper.NoticesMapper;
import com.util.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class CheckNoticeObserver implements Observer<Commodity>{

    @Autowired
    CommodityMapper commodityService;
    @Autowired
    NoticesMapper noticesService;
    @Override
    public void update(Commodity commodity) {
        Integer commstatus = commodity.getCommstatus();
        String commid = commodity.getCommid();
        Integer i = commodityService.ChangeCommstatus(commid, commstatus);
        if (i == 1){
            /**发出商品审核结果的系统通知*/
            commodity = commodityService.LookCommodity(commodity);

            if (commstatus == 0){
                Notices notices = new Notices().setId(KeyUtil.genUniqueKey()).setUserid(commodity.getUserid()).setTpname("商品审核")
                        .setWhys("您的商品 <a href=/product-detail/"+commodity.getCommid()+" style=\"color:#08bf91\" target=\"_blank\" >"+commodity.getCommname()+"</a> 未通过审核，目前不支持公开发布。");
                noticesService.insertNotices(notices);
            }else if (commstatus == 1){
                Notices notices = new Notices().setId(KeyUtil.genUniqueKey()).setUserid(commodity.getUserid()).setTpname("商品审核")
                        .setWhys("您的商品 <a href=/product-detail/"+commodity.getCommid()+" style=\"color:#08bf91\" target=\"_blank\" >"+commodity.getCommname()+"</a> 已通过审核，快去看看吧。");
                noticesService.insertNotices(notices);
            }
        }
    }
}
