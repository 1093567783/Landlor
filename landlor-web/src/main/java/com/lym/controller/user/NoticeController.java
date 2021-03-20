package com.lym.controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lym.dubbo.DubboNotice;
import com.lym.model.common.Result;
import com.lym.model.contract.dto.NoticeDTO;
import com.lym.model.contract.vo.NoticeVO;
import com.lym.model.user.vo.UserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author LYM
 * @Description 通知控制
 * @Date 2021/2/19
 * @Version v1.0.0
 **/
@RestController
@RequestMapping("/notice/")
public class NoticeController {
    @Reference
    private DubboNotice dubboNotice;
    /**
     * 公告数据
     *
     * @param noticeDTO
     * @return
     */
    @RequestMapping("loadAllNotice")
    public Result loadAllNotice(NoticeDTO noticeDTO) {
        Result result = new Result();
        List<NoticeVO> list = this.dubboNotice.queryAllNotice(noticeDTO);
        result.setCount(list.get(0).getCount());
        result.setData(list);
        result.setCode(0);
        return result;

    }


    /**
     * 添加公告
     *
     * @param noticeDTO
     * @return
     */
    @RequestMapping("addNotice")
    public Object addNotice(NoticeDTO noticeDTO) {
        Result result = new Result();
        try {
            noticeDTO.setCreatetime(new Date());
            Subject subject = SecurityUtils.getSubject();
            UserVO userVO = (UserVO) subject.getPrincipal();
            noticeDTO.setOpername(userVO.getRealName());
            this.dubboNotice.save(noticeDTO);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
    }

    /**
     * 修改公告
     *
     * @param noticeDTO
     * @return
     */
    @RequestMapping("updateNotice")
    public Object updateNotice(NoticeDTO noticeDTO) {
        Result result = new Result();
        try {
            this.dubboNotice.updateById(noticeDTO);
            return result;
        } catch (Exception e) {
            return result.setError(120,"修改失败");
        }
    }

    /**
     * 删除公告
     *
     * @param id
     * @return
     */
    @RequestMapping("deleteNotice")
    public Object deleteNotice(Integer id) {
        Result result = new Result();
        try {
            this.dubboNotice.deleteNotice(id);
            return result;
        } catch (Exception e) {
            return result.setError(120,"删除失败");
        }
    }
    /**
     * 批量删除公告
     *
     * @param ids
     * @return
     */
    @RequestMapping("batchDeleteNotice")
    public Object batchDeleteNotice(Integer[] ids) {
        Result result = new Result();
        try {
            this.dubboNotice.removeByIds(Arrays.asList(ids));
            return result;
        } catch (Exception e) {
            return result.setError(120,"批量删除失败");
        }
    }
}
