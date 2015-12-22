package uk.co.dashery.service;

import org.springframework.stereotype.Service;
import uk.co.dashery.data.Token;
import uk.co.dashery.repository.TokenRepository;

import javax.inject.Inject;
import java.util.List;

@Service
public class TokenService {
    @Inject
    private TokenRepository tokenRepository;
    @Inject
    private TokenJsonParser tokenJsonParser;

    public void createFromJson(String json) {
        List<Token> parsedTokens = tokenJsonParser.parse(json);
        tokenRepository.save(parsedTokens);
    }

    public List<Token> findAll() {
        return tokenRepository.findAll();
    }
}
