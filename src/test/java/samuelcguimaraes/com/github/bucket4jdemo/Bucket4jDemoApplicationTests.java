package samuelcguimaraes.com.github.bucket4jdemo;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@SpringBootTest
class Bucket4jDemoApplicationTests {

	@Test
	void test1() {
		Refill refill = Refill.intervally(10, Duration.ofMinutes(1));
		Bandwidth limit = Bandwidth.classic(10, refill);
		Bucket bucket = Bucket4j.builder()
		                              .addLimit(limit)
		                              .build();
		
		for (int i = 1; i <= 10; i++) {
			assertTrue(bucket.tryConsume(1));
		}
		assertFalse(bucket.tryConsume(1));
	}
	
	@Test
	void test2() throws InterruptedException {
		Bandwidth limit = Bandwidth.classic(5, Refill.intervally(1, Duration.ofSeconds(2)));
		Bucket bucket = Bucket4j.builder()
		                              .addLimit(limit)
		                              .build();
		assertTrue(bucket.tryConsume(1));     // first request
		assertTrue(bucket.tryConsume(1));     // first request
		Thread.sleep(1000);
		
		assertTrue(bucket.tryConsume(1));     // first request
		
		System.out.println(bucket.getAvailableTokens());
		
		Thread.sleep(1000);
		System.out.println(bucket.getAvailableTokens());
		
		/*Executors.newScheduledThreadPool(1)   // schedule another request for 2 seconds later
		         .schedule(() -> assertTrue(bucket.tryConsume(5)), 2, TimeUnit.SECONDS);*/
	}

}
