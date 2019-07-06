package hello;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class SimpleBookRepository {
	
	Map<Integer, Book> bookMap = new HashMap<>();
	
	public SimpleBookRepository() {
		bookMap.put(1, new Book(1, "Book One"));
		bookMap.put(2, new Book(2, "Book Two"));
		bookMap.put(3, new Book(3, "Book Three"));
		bookMap.put(4, new Book(4, "Book Four"));
		bookMap.put(5, new Book(5, "Book Five"));
		bookMap.put(6, new Book(6, "Book Six"));
		bookMap.put(7, new Book(7, "Book Seven"));
	}

    @Cacheable("books")
    public Book getByIsbn(int isbn) {
    	simulateSlowService(); 
        return bookMap.get(isbn);
    }
    
    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }    
}