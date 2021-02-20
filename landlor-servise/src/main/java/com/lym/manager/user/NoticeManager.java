package com.lym.manager.user;

import com.lym.mapper.user.NoticeMapper;
import com.lym.model.contract.dto.NoticeDTO;
import com.lym.model.contract.vo.NoticeVO;
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
       return noticeMapper.queryAllNotice(noticeDTO);
    }

    public void save(NoticeDTO noticeDTO) {
        noticeMapper.insertSelective(noticeDTO);
    }
}
