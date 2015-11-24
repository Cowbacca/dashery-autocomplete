package uk.co.dashery.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import uk.co.dashery.Token;
import uk.co.dashery.TokenRepository;
import uk.co.dashery.service.TokenService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class TokenControllerTest {

    public static final String JSON = "test";
    @InjectMocks
    private TokenController tokenController;

    @Mock
    private TokenService tokenService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void testTokens() throws Exception {
        List<Token> tokens = generateTokens();

        when(tokenService.findAll()).thenReturn(tokens);

        assertThat(tokenController.tokens(), is(tokens));
    }

    private List<Token> generateTokens() {
        List<Token> tokens = new ArrayList<>();
        Token token = new Token();
        token.category="A Category";
        token.value="A Value";
        tokens.add(token);
        return tokens;
    }

    @Test
    public void testCreateTokensFromJson() throws Exception {
        tokenController.createTokensFromJson(JSON);

        verify(tokenService).createFromJson(JSON);
    }
}