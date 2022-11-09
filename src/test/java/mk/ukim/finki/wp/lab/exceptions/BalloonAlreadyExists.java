package mk.ukim.finki.wp.lab.exceptions;

public class BalloonAlreadyExists extends RuntimeException{
    public BalloonAlreadyExists() {
        super("Balloon already exists!");
    }
}