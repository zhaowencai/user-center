package com.neo.usercenter.observer;

/**
 * 观察者模式主题接口
 *
 * @author zhaowc
 * @date 2020/9/22
 * @since 1.0.0
 */
public interface Subject {

    /**
     * 注册观察者
     * @param observer 观察者
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察者
     * @param observer 观察者
     */
    void removeObserver(Observer observer);

    /**
     * 通知观察者
     */
    void notifyObservers();
}
