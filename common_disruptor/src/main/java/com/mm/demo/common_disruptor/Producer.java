package com.mm.demo.common_disruptor;

import com.lmax.disruptor.RingBuffer;
import com.mm.demo.common_disruptor.entity.Data;

import java.nio.ByteBuffer;

/**
 * @auther: fujie.feng
 * @DateT: 2020-01-07
 */
public class Producer {

    private final RingBuffer<Data> ringBuffer;

    public Producer(RingBuffer<Data> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void push(ByteBuffer bf) {
        //获取Seqence
        long seq = ringBuffer.next();

        try {
            Data data = ringBuffer.get(seq);
            //取第一个
            data.setValue(bf.getLong(0));
        } finally {
            ringBuffer.publish(seq);
        }
    }
}
