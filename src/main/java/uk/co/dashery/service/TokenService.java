package uk.co.dashery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.dashery.data.Token;
import uk.co.dashery.repository.TokenRepository;

import java.util.List;

@Service
public class TokenService {
    @Autowired
    private TokenRepository tokenRepository;
    @Autowired
    private TokenJsonParser tokenJsonParser;

    public void createFromJson(String json) {
        List<Token> parsedTokens = tokenJsonParser.parse(json);
        tokenRepository.insert(parsedTokens);
    }

    public List<Token> findAll() {
        return tokenRepository.findAll();
    }
}
