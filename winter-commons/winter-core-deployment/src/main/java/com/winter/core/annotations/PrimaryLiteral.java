package com.winter.core.annotations;

import javax.enterprise.util.AnnotationLiteral;

/**
 * 用于获取多个Bean实例的其中默认实例
 *
 * @author Zero.
 * @date 2023/3/11 8:54 PM
 */
public class PrimaryLiteral extends AnnotationLiteral<Primary> implements Primary {
    public static final PrimaryLiteral INSTANCE = new PrimaryLiteral();
}
