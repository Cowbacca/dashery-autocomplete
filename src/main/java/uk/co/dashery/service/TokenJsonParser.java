package uk.co.dashery.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.co.dashery.data.Token;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TokenJsonParser {

    @Autowired
    private Gson gson;

    public List<Token> parse(String json) {
        LinkedHashMap[] tokenSets = generateTokenSets(json);
        return Arrays.stream(tokenSets)
                .flatMap(tokenSet -> ((List<String>) tokenSet.get("tags")).stream())
                .map(tag -> new Token(tag))
                .collect(Collectors.toList());
    }

    private LinkedHashMap[] generateTokenSets(String json) {
        return gson.fromJson(json, LinkedHashMap[].class);
    }
}
