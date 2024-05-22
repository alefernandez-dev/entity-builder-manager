package dev.alejandro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void createAndUpdateBook() {
        var cleanCode = Book.CreateBuilder.create("1234563512367", "Clean Code", "Robert C. Martin")
                .create();

        assertEquals("Robert C. Martin", cleanCode.getAuthor());
        assertEquals("Clean Code", cleanCode.getTitle());
        assertNull(cleanCode.getEditorial());

        var updatedCleanCode = Book.UpdateBuilder.from(cleanCode)
                .withAuthor("Uncle Bob")
                .withEditorial("Anaya")
                .update();

        assertEquals(cleanCode.getIsbn(), updatedCleanCode.getIsbn());
        assertEquals("Clean Code", updatedCleanCode.getTitle());
        assertEquals("Uncle Bob", updatedCleanCode.getAuthor());
        assertEquals("Anaya", updatedCleanCode.getEditorial());
    }

    @Test
    void createBookThrowsException() {

        var e = assertThrowsExactly(DomainException.class, () -> Book.CreateBuilder.create(null, "Clean Code", "Robert C. Martin")
                .create());
        assertTrue(e.getMessage().contains("not be null"));

    }

}