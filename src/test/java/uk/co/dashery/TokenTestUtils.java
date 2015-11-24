package uk.co.dashery;


import uk.co.dashery.data.Token;

import java.util.ArrayList;
import java.util.List;

public class TokenTestUtils {

    public static List<Token> generateTokens() {
        List<Token> tokens = new ArrayList<>();
        Token token = new Token();
        token.category = "A Category";
        token.value = "A Value";
        tokens.add(token);
        return tokens;
    }
}
