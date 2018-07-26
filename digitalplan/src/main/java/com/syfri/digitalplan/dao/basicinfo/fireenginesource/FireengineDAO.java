package com.syfri.digitalplan.dao.basicinfo.fireenginesource;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.digitalplan.model.basicinfo.fireenginesource.FireengineVO;
import java.util.List;

public interface FireengineDAO extends BaseDAO<FireengineVO>{
    /**
     * @Description:
     * @Param:
     * @Return:
     * @Author: zhaijianchen
     * @Modified By:
     * @Date: 2018/7/25 13:05
     */
   public List<FireengineVO> doSearchByVO(FireengineVO fireengineVO);

}