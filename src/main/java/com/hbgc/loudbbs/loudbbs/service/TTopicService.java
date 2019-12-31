package com.hbgc.loudbbs.loudbbs.service;

import com.hbgc.loudbbs.loudbbs.entity.TTopic;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hbgc.loudbbs.loudbbs.vo.TTopicVO;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Gaofer
 * @since 2019-12-13
 */
public interface TTopicService extends IService<TTopic> {
    List<TTopicVO> getTopicByTid(int tid);
}
