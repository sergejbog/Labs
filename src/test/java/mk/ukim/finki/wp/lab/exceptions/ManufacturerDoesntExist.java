package mk.ukim.finki.wp.lab.exceptions;

public class ManufacturerDoesntExist extends RuntimeException{
    public ManufacturerDoesntExist() {
        super("Manufacturer doesn't exist!");
    }
}