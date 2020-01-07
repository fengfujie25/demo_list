package com.mm.demo.disruptor.translator;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.mm.demo.disruptor.entity.Data;

import java.text.MessageFormat;

/**
 * @auther: fujie.feng
 * @DateT: 2020-01-07
 */
public class DataEventTranslator implements EventTranslatorOneArg<Data, Long> {

    @Override
    public void translateTo(Data event, long sequence, Long arg0) {
        System.out.println(MessageFormat.format("DataEventTranslator arg0 = {0}, seq = {1}", arg0, sequence));
        event.setValue(arg0);
    }
}
