package task2;

import java.util.Arrays;
import java.util.Comparator;

public class Order {
	private OrderItem[] items;

	public Order(OrderItem[] items) {
		super();
		this.items = items;
	}

	// using binary search approach
	public boolean contains(Product p) {
		OrderItem[] newItem = sort(items);
		int left = 0;
		int right = newItem.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			int comparison = newItem[mid].getId().compareTo(p.getId());
			if (comparison == 0) {
				return true;
			} else if (comparison < 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}
	public OrderItem[] sort(OrderItem[] items) {
		Arrays.sort(items, Comparator.comparing(item -> item.getId()));
		return items;
	}

	// get all products based on the given type using linear search

	public Product[] filter(String type) {
		int count = 0;
		for (int i = 0; i < items.length; i++) {
			if (items[i].getType().equals(type)) {
				count++;
			}
		}
		Product[] result = new Product[count];
		int index = 0;
		for (int i = 0; i < items.length; i++) {
			if (items[i].getType().equals(type)) {
				result[index++] = items[i].getP();
			}
		}
		return result;
	}

	public double cost() {
		double cost = 0.0;
		for (int i = 0; i < items.length; i++) {
			cost += items[i].getPrice();
		}
		return cost;
	}

	public static void main(String[] args) {
		Product p1 = new Product("0001", "CoCa", 12000, "Vip");
		Product p2 = new Product("0002", "Pepsi", 10000, "Trung");
		Product p3 = new Product("0003", "Suoi", 15000, "Thuong");
		Product p4 = new Product("0004", "7up", 20000, "Vip");
		Product p5 = new Product("0005", "me", 11000, "Thuong");

		OrderItem o1 = new OrderItem(p1, 2);
		OrderItem o2 = new OrderItem(p2, 2);
		OrderItem o3 = new OrderItem(p3, 2);
		OrderItem o4 = new OrderItem(p4, 2);

		OrderItem[] l1 = { o1, o2, o3, o4 };

		Order m1 = new Order(l1);

		System.out.println("Cost: " + m1.cost());
		System.out.println("contains: " + m1.contains(p2));
		System.out.println("contains: " + m1.contains(p5));
		System.out.println("filter: " + Arrays.toString(m1.filter("Vip")));

	}
}
