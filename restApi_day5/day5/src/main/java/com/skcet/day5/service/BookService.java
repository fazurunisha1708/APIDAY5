package com.skcet.day5.service;



import java.util.List;


import com.skcet.day5.model.Book;

public interface BookService {
   public boolean addValues(Book b);
   List<Book> getValues();
   boolean updateValues(int id,Book b);
public boolean deleteValues(int id);
}
