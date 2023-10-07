package task2;

public class OrderItem {
	private Product p;
	private int quantity;

	public OrderItem(Product p, int quality) {
		super();
		this.p = p;
		this.quantity = quality;
	}
	public double getPrice() {
		return p.getPrice();
	}
	public String getId() {
		return p.getId();
	}
	public String getType() {
		return p.getType();
	}
	public Product getP() {
		return p;
	}
	@Override
	public String toString() {
		return "OrderItem [p=" + p + ", quantity=" + quantity + "]";
	}
}
