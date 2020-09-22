package com.neo.usercenter.observer;

/**
 * @author zhaowc
 * @date 2020/9/22
 * @since 1.0.0
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temp;
    private float humidity;
    private float pressure;
    private WeatherData weatherData;

    /**
     * 把自己注册为观察者
     *
     * @param weatherData 主题实例
     */
    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("current condition: ");
        System.out.println("temp = " + temp);
        System.out.println("humidity = " + humidity);
        System.out.println("pressure = " + pressure);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp=temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    public WeatherData getWeatherData() {
        return weatherData;
    }
}
