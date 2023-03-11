package com.winter.mp.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.IllegalSQLInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import io.quarkus.runtime.Startup;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * MP 配置类
 *
 * {@link Startup} 表示本类不使用懒加载机制,程序启动时就初始化.
 *
 * @author Zero.
 * @date 2023/3/11 5:09 PM
 */
@ApplicationScoped
@Startup
public class MybatisPlusConfigure {


    /**
     * Mybatis会话工厂
     */
    @Inject SqlSessionFactory factory;


    /**
     * 初始化一些MybatisPlus的插件,实例化本类的时候.
     */
    @PostConstruct
    void startUp(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 分页插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.POSTGRE_SQL));
        // 乐观锁实现拦截器，支持注解实现乐观锁。
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        //用于防止全表更新和删除的攻击。
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        // 用于拦截SQL语句中是否规范。
        interceptor.addInnerInterceptor(new IllegalSQLInnerInterceptor());
        factory.getConfiguration().addInterceptor(interceptor);
    }
}
