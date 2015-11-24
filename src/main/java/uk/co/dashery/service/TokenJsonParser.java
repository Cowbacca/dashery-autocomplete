package uk.co.dashery.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.co.dashery.data.Token;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

@Component
public class TokenJsonParser {

    @Autowired
    private Gson gson;

    public List<Token> parse(String json) {
        List<Token> tokens = new ArrayList<>();
        LinkedHashMap[] tokenSets = generateTokenSets(json);
        for (LinkedHashMap<String, String> tokenSet : tokenSets) {
            tokens.addAll(tokenSet.entrySet().stream().map(this::generateTokenFromEntry).collect(Collectors.toList()));
        }
        return tokens;
    }

    private LinkedHashMap[] generateTokenSets(String json) {
        return gson.fromJson(json, LinkedHashMap[].class);
    }

    private Token generateTokenFromEntry(Entry<String, String> tokenEntry) {
        Token token = new Token();
        token.category = tokenEntry.getKey();
        token.value = tokenEntry.getValue();
        return token;
    }
}
