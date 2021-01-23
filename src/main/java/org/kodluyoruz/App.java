package org.kodluyoruz;

import org.kodluyoruz.services.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("org.kodluyoruz");
        appContext.refresh();
        appContext.close();
    }
}
