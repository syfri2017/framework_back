package com.syfri.portalservice.model.prediction;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.List;

/**
 * @Description:
 * @Author: lixiaoyang
 * @Modified By:
 * @Date: 2019/3/11 15:54
 */
public class QyjbjsVO extends QyjbxxVO {
    private String qyjsSrc;
    private List<QycpjsVO> qycpjsVOs;

    public List<QycpjsVO> getQycpjsVOs() {
        return qycpjsVOs;
    }

    public void setQycpjsVOs(List<QycpjsVO> qycpjsVOs) {
        this.qycpjsVOs = qycpjsVOs;
    }

    public String getQyjsSrc() {
        return qyjsSrc;
    }

    public void setQyjsSrc(String qyjsSrc) {
        this.qyjsSrc = qyjsSrc;
    }
}
