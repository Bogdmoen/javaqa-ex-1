package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book book1 = new Book(1, "name", 150, "author1", 150, 2020);
    private Book book2 = new Book(2, "name", 150, "author1", 150, 2020);
    private Book book3 = new Book(3, "name", 150, "author1", 150, 2020);
    private Book book4 = new Book(4, "name", 150, "author1", 150, 2020);

    @Test
   public void shouldSaveOneItem() {
        repository.save(book1);

        Product[] expected = new  Product[] {book1};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCastFromBaseClass() {
        Product product = new Book();
        if (product instanceof Book) {
            Book book = (Book) product;

        }
    }


    @Test
        public void shouldRemoveById() {
            repository.save(book1);
            repository.save(book2);
            repository.save(book3);
            repository.save(book4);

            repository.removeById(4);

            Product[] expected = new Product[] {book1, book2, book3};
            Product[] actual = repository.findAll();

            assertArrayEquals(expected, actual);

        }


    @Test
    public void shouldHaveExceptionNonExistentId() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);

        assertThrows(NotFoundException.class, () -> repository.removeById(5) );
    }

}