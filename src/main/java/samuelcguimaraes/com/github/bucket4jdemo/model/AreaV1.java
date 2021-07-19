package samuelcguimaraes.com.github.bucket4jdemo.model;

public class AreaV1 {
	
	private final String shape;
	private final Double area;
	
	public AreaV1(String shape, Double area) {
		this.shape = shape;
		this.area = area;
	}
	
	public String getShape() {
		return shape;
	}
	
	public Double getArea() {
		return area;
	}
	
	@Override
	public String toString() {
		return "AreaV1{" +
		       "shape='" + shape + '\'' +
		       ", area=" + area +
		       '}';
	}
}
