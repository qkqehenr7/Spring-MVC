package com.grepp.spring.app.model.book;

import static org.junit.jupiter.api.Assertions.*;

import com.grepp.spring.app.model.book.code.Category;
import com.grepp.spring.app.model.book.dto.Book;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {
    "file:src/main/webapp/WEB-INF/spring/root-context.xml",
    "file:src/main/webapp/WEB-INF/spring/servlet-context.xml"
})
@Slf4j
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    public void selectAll(){
        log.info("all books : {}", bookRepository.selectAll());
    }

    @Test
    public void selectByID(){
        log.info("book : {} ", bookRepository.selectById(1000));
    }

    @Test
    public void insert(){
        Book book = new Book();
        book.setCategory(Category.HUMANITY);
        book.setTitle("진리의 정당화");
        book.setAuthor("하버마스");
        book.setInfo("어려운 책입니다.");
        bookRepository.insert(book);
        log.info("book : {}", book);
    }

    @Test
    public void update(){
        Book book = new Book();
        book.setBkIdx(1005);
        book.setTitle("정의란 무엇인가");
        book.setAuthor("샌델");
        bookRepository.update(book);
        log.info("{}", bookRepository.update(book));
    }

    @Test
    public void delete(){
        log.info("{}", bookRepository.delete(1005));
    }

    @Test
    public void selectByTitle(){
        log.info("{}", bookRepository.selectByTitle("리"));
    }

    @Test
    public void rentRentBook(){
        log.info("{}", bookRepository.recentRentBook(3));
    }

    @Test
    @DisplayName("키워드를 사용해 제목 또는 작가 또는 상세검색")
    public void selectIf(){
        log.info("{}", bookRepository.selectByIf("title", "디디"));
    }

    @Test
    public void bulkInsert(){
        Book test = new Book(Category.HUMANITY, "테스트1", "테스터", "테스트 도서입니다.");
        Book test2 = new Book(Category.NOVEL, "테스트2", "테스터", "테스트 도서입니다.");
        bookRepository.bulkInsert(List.of(test, test2));
    }

    @Test
    public void selectDynamic(){
        log.info("{}", bookRepository.selectDynamic(List.of("remtable", "title"), "디디"));
    }


}