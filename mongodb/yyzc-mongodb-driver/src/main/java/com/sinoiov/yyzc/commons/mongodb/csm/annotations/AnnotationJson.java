package com.sinoiov.yyzc.commons.mongodb.csm.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationJson {


	/**
	 *  设置此注释 则不调用反射生成 get方法
	 */
	boolean ex();
}
