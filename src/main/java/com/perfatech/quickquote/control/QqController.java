package com.perfatech.quickquote.control;

import com.perfatech.quickquote.service.WeatherService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView("main-scene.fxml")
public class QqController
{
    @FXML
    private Label weatherLabel;

    private WeatherService weatherService;

    @Autowired
    public QqController(WeatherService weatherService)
    {
        this.weatherService = weatherService;
    }

    public void loadWeatherForecast(ActionEvent actionEvent)
    {
        this.weatherLabel.setText(weatherService.getWeatherForecast());
    }
}
