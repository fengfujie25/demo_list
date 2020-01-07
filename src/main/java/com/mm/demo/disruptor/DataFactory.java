package com.mm.demo.disruptor;

import com.lmax.disruptor.EventFactory;
import com.mm.demo.disruptor.entity.Data;

/**
 * @auther: fujie.feng
 * @DateT: 2020-01-07
 */
public class DataFactory implements EventFactory<Data> {

    @Override
    public Data newInstance() {
        return new Data();
    }
}
