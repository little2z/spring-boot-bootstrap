package com.xyl.web;

import com.xyl.persistence.model.Book;
import com.xyl.persistence.repo.BookRepository;
import com.xyl.web.exception.BookIdMismatchException;
import com.xyl.web.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    /**
     * 创建新的 book
     * @param book
     * @return
     */
    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    /**
     * 查询所有 book
     * @return
     */
    @GetMapping
    public Iterable<Book> findAll(){
        return bookRepository.findAll();
    }

    /**
     * 根据 id 查询 book
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id){
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    /**
     * 更新指定 book
     * @param book
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id){

        if(book.getId() != id){
            throw new BookIdMismatchException();
        }
        bookRepository.findById(id).orElseThrow(BookNotFoundException::new);

        return bookRepository.save(book);
    }

    /**
     * 删除指定 book
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){

        bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        bookRepository.deleteById(id);
    }

}
