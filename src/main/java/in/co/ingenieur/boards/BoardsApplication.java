package in.co.ingenieur.boards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.FluxProcessor;
import reactor.core.publisher.FluxSink;

@SpringBootApplication
public class BoardsApplication {

    @Configuration
    @EnableWebMvc
    public class WebConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**");
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(BoardsApplication.class, args);
    }

    @Bean
    FluxProcessor fluxProcessor() {
        return DirectProcessor.create().serialize();
    }

    @Bean
    FluxSink fluxSink(FluxProcessor fluxProcessor) {
        return fluxProcessor.sink();
    }

}
