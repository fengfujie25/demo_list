package com.mm.demo.common_disruptor.process;

import com.lmax.disruptor.dsl.Disruptor;
import com.mm.demo.common_disruptor.entity.Data;
import com.mm.demo.common_disruptor.handler.D1DataEventHandler;
import com.mm.demo.common_disruptor.handler.D2DataEventHandler;

/**
 * 串行依次计算
 * @auther: fujie.feng
 * @DateT: 2020-01-07
 */
public class Serial {

    public static void serial(Disruptor<Data> disruptor) {
        disruptor.handleEventsWith(new D1DataEventHandler()).then(new D2DataEventHandler());
        disruptor.start();
    }
}
