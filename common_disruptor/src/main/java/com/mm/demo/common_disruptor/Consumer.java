package com.mm.demo.common_disruptor;

import com.lmax.disruptor.WorkHandler;
import com.mm.demo.common_disruptor.entity.Data;

import java.text.MessageFormat;

/**
 * @auther: fujie.feng
 * @DateT: 2020-01-07
 */
public class Consumer implements WorkHandler<Data> {

    @Override
    public void onEvent(Data data) throws Exception {
        long result = data.getValue() + 1;
        System.out.println(MessageFormat.format("{0} + 1 = {1}", data.getValue(), result));
    }
}
