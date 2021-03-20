package com.lym.manager.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lym.mapper.user.NoticeMapper;
import com.lym.model.contract.dto.NoticeDTO;
import com.lym.model.contract.vo.NoticeVO;
import com.lym.model.user.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author LYM
 * @Description 通知管理实现
 * @Date 2021/2/19
 * @Version v1.0.0
 **/
@Component
public class NoticeManager {
    @Autowired
    private NoticeMapper noticeMapper;


    public List<NoticeVO> queryAllNotice(NoticeDTO noticeDTO) {
        PageHelper.startPage(noticeDTO.getPage(),noticeDTO.getLimit());
        List<NoticeVO> list = noticeMapper.queryAllNotice(noticeDTO);
        PageInfo<NoticeVO> pageInfo = new PageInfo<>(list);
        list.get(0).setCount(pageInfo.getTotal());
        
        return list;
    }

    public void save(NoticeDTO noticeDTO) {
        noticeMapper.insertSelective(noticeDTO);
    }
}
