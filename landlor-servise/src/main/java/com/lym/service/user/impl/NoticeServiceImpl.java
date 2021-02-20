package com.lym.service.user.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lym.dubbo.DubboNotice;
import com.lym.manager.user.NoticeManager;
import com.lym.model.contract.dto.NoticeDTO;
import com.lym.model.contract.vo.NoticeVO;
import com.lym.service.user.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author LYM
 * @Description 通知服务实现
 * @Date 2021/2/19
 * @Version v1.0.0
 **/
@Service(interfaceClass = DubboNotice.class, delay = -1, retries = 0)
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    private NoticeManager noticeManager;

    /**
     * 查询通知
     * @param noticeDTO
     * @return
     */
    @Override
    public List<NoticeVO> queryAllNotice(NoticeDTO noticeDTO) {
        return noticeManager.queryAllNotice(noticeDTO);
    }

    /**
     * 保存通知
     * @param noticeDTO
     */
    @Override
    public void save(NoticeDTO noticeDTO) {
        noticeManager.save(noticeDTO);
    }

    /**
     * 修改通知
     * @param noticeDTO
     */
    @Override
    public void updateById(NoticeDTO noticeDTO) {

    }

    /**
     * 删除通知
     * @param id
     */
    @Override
    public void deleteNotice(Integer id) {

    }

    /**
     * 批量删除
     * @param integers
     */
    @Override
    public void removeByIds(List<Integer> integers) {

    }
}
