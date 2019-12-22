package com.hbgc.loudbbs.loudbbs.mapper;

import com.hbgc.loudbbs.loudbbs.entity.TTopic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hbgc.loudbbs.loudbbs.vo.TTopicVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Gaofer
 * @since 2019-12-13
 */
public interface TTopicMapper extends BaseMapper<TTopic> {

    @Select("SELECT t_topic.tid,t_topic.topicname,t_topic.heat,t_topic.htmlmainbody,t_topic.mainbody,t_topic.createtime,t_topic.updatetime,t_users.username,t_topic.uid,t_category.cname FROM t_topic INNER JOIN t_users ON t_users.uid = t_topic.uid INNER JOIN t_category ON t_category.cid = t_topic.cid WHERE t_topic.tid = #{tid}")
    List<TTopicVO> getTopicDetalVO(int tid);

    @Select("SELECT t_topic.tid,t_topic.topicname,t_topic.heat,t_topic.mainbody,t_topic.createtime,t_topic.updatetime,t_users.username,t_topic.uid,t_category.cname FROM t_topic INNER JOIN t_users ON t_users.uid = t_topic.uid INNER JOIN t_category ON t_category.cid = t_topic.cid")
    List<TTopicVO> getTopicVO();

}
