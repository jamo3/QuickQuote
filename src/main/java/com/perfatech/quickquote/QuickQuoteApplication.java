package com.perfatech.quickquote;

import javafx.application.Application;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.spring.SpringFxWeaver;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QuickQuoteApplication
{
	public static void main(String[] args) {
		// run JavaFx app to launch SpringBoot
		Application.launch(QuickQuoteFx.class, args);
	}
}
