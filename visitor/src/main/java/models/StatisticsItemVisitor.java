package models;

import java.util.HashMap;
import java.util.Map;

public class StatisticsItemVisitor implements ItemVisitor {

	private Map<String, Integer> itemTypeToCountMap = new HashMap<>();

	@Override
	public void visit(Chair chair) {
		updateCount(chair);
	}

	@Override
	public void visit(Table table) {
		updateCount(table);
	}

	@Override
	public void visit(Window window) {
		updateCount(window);
	}

	@Override
	public void visit(Door door) {
		updateCount(door);
	}

	@Override
	public void visit(Room room) {
		// NO IMPLEMENTATION
	}

	@Override
	public void print() {
		// SAMPLE PRINT IMPLEMENTATION
		System.out.println("NUMBER OF ITEMS:");
		for (String itemType : itemTypeToCountMap.keySet()) {
			System.out.println(String.format("%s = %d", itemType, itemTypeToCountMap.get(itemType)));
		}
	}

	private void updateCount(Item item) {
		String itemType = item.getClass().getSimpleName();
		if (!itemTypeToCountMap.containsKey(itemType)) {
			itemTypeToCountMap.put(itemType, 1);
		} else {
			itemTypeToCountMap.put(itemType, itemTypeToCountMap.get(itemType) + 1);
		}
	}

	public Map<String, Integer> getItemTypeToCountMap() {
		return itemTypeToCountMap;
	}
}
