package models;

public interface ItemVisitor {
	void visit(Chair chair);

	void visit(Table table);

	void visit(Window window);

	void visit(Door door);

	void visit(Room room);

	void print();
}
