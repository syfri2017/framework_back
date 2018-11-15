package com.syfri.userservice.dao.system;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.userservice.model.system.MailVO;
import org.apache.poi.hssf.record.formula.functions.T;

import java.util.List;

public interface MailDAO extends BaseDAO<MailVO>{
    //查询当前可用邮箱
    public List<MailVO> doSearchAbleListByVO(MailVO vo);
}