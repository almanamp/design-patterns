package models;

import java.util.ArrayList;
import java.util.List;

public class Room extends Structure {
	private List<Item> items = new ArrayList<>();

	public List<Item> getItems() {
		return items;
	}

	public void add(Item item) {
		items.add(item);
	}

	public void remove(Item item) {
		items.remove(item);
	}

	@Override
	public void accept(ItemVisitor visitor) {
		for (Item item : items) {
			item.accept(visitor);
		}
		visitor.visit(this);
	}
}
