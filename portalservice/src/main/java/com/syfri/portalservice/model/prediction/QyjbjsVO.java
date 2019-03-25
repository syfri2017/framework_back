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
    private String qjqyid;
    private String qyjsSrc;
    private String qyjj;
    private List<QycpjsVO> qycpjsVOs;

    public String getQjqyid() {
        return qjqyid;
    }

    public void setQjqyid(String qjqyid) {
        super.setQyid(qjqyid);
    }

    public String getQyjj() {
        return qyjj;
    }

    public void setQyjj(String qyjj) {
        this.qyjj = qyjj;
    }

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
