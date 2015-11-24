package uk.co.dashery;


import java.util.ArrayList;
import java.util.List;

public class TokenTestUtils {

    public static List<Token> generateTokens() {
        List<Token> tokens = new ArrayList<>();
        Token token = new Token();
        token.category="A Category";
        token.value="A Value";
        tokens.add(token);
        return tokens;
    }
}
