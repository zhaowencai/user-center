package com.neo.usercenter.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaowc
 * @date 2020/9/22
 * @since 1.0.0
 */
public class WeatherData implements Subject {

    private List<Observer> observers;
    private float temp;
    private float humidity;
    private float pressure;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        final int index = this.observers.indexOf(observer);
        if (index >= 0) {
            this.observers.remove(index);
        }
    }

    @Override
    public void notifyObservers() {
        this.observers.forEach(observer -> observer.update(this.temp, this.humidity, this.pressure));
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
