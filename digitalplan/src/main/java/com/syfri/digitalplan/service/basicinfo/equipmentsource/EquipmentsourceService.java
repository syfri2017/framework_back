package com.syfri.digitalplan.service.basicinfo.equipmentsource;

import com.syfri.baseapi.service.BaseService;
import com.syfri.digitalplan.model.basicinfo.equipmentsource.EquipmentVO;

import java.util.List;

public interface EquipmentsourceService  extends BaseService<EquipmentVO>{

    /*--查询：重点单位.--*/
    List<EquipmentVO> doFindlist(EquipmentVO equipmentVO);

    /*--根据重点单位ID获取重点单位详情-*/
    List<EquipmentVO> doFindDetailById(String id);

    EquipmentVO doInsertEquipment(EquipmentVO equipmentVO);

}