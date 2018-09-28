package com.syfri.digitalplan.service.impl.jxcsplan;

import com.syfri.digitalplan.dao.jxcsplan.JxcsdlyzDAO;
import com.syfri.digitalplan.dao.jxcsplan.JxcsxfssDAO;
import com.syfri.digitalplan.model.jxcsplan.JxcsdlyzVO;
import com.syfri.digitalplan.model.jxcsplan.JxcsjzxxVO;
import com.syfri.digitalplan.model.jxcsplan.JxcsxfssVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.digitalplan.dao.jxcsplan.JxcsjbxxDAO;
import com.syfri.digitalplan.model.jxcsplan.JxcsjbxxVO;
import com.syfri.digitalplan.service.jxcsplan.JxcsjbxxService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("jxcsjbxxService")
public class JxcsjbxxServiceImpl extends BaseServiceImpl<JxcsjbxxVO> implements JxcsjbxxService {

    @Autowired
    private JxcsjbxxDAO jxcsjbxxDAO;
    @Autowired
    private JxcsdlyzDAO jxcsdlyzDAO;
    @Autowired
    private JxcsxfssDAO jxcsxfssDAO;


    @Override
    public JxcsjbxxDAO getBaseDAO() {
        return jxcsjbxxDAO;
    }

    public int doDeleteByVOList(List<JxcsjbxxVO> jxcsjbxxVOList) {
        int count = 0;
        for (JxcsjbxxVO vo : jxcsjbxxVOList) {
            count = count + jxcsjbxxDAO.doUpdateByVO(vo);
        }
        return count;
    }

    //新增九小场所 add by yushch 20180920
    public JxcsjbxxVO doInsertJbcsByVO(JxcsjbxxVO vo) {
        jxcsjbxxDAO.doInsertByVO(vo);
        if(vo.getJzxxList().size() != 0){
            List<JxcsjzxxVO> jxcsjzxx = vo.getJzxxList();
            List<JxcsdlyzVO> jxcsdlyz =new ArrayList<JxcsdlyzVO>();
            for(int i=0;i<jxcsjzxx.size();i++){
                JxcsdlyzVO jxcsdlyzVO = new JxcsdlyzVO();
                jxcsdlyzVO.setJzid(jxcsjzxx.get(i).getJzid());
                jxcsdlyzVO.setDwid(vo.getUuid());
                jxcsdlyz.add(jxcsdlyzVO);
            }
            jxcsdlyzDAO.doBatchInsertByList(jxcsdlyz);
        }
        if(vo.getXfssList().size() != 0){
            List<JxcsxfssVO> jxcsxfss = vo.getXfssList();
            for(int i=0;i<jxcsxfss.size();i++){
                jxcsxfss.get(i).setDwid(vo.getUuid());
            }
            jxcsxfssDAO.doBatchInsertByList(jxcsxfss);
        }

        return vo;

    }
}