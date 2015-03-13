package models;

public class Chair extends Furniture {

	@Override
	public void accept(ItemVisitor visitor) {
		visitor.visit(this);
	}

}
