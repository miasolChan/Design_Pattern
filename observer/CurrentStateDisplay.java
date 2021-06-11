package observer;

import java.awt.event.ActionEvent;

public class CurrentStateDisplay implements DisplayElement{
    private float temperature;
    private float humidity;
    private WeatherData weatherData;

    public CurrentStateDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.addActionListener(new WeatherListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                WeatherData wd = (WeatherData)event.getSource();
                temperature=wd.getTemperature();
                humidity = wd.getHumidity();
            }
        });
    }

    @Override
    public void dispaly() {
        System.out.println("CurrentState:"+temperature+"F degree and "+humidity+"% humidity");
    }
}
