package com.mm.demo.disruptor.handler;

import com.lmax.disruptor.EventHandler;
import com.mm.demo.disruptor.entity.Data;

import java.text.MessageFormat;

/**
 * @auther: fujie.feng
 * @DateT: 2020-01-07
 */
public class D1DataEventHandler implements EventHandler<Data> {

    @Override
    public void onEvent(Data event, long sequence, boolean endOfBatch) throws Exception {
        long result = event.getValue() + 1;
        System.out.println(MessageFormat.format("consumer 1 : {0} + 1 = {1}", event.getValue(), result));
    }

}
