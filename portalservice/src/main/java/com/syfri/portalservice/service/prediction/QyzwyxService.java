package com.syfri.portalservice.service.prediction;

import com.syfri.baseapi.service.BaseService;
import com.syfri.portalservice.model.prediction.QyzwyxVO;

import java.util.List;

public interface QyzwyxService  extends BaseService<QyzwyxVO>{

    /*--查询：代码集.--*/
    List<QyzwyxVO> dofindtjfx(QyzwyxVO qyzwyxVO);
    /*--查询：代码集.--*/
    List<QyzwyxVO> dofindtjfxsj(QyzwyxVO qyzwyxVO);

    List<QyzwyxVO> doFindQyzwyxByCplx(QyzwyxVO qyzwyxVO);

}