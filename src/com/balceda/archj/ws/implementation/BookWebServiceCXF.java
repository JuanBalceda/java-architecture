package com.balceda.archj.ws.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balceda.archj.model.Book;
import com.balceda.archj.service.interfaces.BookService;
import com.balceda.archj.ws.interfaces.GenericWebService;
import com.balceda.archj.ws.model.BookDTO;

@Service
@WebService(endpointInterface = "com.balceda.archj.ws.interfaces.GenericWebService")
public class BookWebServiceCXF implements GenericWebService<BookDTO> {

	@Autowired
	private BookService bookService;

	@WebMethod
	public List<BookDTO> selectAll() {
		List<Book> books = getBookService().selectAll();
		List<BookDTO> list = new ArrayList<>();
		for (Book b : books) {
			BookDTO bookDTO = new BookDTO(b.getIsbn(), b.getTitle(), b.getCategory().getDescription());
			list.add(bookDTO);
		}
		return list;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

}
