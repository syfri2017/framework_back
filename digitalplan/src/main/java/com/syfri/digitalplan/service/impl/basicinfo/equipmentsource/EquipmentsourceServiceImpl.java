package com.syfri.digitalplan.service.impl.basicinfo.equipmentsource;

import com.syfri.digitalplan.model.basicinfo.equipmentsource.EquipengineVO;
import com.syfri.digitalplan.model.basicinfo.equipmentsource.EquipmentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.digitalplan.dao.basicinfo.equipmentsource.EquipmentsourceDAO;
import com.syfri.digitalplan.dao.basicinfo.equipmentsource.EquipengineDAO;
import com.syfri.digitalplan.service.basicinfo.equipmentsource.EquipmentsourceService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("equipmentsourceService")
public class EquipmentsourceServiceImpl extends BaseServiceImpl<EquipmentVO> implements EquipmentsourceService {

	@Autowired
	private EquipmentsourceDAO equipmentsourceDAO;
	@Autowired
	private EquipengineDAO equipengineDAO;

	@Override
	public EquipmentsourceDAO getBaseDAO() {
		return equipmentsourceDAO;
	}

	/*--条件查询：重点单位.--*/
	@Override
	public List<EquipmentVO> doFindlist(EquipmentVO equipmentVO){
		return equipmentsourceDAO.doSearchByVO(equipmentVO);
	}

	/*--根据重点单位id获取重点单位详情--*/
	@Override
	public List<EquipmentVO> doFindDetailById(String id) {
		return equipmentsourceDAO.doFindDetailById(id);
	}

	@Override
	public EquipmentVO doInsertEquipment(EquipmentVO equipmentVO) {
		equipmentsourceDAO.doInsertByVO(equipmentVO);
		for (EquipengineVO vo : equipmentVO.getEquipengineVOList()) {
			vo.setZbid(equipmentVO.getUuid());
			equipengineDAO.doInsertByVO(vo);
		}
		return equipmentVO;
	}
}