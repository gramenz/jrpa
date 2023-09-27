package net.gramenz.jrpa.lib;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Processor {
    @Scheduled(fixedRateString = "${processor.iteration.duration}") // Führt die Methode alle 1 Sekunden aus
    public void run() {
        // Hier können Sie Ihre Daemon-Logik implementieren
        System.out.println("Processor.run...");
    }
}
