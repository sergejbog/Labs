package mk.ukim.finki.wp.lab.exceptions;

public class BalloonDoesntExistException extends RuntimeException{
    public BalloonDoesntExistException() {
        super("Balloon doesn't exist!");
    }
}