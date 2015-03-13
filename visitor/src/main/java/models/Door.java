package models;

public class Door extends Structure {

	@Override
	public void accept(ItemVisitor visitor) {
		visitor.visit(this);
	}

}
