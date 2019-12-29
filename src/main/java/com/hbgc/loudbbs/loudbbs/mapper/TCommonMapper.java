package com.hbgc.loudbbs.loudbbs.mapper;

import com.hbgc.loudbbs.loudbbs.entity.TCommon;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hbgc.loudbbs.loudbbs.vo.TCommonVO;
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
public interface TCommonMapper extends BaseMapper<TCommon> {

    @Select("SELECT t_common.coid, t_common.uid, t_common.tid, t_common.updatetime, t_common.maincommon, t_users.username, t_topic.topicname FROM t_common INNER JOIN t_topic ON t_common.tid = t_topic.tid INNER JOIN t_users ON t_common.uid = t_users.uid WHERE t_common.tid = #{tid}")
    List<TCommonVO> getCommonDetalVO(int tid);

}
