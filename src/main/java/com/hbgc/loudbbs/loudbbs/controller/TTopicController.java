package com.hbgc.loudbbs.loudbbs.controller;


import com.hbgc.loudbbs.json.Json;
import com.hbgc.loudbbs.loudbbs.entity.TTopic;
import com.hbgc.loudbbs.loudbbs.mapper.TTopicMapper;
import com.hbgc.loudbbs.loudbbs.service.TTopicService;
import com.hbgc.loudbbs.loudbbs.vo.TTopicVO;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
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
    public Map<String,Object> getAll(){
        List<TTopicVO> topicList;
        try{
            topicList=topicMapper.getTopicVO();
            if(topicList!=null){
                return Json.success(topicList,"获取话题列表成功");
            }
            return Json.fail("查询失败");
        }catch (Exception e){
            e.printStackTrace();
            return Json.fail("查询失败");
        }
    }

    @PostMapping("/addtopic")
    public Map<String,Object> postNewTopic(@RequestBody TTopic newTopic){
        int heat=0;
        if(newTopic.getHeat()!=null){
            heat=newTopic.getHeat()+1;
        }
        newTopic.setHeat(heat);
        try{
            boolean b = topicService.save(newTopic);
            if(b) {
                return Json.success("","添加成功"); //注册成功
            }else{
                return Json.fail("添加失败"); //注册失败
            }
        }catch(Exception ex){
            ex.printStackTrace();
            return Json.fail("添加失败"); //注册失败
        }
    }

    @GetMapping("/topicdetal/{tid}")
    public Map<String,Object> topicDetal(@PathVariable("tid") int tid){
        List<TTopicVO> topicVOList;
        topicVOList=topicService.getTopicByTid(tid);
        if(topicVOList!=null){
            if(topicVOList.size()==0){
                return Json.success(topicVOList,"无这个值");
            }
            return Json.success(topicVOList,"查询成功");
        }else{
            return Json.fail("查询失败");
        }
    }

}

