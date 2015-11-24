package uk.co.dashery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.co.dashery.Token;
import uk.co.dashery.service.TokenService;

import java.util.List;

@RestController
public class TokenController {

    @Autowired
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
