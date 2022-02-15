package me.syp.demospringdi;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class SnackServiceTest {

    @Autowired SnackService snackService;

    @Test
    public void di() {
        // Service가 Null이 아니다.
        Assert.assertNotNull(snackService);
        Assert.assertNotNull(snackService.snackRepository);
    }

}