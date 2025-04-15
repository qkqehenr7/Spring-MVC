package com.grepp.spring.app.model.rent;

import com.grepp.spring.app.model.rent.dto.Rent;
import com.grepp.spring.app.model.rent.dto.RentBook;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations={
    "file:src/main/webapp/WEB-INF/spring/root-context.xml",
    "file:src/main/webapp/WEB-INF/spring/servlet-context.xml"
})
@Slf4j
class RentRepositoryTest {

    @Autowired
    private RentService rentService;
    @Autowired
    private RentRepository rentRepository;

    @Test
    public void selectAll(){
        List<Rent> rents = rentService.selectAll();
        rents.forEach(System.out::println);
    }

    @Test
    public void selectRentBookByRentId() {
        List<RentBook> rents = rentService.selectRentBookByRentId(100001);
        rents.forEach(System.out::println);
    }

}