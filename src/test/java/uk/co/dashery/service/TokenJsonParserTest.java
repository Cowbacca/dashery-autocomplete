package uk.co.dashery.service;

import org.junit.Test;
import uk.co.dashery.Token;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class TokenJsonParserTest {

    @Test
    public void testParse() throws Exception {
        TokenJsonParser tokenJsonParser = new TokenJsonParser();

        List<Token> expectedTokens = new ArrayList<>();
        expectedTokens.add(generateToken("test key", "test value"));
        expectedTokens.add(generateToken("different key", "different value"));

        List<Token> parsedTokens = tokenJsonParser.parse("[{\"test key\": \"test value\"},{\"different key\": \"different value\"}]");

        assertThat(parsedTokens, is(expectedTokens));
    }

    private Token generateToken(String key, String value) {
        Token token = new Token();
        token.category = key;
        token.value = value;
        return token;
    }
}