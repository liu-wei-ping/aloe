package com.aloe.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author liu_wp
 * @date 2017年9月30日
 * @see
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
