package com.winter.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.winter.mp.mapper.SuperMapper;
import com.winter.mp.service.ISuperService;

/**
 * MP通用ServiceImpl
 * 定义一些通用数据访问层API,进行扩展
 *
 * @author Zero.
 * @date 2023/3/11 7:22 PM
 */
public class SuperServiceImpl<M extends SuperMapper<T>,T> extends ServiceImpl<M,T> implements ISuperService<T> {

}
