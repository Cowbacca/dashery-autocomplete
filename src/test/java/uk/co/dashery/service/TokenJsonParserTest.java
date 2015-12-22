package uk.co.dashery.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.co.dashery.DasheryAutocompleteApplication;
import uk.co.dashery.data.Token;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;
import static uk.co.dashery.TokenTestUtils.getTestJson;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DasheryAutocompleteApplication.class)
public class TokenJsonParserTest {

    public static final String VALUE = "test value";
    public static final String ANOTHER_VALUE = "different value";
    @Autowired
    private TokenJsonParser tokenJsonParser;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void testParse() throws Exception {
        List<Token> expectedTokens = generateExpectedTokens();

        String json = getTestJson(VALUE, ANOTHER_VALUE);

        List<Token> parsedTokens = tokenJsonParser.parse(json);

        assertThat(parsedTokens, is(expectedTokens));
    }

    private List<Token> generateExpectedTokens() {
        List<Token> expectedTokens = new ArrayList<>();
        expectedTokens.add(new Token(VALUE));
        expectedTokens.add(new Token(ANOTHER_VALUE));
        return expectedTokens;
    }
}