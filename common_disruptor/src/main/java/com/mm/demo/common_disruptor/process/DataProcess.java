package com.mm.demo.common_disruptor.process;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.mm.demo.common_disruptor.entity.DataBean;
import com.mm.demo.common_disruptor.entity.Student;
import com.mm.demo.common_disruptor.factory.BaseDataFactory;
import com.mm.demo.common_disruptor.handler.DataEventHandler;
import com.mm.demo.common_disruptor.translator.DataBeanEventTranslator;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * @auther: fujie.feng
 * @DateT: 2020-01-08
 */
public class DataProcess {

    private static final int BUFFER = 1024 * 1024;

    public void run() {
        BaseDataFactory dataFactory = new BaseDataFactory();

        Disruptor<DataBean> disruptor = new Disruptor<DataBean>(dataFactory, BUFFER, Executors.defaultThreadFactory(), ProducerType.SINGLE, new BlockingWaitStrategy());

        disruptor.handleEventsWithWorkerPool(new DataEventHandler() {
            @Override
            public void handler(DataBean dataBean) {
                System.out.println("consumer come in..." );
                long start = System.currentTimeMillis();

                List<Student> list = dataBean.getDataList();
                list.stream().forEach(s -> {
                    System.out.println("[" + s.getName() + ">>>" + s.getAge() + "]");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

                long end = System.currentTimeMillis();
                System.out.println("consumer is over.... " + (end - start));
            }
        });
        disruptor.start();

        RingBuffer<DataBean> ringBuffer = disruptor.getRingBuffer();

        ringBuffer.publishEvent(new DataBeanEventTranslator());

        disruptor.shutdown();
    }
}
