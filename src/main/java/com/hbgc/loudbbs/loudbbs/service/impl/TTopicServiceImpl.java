package com.hbgc.loudbbs.loudbbs.service.impl;

import com.hbgc.loudbbs.loudbbs.entity.TTopic;
import com.hbgc.loudbbs.loudbbs.mapper.TTopicMapper;
import com.hbgc.loudbbs.loudbbs.service.TTopicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbgc.loudbbs.loudbbs.vo.TTopicVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Gaofer
 * @since 2019-12-13
 */
@Service
public class TTopicServiceImpl extends ServiceImpl<TTopicMapper, TTopic> implements TTopicService {

    @Override
    public List<TTopicVO> getTopicByTid(int tid) {
        return this.baseMapper.getTopicDetalVO(tid);
    }
}
