package uk.co.dashery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@SpringBootApplication
@RestController
public class DasheryAutocompleteApplication {
    @Autowired
    private TokenRepository tokenRepository;

    @CrossOrigin
    @RequestMapping(value = "/tokens", method = RequestMethod.GET)
    public List<Token> tokens() {
        return tokenRepository.findAll();
    }

    public static void main(String[] args) {
        SpringApplication.run(DasheryAutocompleteApplication.class, args);
    }
}
