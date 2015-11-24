package uk.co.dashery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@SpringBootApplication
@RestController
public class DasheryAutocompleteApplication {
    @Autowired
    private TokenRepository tokenRepository;

    @CrossOrigin
    @RequestMapping(value = "/tokens/autocomplete", method = RequestMethod.GET)
    public List<Token> tokens() {
        return tokenRepository.findAll();
    }

    @RequestMapping(value = "/tokens/json", method = RequestMethod.POST)
    public void createTokensFromJson(@RequestBody String json) {
        System.out.println(json);
    }

    public static void main(String[] args) {
        SpringApplication.run(DasheryAutocompleteApplication.class, args);
    }
}
