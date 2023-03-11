package com.winter.mp.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import javax.enterprise.context.ApplicationScoped;

/**
 * MybatisPlus 通用字段自动填充
 *
 * @author Zero.
 * @date 2023/3/11 7:16 PM
 */
@ApplicationScoped
public class ModelAutoFillHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {

    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
