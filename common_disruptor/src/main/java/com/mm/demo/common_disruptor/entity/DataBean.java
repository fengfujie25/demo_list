package com.mm.demo.common_disruptor.entity;

import lombok.Data;

import java.util.List;

/**
 * @auther: fujie.feng
 * @DateT: 2020-01-08
 */
@Data
public class DataBean<T> {

    private List<T> dataList;

}
