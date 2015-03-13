package models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StatisticsItemVisitorTest {
	StatisticsItemVisitor statisticsItemVisitor;

	@Before
	public void init() {
		statisticsItemVisitor = new StatisticsItemVisitor();
	}

	@Test
	public void visit_GivenItemTypeToCountMapIsEmpty_WhenChairIsVisited_ThenMapShouldOnlyContain1KeyAndCountValueShouldBe1() {
		Chair chair = new Chair();
		chair.accept(statisticsItemVisitor);
		int chairCount = statisticsItemVisitor.getItemTypeToCountMap().get("Chair");
		assertEquals(1, chairCount);
	}

	@Test
	public void visit_GivenItemTypeToCountMapIsEmpty_WhenTableIsVisited_ThenMapShouldOnlyContain1KeyAndCountValueShouldBe1() {
		Table table = new Table();
		table.accept(statisticsItemVisitor);
		int tableCount = statisticsItemVisitor.getItemTypeToCountMap().get("Table");
		assertEquals(1, tableCount);
	}

	@Test
	public void visit_GivenItemTypeToCountMapIsEmpty_WhenWindowIsVisited_ThenMapShouldOnlyContain1KeyAndCountValueShouldBe1() {
		Window window = new Window();
		window.accept(statisticsItemVisitor);
		int windowCount = statisticsItemVisitor.getItemTypeToCountMap().get("Window");
		assertEquals(1, windowCount);
	}

	@Test
	public void visit_GivenItemTypeToCountMapIsEmpty_WhenDoorIsVisited_ThenMapShouldOnlyContain1KeyAndCountValueShouldBe1() {
		Door door = new Door();
		door.accept(statisticsItemVisitor);
		int doorCount = statisticsItemVisitor.getItemTypeToCountMap().get("Door");
		assertEquals(1, doorCount);
	}

	@Test
	public void visit_GivenItemTypeToCountMapIsEmptyAndRoomHas1Door_WhenRoomIsVisited_ThenMapShouldOnlyContain1KeyAndCountValueShouldBe1() {
		Room room = new Room();
		room.add(new Door());
		room.accept(statisticsItemVisitor);
		int roomCount = statisticsItemVisitor.getItemTypeToCountMap().get("Door");
		assertEquals(1, roomCount);
	}

	@Test
	public void visit_GivenItemTypeToCountMapHas1Chair_WhenChairIsVisited_ThenMapShouldOnlyContain1KeyAndCountValueShouldBe2() {
		Chair chair1 = new Chair();
		Chair chair2 = new Chair();
		chair1.accept(statisticsItemVisitor);
		chair2.accept(statisticsItemVisitor);
		int chairCount = statisticsItemVisitor.getItemTypeToCountMap().get("Chair");
		assertEquals(2, chairCount);
	}

	@Test
	public void visit_GivenItemTypeToCountMapHas1Table_WhenTableIsVisited_ThenMapShouldOnlyContain1KeyAndCountValueShouldBe2() {
		Table table1 = new Table();
		Table table2 = new Table();
		table1.accept(statisticsItemVisitor);
		table2.accept(statisticsItemVisitor);

		int tableCount = statisticsItemVisitor.getItemTypeToCountMap().get("Table");
		assertEquals(2, tableCount);
	}

	@Test
	public void visit_GivenItemTypeToCountMapHas1Window_WhenWindowIsVisited_ThenMapShouldOnlyContain1KeyAndCountValueShouldBe2() {
		Window window1 = new Window();
		Window window2 = new Window();
		window1.accept(statisticsItemVisitor);
		window2.accept(statisticsItemVisitor);

		int windowCount = statisticsItemVisitor.getItemTypeToCountMap().get("Window");
		assertEquals(2, windowCount);
	}

	@Test
	public void visit_GivenItemTypeToCountMapHas1Door_WhenDoorIsVisited_ThenMapShouldOnlyContain1KeyAndCountValueShouldBe2() {
		Door door1 = new Door();
		Door door2 = new Door();
		door1.accept(statisticsItemVisitor);
		door2.accept(statisticsItemVisitor);
		int doorCount = statisticsItemVisitor.getItemTypeToCountMap().get("Door");
		assertEquals(2, doorCount);
	}

	@Test
	public void visit_GivenItemTypeToCountMapIsEmptyAndRoomHas2Doors_WhenRoomIsVisited_ThenMapShouldOnlyContain1KeyAndCountValueShouldBe2() {
		Room room = new Room();
		room.add(new Door());
		room.add(new Door());
		room.accept(statisticsItemVisitor);
		int roomCount = statisticsItemVisitor.getItemTypeToCountMap().get("Door");
		assertEquals(2, roomCount);
	}

	@Test
	public void getItemTypeToCountMap_GivenRoomIsEmpty_When2ItemsOfTheSameKindAreAdded_ThenMapShouldOnlyContain1KeyAndCountValueShouldBe2() {
		Room room = new Room();
		room.add(new Door());
		room.add(new Door());
		room.accept(statisticsItemVisitor);
		assertEquals(1, statisticsItemVisitor.getItemTypeToCountMap().size());

		int doorCount = statisticsItemVisitor.getItemTypeToCountMap().get("Door");
		assertEquals(2, doorCount);
	}
}
