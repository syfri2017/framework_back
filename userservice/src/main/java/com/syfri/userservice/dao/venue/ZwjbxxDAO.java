package com.syfri.userservice.dao.venue;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.userservice.model.venue.ZwjbxxVO;
import org.apache.poi.hssf.record.formula.functions.T;

import java.util.List;

public interface ZwjbxxDAO extends BaseDAO<ZwjbxxVO>{
    public List<ZwjbxxVO> doSearchListQyByVO(ZwjbxxVO vo);
}