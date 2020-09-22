package com.neo.usercenter.observer;

/**
 * 观察者模式观察者接口
 *
 * @author zhaowc
 * @date 2020/9/22
 * @since 1.0.0
 */
public interface Observer {

    /**
     * 观察者通知调用方法
     *
     * @param temp     温度
     * @param humidity 湿度
     * @param pressure 气压
     */
    void update(float temp, float humidity, float pressure);
}
