package br.com.fiap.ms_email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsEmailApplication.class, args);
    }

}
