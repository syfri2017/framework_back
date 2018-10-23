package com.syfri.userservice.service.impl.system;

import com.syfri.userservice.utils.CurrentUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.userservice.dao.system.ImgUploadDAO;
import com.syfri.userservice.model.system.ImgUploadVO;
import com.syfri.userservice.service.system.ImgUploadService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("imguploadService")
public class ImgUploadServiceImpl extends BaseServiceImpl<ImgUploadVO> implements ImgUploadService {

	@Autowired
	private ImgUploadDAO imgUploadDAO;

	@Override
	public ImgUploadDAO getBaseDAO() {
		return imgUploadDAO;
	}

	/**
	 * @Description: 获取所有图片类型
	 * @Param: []
	 * @Return: java.util.List<com.syfri.userservice.model.system.ImgUploadVO>
	 * @Author: dongbo
	 * @Modified By:
	 * @Date: 2018/5/17 11:05
	 */
	@Override
	public List<ImgUploadVO> doFindAll(){
		return imgUploadDAO.doFindAll();
	}

	/**
	 * @Description: 查询图片名称是否已存在
	 * @Param: [vo]
	 * @Return: java.util.List<com.syfri.userservice.model.system.ImgUploadVO>
	 * @Author: dongbo
	 * @Modified By:
	 * @Date: 2018/5/21 10:26
	 */
	public List<ImgUploadVO> doSearchListByPicName(ImgUploadVO vo){return imgUploadDAO.doSearchListByPicName(vo);}

	/**
	 * @Description: 查询已存的图片类型
	 * @Param: []
	 * @Return: java.util.List<com.syfri.userservice.model.system.ImgUploadVO>
	 * @Author: dongbo
	 * @Modified By:
	 * @Date: 2018/5/28 11:03
	 */
	public List<ImgUploadVO> doSearchSavedListByVO(){
		return imgUploadDAO.doSearchSavedListByVO();
	}

	/**
	 * @Description: 查询手动输入的类型是否存在
	 * @Param: [vo]
	 * @Return: java.util.List<com.syfri.userservice.model.system.ImgUploadVO>
	 * @Author: dongbo
	 * @Modified By:
	 * @Date: 2018/5/31 15:44
	 */
	public List<ImgUploadVO> doSearchListByInputPicType(ImgUploadVO vo){return imgUploadDAO.doSearchListByInputPicType(vo);}

	/**
	 * @Description: 新增图片
	 * @Param: [imgUploadVO]
	 * @Return: int
	 * @Author: dongbo
	 * @Modified By:
	 * @Date: 2018/6/7 11:06
	 */
	public int doInsertImgByVO(ImgUploadVO imgUploadVO) {
		imgUploadVO.setCreateId(CurrentUserUtil.getCurrentUserId());
		imgUploadVO.setCreateName(CurrentUserUtil.getCurrentUserName());

		return imgUploadDAO.doInsertByVO(imgUploadVO);
	}

	/**
	 * @Description: 修改图片
	 * @Param: [imgUploadVO]
	 * @Return: int
	 * @Author: dongbo
	 * @Modified By:
	 * @Date: 2018/6/7 11:12
	 */
	public int doUpdateImgByVO(ImgUploadVO imgUploadVO){
		imgUploadVO.setAlterId(CurrentUserUtil.getCurrentUserId());
		imgUploadVO.setAlterName(CurrentUserUtil.getCurrentUserName());

		return imgUploadDAO.doUpdateByVO(imgUploadVO);
	}
}