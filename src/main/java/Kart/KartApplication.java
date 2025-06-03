package Kart;

import Kart.service.impl.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class KartApplication {

	public static void main(String[] args) {
		SpringApplication.run(KartApplication.class, args);
	}



}

