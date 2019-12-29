package com.hbgc.loudbbs.loudbbs.service.impl;

import com.hbgc.loudbbs.loudbbs.entity.TCommon;
import com.hbgc.loudbbs.loudbbs.mapper.TCommonMapper;
import com.hbgc.loudbbs.loudbbs.service.TCommonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbgc.loudbbs.loudbbs.vo.TCommonVO;
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
public class TCommonServiceImpl extends ServiceImpl<TCommonMapper, TCommon> implements TCommonService {

    @Override
    public List<TCommonVO> getCommonsVO(int tid) {
        return this.baseMapper.getCommonDetalVO(tid);
    }
}
