package com.taiyangguo.aspectLog;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class ApplicationTests {

	@Test
	void contextLoads() {
		log.info("[Test junit success]");
	}

}
