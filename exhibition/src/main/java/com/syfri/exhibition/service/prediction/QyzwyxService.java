package com.syfri.exhibition.service.prediction;

import com.syfri.baseapi.service.BaseService;
import com.syfri.exhibition.model.prediction.QyzwyxVO;

import java.util.List;

public interface QyzwyxService  extends BaseService<QyzwyxVO>{

    /*--查询：代码集.--*/
    List<QyzwyxVO> dofindtjfx(QyzwyxVO qyzwyxVO);


}