package models;

public class Table extends Furniture {

	@Override
	public void accept(ItemVisitor visitor) {
		visitor.visit(this);
	}

}
