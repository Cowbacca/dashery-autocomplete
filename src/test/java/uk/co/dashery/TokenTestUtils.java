package uk.co.dashery;


import com.google.common.collect.Lists;
import uk.co.dashery.data.Token;

import java.util.List;

public class TokenTestUtils {

    public static List<Token> generateTokens() {
        return Lists.newArrayList(new Token("A Value"));
    }

    public static String getTestJson(String value, String anotherValue) {
        return String.format("[{\"tags\": [\"%s\",\"%s\"]}]", value, anotherValue);
    }
}
