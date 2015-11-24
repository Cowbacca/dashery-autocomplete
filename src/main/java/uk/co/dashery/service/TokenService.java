package uk.co.dashery.service;

import org.springframework.beans.factory.annotation.Autowired;
import uk.co.dashery.Token;
import uk.co.dashery.TokenRepository;

import java.util.List;

public class TokenService {
    @Autowired
    private TokenRepository tokenRepository;

    public void createFromJson(String json) {

    }

    public List<Token> findAll() {
        return tokenRepository.findAll();
    }
}
