package uk.co.dashery.controller;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.co.dashery.TestDasheryAutocompleteConfig;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static uk.co.dashery.TokenTestUtils.getTestJson;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDasheryAutocompleteConfig.class)
public class TokenControllerIT {
    @Inject
    private MongoTemplate mongoTemplate;

    @Inject
    private TokenController tokenController;

    @After
    public void tearDown() {
        mongoTemplate.getDb().dropDatabase();
    }

    @Test
    public void testDoesNotDuplicateExistingTokens() {
        tokenController.createTokensFromJson(getTestJson("Kylo", "Ren"));
        tokenController.createTokensFromJson(getTestJson("Kylo", "Ren"));

        assertThat(tokenController.tokens().size(), is(2));
    }
}
