package com.syfri.userservice.dao.venue;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.userservice.model.venue.ZwjbxxVO;

import java.util.List;

public interface ZwjbxxDAO extends BaseDAO<ZwjbxxVO>{
    public List<ZwjbxxVO> doSearchListQyByVO(ZwjbxxVO vo);

    /*--企业选择的展位数量从大到小进行排序  by li.xue 2018/12/29.--*/
    List<ZwjbxxVO> doFindQyZwNumDesc(ZwjbxxVO zwjbxxVO);
}