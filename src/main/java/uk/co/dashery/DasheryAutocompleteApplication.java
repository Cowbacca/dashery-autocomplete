package uk.co.dashery;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
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
        Gson gson = new Gson();
        LinkedTreeMap linkedTreeMap = gson.fromJson(json, LinkedTreeMap.class);
        for(Object entry :linkedTreeMap.values()){
            System.out.println("Json: " + entry);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(DasheryAutocompleteApplication.class, args);
    }
}
