package models;

public class Window extends Structure {

	@Override
	public void accept(ItemVisitor visitor) {
		visitor.visit(this);
	}

}
