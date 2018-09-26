package com.syfri.digitalplan.service.impl.yafjxz;

import com.syfri.digitalplan.dao.yafjxz.YafjxzDAO;
import com.syfri.digitalplan.model.yafjxz.YafjxzVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.digitalplan.service.yafjxz.YafjxzService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("yafjxzService")
public class YafjxzServiceImpl extends BaseServiceImpl<YafjxzVO> implements YafjxzService {

    @Autowired
    private YafjxzDAO yafjxzDAO;

    @Override
    public YafjxzDAO getBaseDAO() {
        return yafjxzDAO;
    }

    public void doDeletcNotIn(String oldYafjxzVOs) {
        yafjxzDAO.doDeletcNotIn(oldYafjxzVOs);
    }

    ;

    @Override
    public List<YafjxzVO> doFindByPlanId(YafjxzVO yafjxzVO) {
        List<YafjxzVO> resultList = null;
        if(yafjxzVO.getKzm().equals("pic")){
            resultList = yafjxzDAO.doFindPicsByPlanId(yafjxzVO);
        }else{
            resultList = yafjxzDAO.doFindByPlanId(yafjxzVO);
        }

        return resultList;
    }

    public int doUpdateByVOList(List<YafjxzVO> yafjxzVOList) {
        int count = 0;
        for (YafjxzVO vo : yafjxzVOList) {
            count = count + yafjxzDAO.doUpdateByVO(vo);
        }
        return count;
    }
}