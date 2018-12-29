package com.syfri.userservice.service.venue;

import com.github.pagehelper.PageInfo;
import com.syfri.baseapi.service.BaseService;
import com.syfri.userservice.model.venue.ZwjbxxVO;
import org.apache.poi.hssf.record.formula.functions.T;

import java.util.List;

public interface ZwjbxxService  extends BaseService<ZwjbxxVO>{
    public PageInfo<ZwjbxxVO> doSearchQyPage(ZwjbxxVO vo);
    public List doSearchListQyByVO(ZwjbxxVO vo);

    /*--企业选择的展位数量从大到小进行排序  by li.xue 2018/12/29.--*/
    List<ZwjbxxVO> doFindQyZwNumDesc(ZwjbxxVO zwjbxxVO);
}