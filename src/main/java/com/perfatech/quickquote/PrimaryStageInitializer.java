package com.perfatech.quickquote;

import com.perfatech.quickquote.control.PrimaryStage;
import com.perfatech.quickquote.control.TabPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class PrimaryStageInitializer implements ApplicationListener<StageReadyEvent>
{
    private final FxWeaver fxWeaver;

    @Autowired
    public PrimaryStageInitializer(FxWeaver fxWeaver)
    {
        this.fxWeaver = fxWeaver;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event)
    {
        Stage stage = event.stage;
        Scene scene = new Scene(fxWeaver.loadView(PrimaryStage.class),
            600, 450);
        stage.setScene(scene);
        stage.show();
    }
}
