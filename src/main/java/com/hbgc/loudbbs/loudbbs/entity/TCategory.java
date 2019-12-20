package com.hbgc.loudbbs.loudbbs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Gaofer
 * @since 2019-12-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TCategory implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "cid", type = IdType.AUTO)
    private Integer cid;

    private String cname;


}
