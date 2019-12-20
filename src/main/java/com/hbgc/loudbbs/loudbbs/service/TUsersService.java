package com.hbgc.loudbbs.loudbbs.service;

import com.hbgc.loudbbs.loudbbs.entity.TUsers;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Gaofer
 * @since 2019-12-06
 */
public interface TUsersService extends IService<TUsers> {
    TUsers saveU(TUsers saveu);

}
