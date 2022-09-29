package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class SeatNotFoundException extends RuntimeException {
    public SeatNotFoundException(String cause) {
        super(cause);
    }
}
