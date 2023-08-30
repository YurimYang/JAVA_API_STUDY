package org.example.model;

//JPA Repository

import java.util.List;

public interface BookRepository {
    public int bookDelete(int num);
    public List<Book> getLikeBooks(String search);
}
