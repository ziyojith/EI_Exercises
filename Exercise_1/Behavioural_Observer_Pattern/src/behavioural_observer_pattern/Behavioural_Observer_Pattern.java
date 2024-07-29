/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package behavioural_observer_pattern;

/**
 *
 * @author JITHIN V J
 */
// Observer Pattern

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(float temperature);
}

class WeatherStation {
    private List<Observer> observers;
    private float temperature;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}

class PhoneApp implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("Phone App: The temperature is now " + temperature + "°C");
    }
}

class WebsiteWidget implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("Website Widget: The temperature is now " + temperature + "°C");
    }
}

// Usage
public class Behavioural_Observer_Pattern{
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        PhoneApp phoneApp = new PhoneApp();
        WebsiteWidget websiteWidget = new WebsiteWidget();

        weatherStation.registerObserver(phoneApp);
        weatherStation.registerObserver(websiteWidget);

        weatherStation.setTemperature(25);
        weatherStation.setTemperature(30);
    }
}
