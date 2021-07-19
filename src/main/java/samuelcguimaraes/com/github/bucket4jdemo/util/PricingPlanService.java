package samuelcguimaraes.com.github.bucket4jdemo.util;

import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class PricingPlanService {
	
	private final Map<String, Bucket> cache = new ConcurrentHashMap<>();
	
	public Bucket resolveBucket(String apiKey) {
		return cache.computeIfAbsent(apiKey, PricingPlanService::newBucket);
	}
	
	private static Bucket newBucket(String apiKey) {
		PricingPlan pricingPlan = PricingPlan.resolvePlanFromApiKey(apiKey);
		return Bucket4j.builder()
		               .addLimit(pricingPlan.getLimit())
		               .build();
	}

}
