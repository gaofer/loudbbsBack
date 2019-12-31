package com.hbgc.loudbbs.loudbbs.controller;


import com.hbgc.loudbbs.json.Json;
import com.hbgc.loudbbs.loudbbs.entity.TCommon;
import com.hbgc.loudbbs.loudbbs.entity.TTopic;
import com.hbgc.loudbbs.loudbbs.service.TCommonService;
import com.hbgc.loudbbs.loudbbs.service.TTopicService;
import com.hbgc.loudbbs.loudbbs.vo.TCommonVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Gaofer
 * @since 2019-12-13
 */
@RestController
@RequestMapping("common")
public class TCommonController {

    @Resource
    private TCommonService commonService;
    @Resource
    private TTopicService topicService;

    /**
     * 根据tid查询所有评论
     *
     * @param tid
     * @return
     */
    @GetMapping("/{tid}")
    public Map<String, Object> getAll(@PathVariable("tid") int tid) {
        List<TCommonVO> topicList;
        try {
            topicList = commonService.getCommonsVO(tid);
            if (topicList.size() != 0) { // 如果评论数不为零，则存在评论
                return Json.success(topicList, "获取评论列表成功");
            } else {
                return Json.success(null, "还没有人评论过，快来抢沙发吧！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Json.fail("查询失败");
        }
    }

    /**
     * 提交评论
     *
     * @param common
     * @return
     */
    @PostMapping("/")
    public Map<String, Object> addCategory(@RequestBody TCommon common) {
        int tid = common.getTid();
        TTopic topic = topicService.getById(tid);
        int heat = topic.getHeat();
        heat++;
        topic.setHeat(heat);
        topic.setUpdatetime(common.getUpdatetime());
        try {
            boolean a = topicService.updateById(topic);
            boolean b = commonService.save(common);
            if (a && b) {
                return Json.success("", "添加成功");
            } else {
                return Json.fail("添加失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return Json.fail("添加失败");
        }

    }

}

