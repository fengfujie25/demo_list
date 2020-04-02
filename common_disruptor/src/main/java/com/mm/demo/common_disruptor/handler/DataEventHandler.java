package com.mm.demo.common_disruptor.handler;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import com.mm.demo.common_disruptor.entity.DataBean;

import java.util.List;

/**
 * 数据处理
 * @auther: fujie.feng
 * @DateT: 2020-01-08
 */
public abstract class DataEventHandler implements WorkHandler<DataBean> {

    /**
     * 数据处理
     * @param dataBean
     */
    public abstract void handler(DataBean dataBean);

    @Override
    public void onEvent(DataBean event) throws Exception {
        handler(event);
    }
}
