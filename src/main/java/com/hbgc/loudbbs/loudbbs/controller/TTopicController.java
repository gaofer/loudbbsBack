package com.hbgc.loudbbs.loudbbs.controller;


import com.hbgc.loudbbs.json.Json;
import com.hbgc.loudbbs.loudbbs.entity.TTopic;
import com.hbgc.loudbbs.loudbbs.mapper.TTopicMapper;
import com.hbgc.loudbbs.loudbbs.service.TTopicService;
import com.hbgc.loudbbs.loudbbs.vo.TTopicVO;
import com.hbgc.loudbbs.utils.MyUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/topic")
public class TTopicController {

    @Resource
    private TTopicService topicService;
    @Resource
    private TTopicMapper topicMapper;


    @GetMapping("/")
    public Map<String, Object> getAll() {
        List<TTopicVO> topicList;
        try {
            topicList = topicMapper.getTopicVO();
            if (topicList != null) {
                return Json.success(topicList, "获取话题列表成功");
            }
            return Json.fail("查询失败");
        } catch (Exception e) {
            e.printStackTrace();
            return Json.fail("查询失败");
        }
    }

    @PostMapping("/addtopic")
    public Map<String, Object> postNewTopic(@RequestBody TTopic newTopic) {
        int heat = 0;
        if (newTopic.getHeat() != null) {
            heat = newTopic.getHeat() + 1;
        }
        newTopic.setHeat(heat);
        try {
            boolean b = topicService.save(newTopic);
            if (b) {
                return Json.success("", "添加成功"); //注册成功
            } else {
                return Json.fail("添加失败"); //注册失败
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return Json.fail("添加失败"); //注册失败
        }
    }

    @PostMapping("/update")
    public Map<String, Object> updateTopic(@RequestBody TTopic newTopic) {
        try {
            boolean b = topicService.updateById(newTopic);
            if (b) {
                return Json.success(null, "修改成功"); //注册成功
            } else {
                return Json.fail("修改失败"); //注册失败
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return Json.fail("修改失败"); //注册失败
        }
    }

    @GetMapping("/topicdetal/{tid}")
    public Map<String, Object> topicDetal(@PathVariable("tid") int tid) {
        List<TTopicVO> topicVOList;
        topicVOList = topicService.getTopicByTid(tid);
        if (topicVOList != null) {
            if (topicVOList.size() == 0) {
                return Json.success(topicVOList, "无这个值");
            }
            return Json.success(topicVOList, "查询成功");
        } else {
            return Json.fail("查询失败");
        }
    }

    @DeleteMapping("/{tid}")
    public Map<String, Object> Deletetopic(@PathVariable("tid") int tid) {
        TTopic t = new TTopic();
        t.setTid(tid);
        if (topicService.removeById(t)) {
            return Json.success(null, "删除成功");
        }
        return Json.fail("删除失败");

    }


    @PostMapping("upload")
    public Map<String, Object> loadFiles(MultipartFile file, HttpServletRequest request) {
        System.out.println("执行上传...");
        //Map<String, Object> map = new HashMap<String, Object>();
        //获得上传的路径
        //String path = request.getSession().getServletContext().getRealPath("/upload");

        String path = null;
        //先判断一下当前是什么操作

        if ("windows".equals(MyUtils.getOperateSysName())) {
            //path = this.uploadWinPath;
        } else {
            //path = this.uploadLinuxPath;
        }

        try {
            String uploadSuccessFileName = MyUtils.uploadFile(file, path);
            return Json.imgsuccess(uploadSuccessFileName);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Json.fail("文件上传失败！");
        }
    }


}

