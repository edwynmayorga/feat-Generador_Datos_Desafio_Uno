package com.previred.periodos.swagger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.previred.periodos.tools.FileProperties;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableConfigurationProperties (FileProperties.class)
@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "com.previred.periodos.swagger", 
    "com.previred.periodos.swagger.codegen.api",
    "com.previred.periodos.servicio",
    "com.previred.periodos.tools"})
public class Swagger2SpringBoot implements CommandLineRunner {

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) throws Exception {
        new SpringApplication(Swagger2SpringBoot.class).run(args);
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
}
