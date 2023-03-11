package com.winter.core.cdi;

import com.winter.core.annotations.PrimaryLiteral;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Provider;
import java.util.Optional;

/**
 * CDI 上下文获取工具
 *
 * @author Zero.
 * @date 2023/3/11 8:08 PM
 */
@Slf4j
public final class CDIContext {

    /**
     * 获取当前上下文CDI容器
     *
     * @return {@link CDI}
     */
    private static Optional<CDI<Object>> getCDI() {
        try {
            return Optional.of(CDI.current());
        } catch (Exception e) {
            log.error("Load CDI Fail...", e);
            return Optional.empty();
        }
    }

    /**
     * 根据Bean的类型,在CDI中获取实例
     *
     * @param clazz Bean的类型
     * @return      Bean的实例
     */
    public static <T> Optional<Instance<T>> getInstance(Class<T> clazz) {
        return getCDI().map(cdi -> cdi.select(clazz));
    }

    /**
     * 根据Bean的类型,在CDI中获取实例
     * @param clazz     Bean的类型
     * @return          Bean的实例对象
     */
    public static <T> Optional<T> getBean(Class<T> clazz){
        return getInstance(clazz).map(Provider::get);
    }

    /**
     * 根据Bean的类型,获取Bean的实例。
     * 如果有多个Bean实例,则获取那个标注了{@link com.winter.core.annotations.Primary}的实例
     *
     * @param clazz     Bean的类型
     * @return          Bean的实例对象
     */
    public static <T> Optional<T> getBeanPrimary(Class<T> clazz){
        return getCDI()
                .flatMap(cdi-> cdi.select(clazz, PrimaryLiteral.INSTANCE).stream().findFirst());
    }

}
