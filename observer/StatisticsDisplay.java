package observer;

import java.awt.event.ActionEvent;

public class StatisticsDisplay implements DisplayElement{
    private float temperature;
    private float humidity;
    private float pressure;
    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.addActionListener(new WeatherListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                WeatherData wd = (WeatherData)event.getSource();
                temperature=wd.getTemperature();
                humidity = wd.getHumidity();
                pressure = wd.getPressure();
            }
        });
    }

    @Override
    public void dispaly() {
        System.out.println("CurrentState:"+temperature+"F degree and "+humidity+"% humidity"
                          + pressure +" hPa pressure");
    }
}
