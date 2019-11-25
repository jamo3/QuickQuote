package com.perfatech.quickquote;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class QuickQuoteFx extends Application
{
    private ConfigurableApplicationContext context;

    @Override
    public void init() {
        this.context = new SpringApplicationBuilder()
            .sources(QuickQuoteApplication.class)
            .run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void start(Stage primaryStage) {
        context.publishEvent(new StageReadyEvent(primaryStage));
    }

    @Override
    public void stop() {
        context.close();
        Platform.exit();
    }
}
