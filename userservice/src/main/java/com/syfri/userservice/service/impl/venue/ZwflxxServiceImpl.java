package com.syfri.userservice.service.impl.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.userservice.dao.venue.ZwflxxDAO;
import com.syfri.userservice.model.venue.ZwflxxVO;
import com.syfri.userservice.service.venue.ZwflxxService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("zwflxxService")
public class ZwflxxServiceImpl extends BaseServiceImpl<ZwflxxVO> implements ZwflxxService {

    @Autowired
    private ZwflxxDAO zwflxxDAO;

    @Override
    public ZwflxxDAO getBaseDAO() {
        return zwflxxDAO;
    }

    public int doDeleteZwflxx(List<ZwflxxVO> voList) {
        int sum = 0;
        for (ZwflxxVO vo : voList) {
            sum = sum + zwflxxDAO.doUpdateByVO(vo);
        }
        return sum;
    }
}