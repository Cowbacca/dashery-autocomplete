package uk.co.dashery;

import org.springframework.data.annotation.Id;

public class Token {

    @Id
    private String id;
    public String category;
    public String value;
}
