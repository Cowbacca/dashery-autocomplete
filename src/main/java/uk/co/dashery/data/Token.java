package uk.co.dashery.data;

import org.springframework.data.annotation.Id;

public class Token {

    @Id
    private String id;
    public String category;
    public String value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Token token = (Token) o;

        if (id != null ? !id.equals(token.id) : token.id != null) return false;
        if (category != null ? !category.equals(token.category) : token.category != null) return false;
        return !(value != null ? !value.equals(token.value) : token.value != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
