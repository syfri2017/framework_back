package com.syfri.portalservice.model.venue;



import com.alibaba.fastjson.JSONArray;

import java.util.List;

/**
 * @Description:
 * @Author: lixiaoyang
 * @Modified By:
 * @Date: 2019/1/15 9:49
 */
public class ZgZwmksVO {
	private List<ZgjbxxVO> zgjbxxVOs;
	private JSONArray zwmoJsonDatas;
	public List<ZgjbxxVO> getZgjbxxVOs() {
		return zgjbxxVOs;
	}
	public void setZgjbxxVOs(List<ZgjbxxVO> zgjbxxVOs) {
		this.zgjbxxVOs = zgjbxxVOs;
	}
	public JSONArray getZwmoJsonDatas() {
		return zwmoJsonDatas;
	}
	public void setZwmoJsonDatas(JSONArray zwmoJsonDatas) {
		this.zwmoJsonDatas = zwmoJsonDatas;
	}

}
