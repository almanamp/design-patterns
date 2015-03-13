package models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class AuditLogItemVisitor implements ItemVisitor {

	private List<Item> items = new ArrayList<>();
	private List<Item> newItems = new ArrayList<>();
	private List<Item> modifiedItems = new ArrayList<>();
	private Date previousRunDate;

	@Override
	public void visit(Chair chair) {
		items.add(chair);
	}

	@Override
	public void visit(Table table) {
		items.add(table);

	}

	@Override
	public void visit(Window window) {
		items.add(window);
	}

	@Override
	public void visit(Door door) {
		items.add(door);

	}

	@Override
	public void visit(Room room) {
		// NO IMPLEMENTATION
	}

	@Override
	public void print() {
		// SAMPLE PRINT IMPLEMENTATION
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
		System.out.println(String.format("FOLLOWING ITEMS HAVE BEEN ADDED ON %s:", dateFormat.format(previousRunDate)));
		for (Item newItem : newItems) {
			System.out.println(String.format("%s on %s", newItem.getClass().getSimpleName(), dateFormat.format(newItem.created)));
		}

		System.out.println();
		System.out.println(String.format("FOLLOWING ITEMS HAVE BEEN MODIFIED ON %s:", dateFormat.format(previousRunDate)));
		for (Item modifiedItem : modifiedItems) {
			System.out.println(String.format("%s on %s", modifiedItem.getClass().getSimpleName(), dateFormat.format(modifiedItem.modified)));
		}
	}

	public void run(Date startDate) {
		previousRunDate = startDate;
		for (Item item : items) {
			if (item.created.compareTo(startDate) >= 0) {
				newItems.add(item);
			}
			if (item.modified.compareTo(item.created) > 0 && item.modified.compareTo(startDate) >= 0) {
				modifiedItems.add(item);
			}
		}
		Collections.sort(newItems);
		Collections.sort(modifiedItems);
	}

	public List<Item> getItems() {
		return items;
	}

	public List<Item> getNewItems() {
		return newItems;
	}

	public List<Item> getModifiedItems() {
		return modifiedItems;
	}

}
