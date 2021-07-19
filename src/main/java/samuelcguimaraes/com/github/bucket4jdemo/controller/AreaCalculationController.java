package samuelcguimaraes.com.github.bucket4jdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import samuelcguimaraes.com.github.bucket4jdemo.model.AreaV1;
import samuelcguimaraes.com.github.bucket4jdemo.model.RectangleDimensionsV1;
import samuelcguimaraes.com.github.bucket4jdemo.model.TriangleDimensionsV1;

@RestController
public class AreaCalculationController {
	
	@PostMapping(value = "/api/v1/area/rectangle")
	public static ResponseEntity<AreaV1> rectangle(@RequestBody RectangleDimensionsV1 dimensions) {
		return ResponseEntity.ok(new AreaV1("rectangle", dimensions.getLength() * dimensions.getWidth()));
	}
	
	@PostMapping(value = "/api/v1/area/triangle")
	public static ResponseEntity<AreaV1> triangle(@RequestBody TriangleDimensionsV1 dimensions) {
		return ResponseEntity.ok(new AreaV1("triangle", 0.5d * dimensions.getHeight() * dimensions.getBase()));
	}
}
