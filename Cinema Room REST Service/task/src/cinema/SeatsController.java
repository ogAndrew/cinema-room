package cinema;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeatsController {

    @GetMapping("seats")
    public Room getSeats() {
        Room room = new Room(9, 9);
        System.out.println(Room.class.getName());
        return room;
    }
}