package it.rud.rudmarket;

import it.rud.rudmarket.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class RUDMarketApplication {
	public static void main(String[] args) {
		SpringApplication.run(RUDMarketApplication.class, args);
	}
}
