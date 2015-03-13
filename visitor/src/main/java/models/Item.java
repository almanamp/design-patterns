package models;

import java.util.Date;

public abstract class Item implements Comparable<Item> {
	Date created;
	Date modified;
	String createdBy;
	String modifiedBy;

	public Item() {
		created = new Date();
		modified = created;
	}

	public Item(String createdBy) {
		super();
		this.created = new Date();
		this.modified = created;
		this.createdBy = createdBy;
		this.modifiedBy = createdBy;
	}

	public abstract void accept(ItemVisitor visitor);

	@Override
	public int compareTo(Item o) {
		return (int) (modified.getTime() - o.modified.getTime());
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
}
