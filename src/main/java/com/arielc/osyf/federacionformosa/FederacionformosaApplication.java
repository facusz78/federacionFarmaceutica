package com.arielc.osyf.federacionformosa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FederacionformosaApplication {

	public static void main(String[] args) {
		 String password = "Facu1805";

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPassword = encoder.encode(password);

        System.out.println("Contraseña encriptada: " + hashedPassword);
		SpringApplication.run(FederacionformosaApplication.class, args);
	}

}
