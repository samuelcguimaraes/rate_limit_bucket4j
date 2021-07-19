package samuelcguimaraes.com.github.bucket4jdemo.util;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Refill;

import java.time.Duration;

public enum PricingPlan {
	FREE {
		public Bandwidth getLimit() {
			return Bandwidth.classic(10, Refill.intervally(10, Duration.ofMinutes(1)));
		}
	},
	BASIC {
		public Bandwidth getLimit() {
			return Bandwidth.classic(20, Refill.intervally(20, Duration.ofMinutes(1)));
		}
	},
	PROFESSIONAL {
		public Bandwidth getLimit() {
			return Bandwidth.classic(50, Refill.intervally(50, Duration.ofMinutes(1)));
		}
	};
	
	static PricingPlan resolvePlanFromApiKey(String apiKey) {
		if (apiKey == null || apiKey.isEmpty()) {
			return FREE;
		} else if (apiKey.startsWith("PX001-")) {
			return PROFESSIONAL;
		} else if (apiKey.startsWith("BX001-")) {
			return BASIC;
		}
		return FREE;
	}
	
	public abstract Bandwidth getLimit();
}
