package uk.co.dashery.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import uk.co.dashery.Token;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class TokenJsonParser {
    public List<Token> parse(String json) {
        Gson gson = new Gson();
        List<Token> tokens = new ArrayList<>();
        LinkedHashMap[] tokenSets = gson.fromJson(json, LinkedHashMap[].class);
        for (LinkedHashMap<String, String> tokenSet : tokenSets) {
            for (Map.Entry<String, String> tokenEntry : tokenSet.entrySet()) {
                Token token = new Token();
                token.category = tokenEntry.getKey();
                token.value = tokenEntry.getValue();
                tokens.add(token);
            }
        }

        return tokens;
    }
}
