package dev.alejandro;

public class DomainException extends RuntimeException{
    public DomainException(String message) {
        super(message);
    }

    public static DomainException message(String message) {
        return new DomainException(message);
    }
}
