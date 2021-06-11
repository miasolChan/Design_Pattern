package observer;

import java.awt.event.ActionEvent;
import java.util.Collection;

public class WeatherData{

    private Collection<WeatherListener> listeners;;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(Collection<WeatherListener> listeners) {
        this.listeners = listeners;
    }

    public void addActionListener(WeatherListener w) {
        listeners.add(w);
        //System.out.println("注册设置监听器");
    }

    public void removeActionListener(WeatherListener w) {
        listeners.remove(w);
        //System.out.println("移除监听");

    }

    public void processEvent(ActionEvent event){
        listeners.forEach(listener->listener.actionPerformed(event));
    }

    public void measurementsChanged() {
        processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
    }

    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
