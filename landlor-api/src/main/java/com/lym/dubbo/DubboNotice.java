package com.lym.dubbo;

import com.lym.model.contract.dto.NoticeDTO;
import com.lym.model.contract.vo.NoticeVO;

import java.util.List;

public interface DubboNotice {
    List<NoticeVO> queryAllNotice(NoticeDTO noticeDTO);

    void save(NoticeDTO noticeDTO);

    void updateById(NoticeDTO noticeDTO);

    void deleteNotice(Integer id);

    void removeByIds(List<Integer> integers);
}
