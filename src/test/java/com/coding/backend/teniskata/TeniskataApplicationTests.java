package com.coding.backend.teniskata;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features")
class TeniskataApplicationTests {

    @Test
    void contextLoads() {
    }

}
