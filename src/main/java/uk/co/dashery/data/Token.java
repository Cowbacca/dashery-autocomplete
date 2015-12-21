package uk.co.dashery.data;

import org.springframework.data.annotation.Id;

public class Token {

    @Id
    private String id;
    private String value;

    public Token() {
    }

    public Token(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Token token = (Token) o;

        return !(value != null ? !value.equals(token.value) : token.value != null);

    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
