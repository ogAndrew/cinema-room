package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class SeatsController {
    public Cinema cinema = new Cinema();

    public List<Ticket> purchasedTickets = new ArrayList<>();

    @GetMapping("seats")
    public Cinema getSeats() {
        return this.cinema;
    }

    @PostMapping("purchase")
    public ResponseEntity purchaseSeat(@RequestBody Seat seat) {
        if (seat.getRow() < 1 || seat.getRow() > 9 || seat.getColumn() < 1 || seat.getColumn() > 9) {
            throw new SeatNotFoundException("The number of a row or a column is out of bounds!");
        }

        for (Seat s : cinema.getAvailable_seats()) {
            if (s.getRow() == seat.getRow() && s.getColumn() == seat.getColumn()) {
                List<Seat> cpSeats = cinema.getAvailable_seats();
                cpSeats.remove(s);
                Ticket ticket = new Ticket(s);
                purchasedTickets.add(ticket);
                cinema.setAvailable_seats(cpSeats);
                return ResponseEntity.ok(ticket);
            }
        }

        throw new SeatNotFoundException("The ticket has been already purchased!");
    }

    @PostMapping("return")
    public ResponseEntity returnTicket(@RequestBody Token token) {
        HashMap<String, Seat> refund = new HashMap<>();

        for (Ticket ticket : purchasedTickets) {
            String reqToken = token.getToken();
            String ticketToken = ticket.getToken();

            if (reqToken.equals(ticketToken)) {
                refund.put("returned_ticket", ticket.getSeat());
            }
        }

        if (!refund.containsKey("returned_ticket")) {
            throw new SeatNotFoundException("Wrong token!");
        }

        return ResponseEntity.ok(refund);
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SeatNotFoundException.class)
    public HashMap<String, String> handleException(SeatNotFoundException e) {
        HashMap<String, String> error = new HashMap<>();
        error.put("error", e.getMessage());
        return error;
    }

}