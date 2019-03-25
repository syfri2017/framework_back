package com.syfri.portalservice.model.venue;

import java.util.List;

/**
 * @Description:
 * @Author: lixiaoyang
 * @Modified By:
 * @Date: 2018/12/28 9:39
 */
public class ZgZwsVO {
    private List<ZwjbxxVO> zwjbxxVOs;
    private ZgjbxxVO zgjbxxVO;

    public List<ZwjbxxVO> getZwjbxxVOs() {
        return zwjbxxVOs;
    }

    public void setZwjbxxVOs(List<ZwjbxxVO> zwjbxxVOs) {
        this.zwjbxxVOs = zwjbxxVOs;
    }

    public ZgjbxxVO getZgjbxxVO() {
        return zgjbxxVO;
    }

    public void setZgjbxxVO(ZgjbxxVO zgjbxxVO) {
        this.zgjbxxVO = zgjbxxVO;
    }
}
