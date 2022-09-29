package cinema;

import java.util.UUID;

public class Token {
    private String token;

    public Token() {
        this.token = UUID.randomUUID().toString();
    }

    public Token(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token=" + token +
                '}';
    }
}
