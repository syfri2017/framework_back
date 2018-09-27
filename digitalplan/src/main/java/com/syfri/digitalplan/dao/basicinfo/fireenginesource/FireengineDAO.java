package com.syfri.digitalplan.dao.basicinfo.fireenginesource;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.digitalplan.model.basicinfo.fireenginesource.FireengineVO;
import java.util.List;

public interface FireengineDAO extends BaseDAO<FireengineVO>{
    /**
     * @Description:
     * @Param:
     * @Return:
     * @Author: liurui
     * @Modified By:
     * @Date: 2018/9/21 15:15
     */
   public List<FireengineVO> doFindListByGis(FireengineVO fireengineVO);


}