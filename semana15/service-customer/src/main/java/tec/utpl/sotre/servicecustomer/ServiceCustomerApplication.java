package tec.utpl.sotre.servicecustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCustomerApplication.class, args);
	}

}
