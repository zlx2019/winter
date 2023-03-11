package com.winter.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 公共实体通用Mapper所有的MP数据访问层Mapper都应当继承于本接口.
 * 继承{@link BaseMapper}通用Mapper, 扩展通用功能.
 *
 * @author Zero.
 * @date 2023/3/11 7:18 PM
 */
public interface SuperMapper<T> extends BaseMapper<T> {

}
