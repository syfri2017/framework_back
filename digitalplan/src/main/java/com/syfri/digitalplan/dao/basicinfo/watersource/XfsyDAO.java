package com.syfri.digitalplan.dao.basicinfo.watersource;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.digitalplan.model.basicinfo.watersource.XfsyVO;

import java.util.List;

public interface XfsyDAO extends BaseDAO<XfsyVO>{
    public XfsyVO doFindSyAndSxByVo(XfsyVO vo);
    public XfsyVO doFindSyAndXHSByVo(XfsyVO vo);
    public XfsyVO doFindSyAndXFSCByVo(XfsyVO vo);
    public XfsyVO doFindSyAndXFSHByVo(XfsyVO vo);
    public XfsyVO doFindSyAndTrsyqsdByVo(XfsyVO vo);

    public List<XfsyVO> doFindListByVO(XfsyVO vo);
    public List<XfsyVO> doFindXhsListByVO(XfsyVO vo);
    public List<XfsyVO> doFindXfshListByVO(XfsyVO vo);
    public List<XfsyVO> doFindXfscListByVO(XfsyVO vo);
    public List<XfsyVO> doFindTrsyqsdListByVO(XfsyVO vo);

    //消火栓表插入内容
    int doInsertXhsByVo(XfsyVO vo);
    //消火栓表更新
    int doUpdateXhsByVo(XfsyVO vo);
    //根据水源属性信息id查询消火栓表count
    int doCountXhsBySxid(String sysxxxid);
    //逻辑删除消火栓
    int doDeleteXhsByUuid(String uuid);
}