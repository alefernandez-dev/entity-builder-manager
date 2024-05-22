package dev.alejandro;

public class App
{
    public static void main( String[] args )
    {

        var cleanCode = Book.CreateBuilder.create("1234563512367", "Clean Code", "Robert C. Martin")
                .create();

        var pragmaticProgrammer = Book.CreateBuilder.create("1543678944567", "The Pragmatic Programmer", "A. Hunt, D. Thomas")
                .withEditorial("Some Editorial")
                .create();

        System.out.println("\n--- Created books ---");

        System.out.println(cleanCode); //print Book{isbn='1234563512367', title='Clean Code', author='Robert C. Martin', editorial='null'}

        System.out.println(pragmaticProgrammer); // print Book{isbn='1543678944567', title='The Pragmatic Programmer', author='A. Hunt, D. Thomas', editorial='Some Editorial'}

        var updatedCleanCode = Book.UpdateBuilder.from(cleanCode)
                .withAuthor("Uncle Bob")
                .withEditorial("Anaya")
                .update();

        System.out.println("\n--- Updated book ---");

        System.out.println(updatedCleanCode); // print Book{isbn='1234563512367', title='Clean Code', author='Uncle Bob', editorial='Anaya'}
    }
}
