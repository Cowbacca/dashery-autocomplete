package uk.co.dashery.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import uk.co.dashery.Token;
import uk.co.dashery.TokenRepository;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static uk.co.dashery.TokenTestUtils.generateTokens;

public class TokenServiceTest {

    @InjectMocks
    private TokenService tokenService;

    @Mock
    private TokenRepository tokenRepository;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void testCreateFromJson() throws Exception {

    }

    @Test
    public void testFindAll() throws Exception {
        List<Token> allTokens = generateTokens();
        when(tokenRepository.findAll()).thenReturn(allTokens);

        assertThat(tokenService.findAll(), is(allTokens));
    }
}