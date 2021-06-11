package observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.event.EventListenerList;

public class WeatherStation {

    public static void main(String[] args) {

        Collection<WeatherListener> listeners = new HashSet<>();
        WeatherData weatherData = new WeatherData(listeners);
        CurrentStateDisplay currentStateDisplay = new CurrentStateDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        //温度变化
        weatherData.setMeasurements(80, 65, 1019);
        //播报
        currentStateDisplay.dispaly();
        statisticsDisplay.dispaly();
        forecastDisplay.dispaly();
    }

}








