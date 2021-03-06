package uk.co.dashery.controller;

import org.springframework.web.bind.annotation.*;
import uk.co.dashery.data.Token;
import uk.co.dashery.service.TokenService;

import javax.inject.Inject;
import java.util.List;

@RestController
public class TokenController {

    @Inject
    private TokenService tokenService;

    @CrossOrigin
    @RequestMapping(value = "/tokens/autocomplete", method = RequestMethod.GET)
    public List<Token> tokens() {
        return tokenService.findAll();
    }

    @RequestMapping(value = "/tokens/json", method = RequestMethod.POST)
    public void createTokensFromJson(@RequestBody String json) {
        tokenService.createFromJson(json);
    }
}
