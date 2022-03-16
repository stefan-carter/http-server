package co.uk.barclays.httpserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HttpServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HttpServerApplication.class, args);
	}

}

// Ctrl C stops server running.
