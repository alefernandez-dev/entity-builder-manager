package dev.alejandro;

public final class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private final String editorial;

    private Book(String isbn, String title, String author, String editorial) {

        validate(isbn, title, author);

        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getEditorial() {
        return editorial;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", editorial='" + editorial + '\'' +
                '}';
    }

    private void validate(String isbn, String title, String author) {

        if(isbn != null) {
            if(isbn.isBlank()) {
                throw DomainException.message("ISBN must not be empty");
            }
            if(isbn.length() > 13) {
                throw DomainException.message("ISBN must be less than 13 characters");
            }
        }else {
            throw DomainException.message("ISBN must not be null");
        }

        if(title != null) {
            if(title.isBlank()) {
                throw DomainException.message("TITLE must not be empty");
            }
            if(title.length() > 100) {
                throw DomainException.message("TITLE must be less than 100 characters");
            }
        }else {
            throw DomainException.message("TITLE must not be null");
        }

        if(author != null) {
            if(author.isBlank()) {
                throw DomainException.message("AUTHOR must not be empty");
            }
            if(author.length() > 100) {
                throw DomainException.message("AUTHOR must be less than 100 characters");
            }
        }else {
            throw DomainException.message("AUTHOR must not be null");
        }
    }

    public static class UpdateBuilder {
        private final String isbn;
        private String title;
        private String author;
        private String editorial;

        private UpdateBuilder(Book book) {
            this.isbn = book.getIsbn();
            this.title = book.getTitle();
            this.author = book.getAuthor();
            this.editorial = book.getEditorial();
        }

        public static UpdateBuilder from(Book book) {
            return new UpdateBuilder(book);
        }

        public UpdateBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public UpdateBuilder withAuthor(String author) {
            this.author = author;
            return this;
        }

        public UpdateBuilder withEditorial(String editorial) {
            this.editorial = editorial;
            return this;
        }

        public Book update() {

            return new Book(isbn, title, author, editorial);

        }
    }

    public static class CreateBuilder {
        private final String isbn;
        private final String title;
        private final String author;
        private String editorial;

        private CreateBuilder(String isbn, String title, String author) {
            this.isbn = isbn;
            this.title = title;
            this.author = author;
        }

        public static CreateBuilder create(String isbn, String title, String author) {
            return new CreateBuilder(isbn, title, author);
        }

        public CreateBuilder withEditorial(String editorial) {
            this.editorial = editorial;
            return this;
        }

        public Book create() {

            return new Book(isbn, title, author, editorial);

        }
    }
}
