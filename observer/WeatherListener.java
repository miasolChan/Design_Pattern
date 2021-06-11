package observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface WeatherListener extends ActionListener {
    @Override
    void actionPerformed(ActionEvent event);
}

