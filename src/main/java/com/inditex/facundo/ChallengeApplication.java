package com.inditex.facundo;

import com.inditex.facundo.app.ports.in.PriceUseCase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class ChallengeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ChallengeApplication.class, args);
	}

}
