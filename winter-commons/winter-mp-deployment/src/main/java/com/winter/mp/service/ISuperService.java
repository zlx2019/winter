package com.winter.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * MP通用Service
 * 继承{@link IService},定义一些通用数据访问层API,进行扩展
 *
 * @author Zero.
 * @date 2023/3/11 7:21 PM
 */
public interface ISuperService<T> extends IService<T> {
}
