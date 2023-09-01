package com.skcet.day5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcet.day5.model.Book;
import com.skcet.day5.repository.BookRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class BookServiceImpl implements BookService{
	@Autowired
     private BookRepository bookRepo;

	@Override
	public boolean addValues(Book b) {
		// TODO Auto-generated method stub
		boolean idExist=bookRepo.existsById(b.getId());
		if(!idExist)
		{
			bookRepo.save(b);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public List<Book> getValues() {
		// TODO Auto-generated method stub
		return bookRepo.findAll();
	}

	@Override
	public boolean updateValues(int id, Book b) {
		Optional<Book> existBook=bookRepo.findById(id);
		if(existBook.isPresent())
		{
			Book bookExists = existBook.get();
			bookExists.setAuthorName(b.getAuthorName());
			bookExists.setBookName(b.getBookName());
			bookExists.setPrive(b.getPrive());
			bookExists.setQuantity(b.getQuantity());
			bookRepo.save(bookExists);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean deleteValues(int id) {
		// TODO Auto-generated method stub
		Optional<Book> existingUserOptional=bookRepo.findById(id);
		if(existingUserOptional.isPresent())
		{
			bookRepo.deleteById(id);
			return true;
		}
		else
		return false;
	}




	
	
     
}
