package cinema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ticket {
    private String token;
    @JsonProperty("ticket")
    private Seat seat;

    public Ticket(Seat ticket) {
        this.token =  new Token().getToken();
        this.seat = ticket;
    }

    public Ticket() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
