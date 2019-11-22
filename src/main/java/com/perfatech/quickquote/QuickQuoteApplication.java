package com.perfatech.quickquote;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuickQuoteApplication
{
	public static void main(String[] args) {
		// run JavaFx app to launch SpringBoot
		Application.launch(JavaFxQuickQuote.class, args);
	}
}
