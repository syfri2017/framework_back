package com.syfri.userservice.service.system;

import com.syfri.baseapi.service.BaseService;
import com.syfri.userservice.model.system.*;

import java.util.List;

public interface CodelistService  extends BaseService<com.syfri.userservice.model.system.CodelistVO>{

	/*--根据代码类型获取代码集--*/
	List<com.syfri.userservice.model.system.CodelistDetailVO> doFindDetail(String codeid);

	/*--查询：代码集.--*/
	List<com.syfri.userservice.model.system.CodelistVO> doFindCodelist(com.syfri.userservice.model.system.CodelistVO codelistVO);

	/*--新增：代码集.--*/
	com.syfri.userservice.model.system.CodelistVO doInsertCodelist(com.syfri.userservice.model.system.CodelistVO codelistVO);

	/*--修改：代码集.--*/
	com.syfri.userservice.model.system.CodelistVO doUpdateCodelist(com.syfri.userservice.model.system.CodelistVO codelistVO);

	/*--删除：代码集.--*/
	int doDeleteCodelist(List<com.syfri.userservice.model.system.CodelistVO> list);

	/*--查询从表：根据代码集详情对象查询.--*/
	List<com.syfri.userservice.model.system.CodelistDetailVO> doFindCodelistDetail(com.syfri.userservice.model.system.CodelistDetailVO codelistDetailVO);

	/*--新增从表：.--*/
	com.syfri.userservice.model.system.CodelistDetailVO doInsertCodelistDetail(com.syfri.userservice.model.system.CodelistDetailVO codelistDetailVO);

	/*--修改从表：.--*/
	com.syfri.userservice.model.system.CodelistDetailVO doUpdateCodelistDetail(com.syfri.userservice.model.system.CodelistDetailVO codelistDetailVO);

	/*--删除从表：根据主键删除.--*/
	int doDeleteCodelistDetail(List<com.syfri.userservice.model.system.CodelistDetailVO> list);

	/*--根据代码类型查询代码集.--*/
	List<com.syfri.userservice.model.system.CodelistDetailVO> doFindCodelistByType(String codetype);

	/*--根据代码类型查询代码集，按数字大小排序.--*/
	List<com.syfri.userservice.model.system.CodelistDetailVO> doFindCodelistByTypeOrderByNum(String codetype);

	/*--根据代码类型获取树状资源.--*/
	List<com.syfri.userservice.model.system.CodelistTree> doFindCodelistTreeByType(com.syfri.userservice.model.system.CodelistParams codelistParams);

	/*--根据代码类型获取树状资源.--*/
	List<com.syfri.userservice.model.system.CodelistTree> doFindCodelistTreeByType2(com.syfri.userservice.model.system.CodelistParams codelistParams);

	/*--查询队站类型树状资源-- by yushch*/
	List<com.syfri.userservice.model.system.CodelistTree> doFindDzlxCodelisttree(String codetype);

	/*--查询行政区划，只保留31个省-- by yushch*/
	List<com.syfri.userservice.model.system.CodelistDetailVO> doFindXzqhCodelist(String codetype);

	/*--查询燃烧物质树状资源-- by liurui*/
	List<com.syfri.userservice.model.system.CodelistTree> doFindRswzCodelisttree(String codetype);

	/*--查询药剂类型树状资源-- by liurui*/
	List<com.syfri.userservice.model.system.CodelistTree> doFindYjlxCodelisttree(String codetype);

	/*--查询行政区划树状结构 by li.xue.--*/
	List<com.syfri.userservice.model.system.CodelistTree> getXzqhTreeByUser(com.syfri.userservice.model.system.OrganizationVO organizationVO);

	/*--查询泡沫液类型树状结构 by liurui.--*/
	List<com.syfri.userservice.model.system.CodelistTree> doFindPmylxlisttree(String codetype);

	//查询公司主营产品 by yushch
	List<com.syfri.userservice.model.system.CodelistTree> doFindZycptree(String codetype);
}