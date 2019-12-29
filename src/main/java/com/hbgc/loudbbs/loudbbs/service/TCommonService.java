package com.hbgc.loudbbs.loudbbs.service;

import com.hbgc.loudbbs.loudbbs.entity.TCommon;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hbgc.loudbbs.loudbbs.vo.TCommonVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Gaofer
 * @since 2019-12-13
 */
public interface TCommonService extends IService<TCommon> {

    List<TCommonVO> getCommonsVO(int tid);


}
