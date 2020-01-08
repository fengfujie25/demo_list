package com.mm.demo.common_disruptor.process;

import com.lmax.disruptor.dsl.Disruptor;
import com.mm.demo.common_disruptor.entity.Data;
import com.mm.demo.common_disruptor.handler.D1DataEventHandler;
import com.mm.demo.common_disruptor.handler.D2DataEventHandler;

/**
 * 并行执行
 * @auther: fujie.feng
 * @DateT: 2020-01-07
 */
public class Parallel {

    public static void parallel(Disruptor<Data> dataDisruptor) {
        dataDisruptor.handleEventsWith(new D1DataEventHandler(), new D2DataEventHandler());
        dataDisruptor.start();
    }
}
