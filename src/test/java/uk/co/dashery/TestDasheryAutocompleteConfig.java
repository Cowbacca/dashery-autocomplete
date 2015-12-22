package uk.co.dashery;

import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@SpringBootApplication
public class TestDasheryAutocompleteConfig extends AbstractMongoConfiguration {
    @Override
    protected String getDatabaseName() {
        return "demo-test";
    }

    @Override
    public Mongo mongo() {
        return new Fongo("mongo-test").getMongo();
    }
}
