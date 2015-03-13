package models;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class AuditLogItemVisitorTest {
	AuditLogItemVisitor auditLogItemVisitor;

	@Before
	public void init() {
		auditLogItemVisitor = new AuditLogItemVisitor();
	}

	@Test
	public void visit_GivenItemsIsEmpty_WhenChairIsVisited_ThenItemsSizeShouldBe1() {
		Chair chair = new Chair();
		chair.accept(auditLogItemVisitor);
		assertEquals(1, auditLogItemVisitor.getItems().size());
	}

	@Test
	public void visit_GivenItemsIsEmpty_WhenTableIsVisited_ThenItemsSizeShouldBe1() {
		Table table = new Table();
		table.accept(auditLogItemVisitor);
		assertEquals(1, auditLogItemVisitor.getItems().size());
	}

	@Test
	public void visit_GivenItemsIsEmpty_WhenWindowIsVisited_ThenItemsSizeShouldBe1() {
		Window window = new Window();
		window.accept(auditLogItemVisitor);
		assertEquals(1, auditLogItemVisitor.getItems().size());
	}

	@Test
	public void visit_GivenItemsIsEmpty_WhenDoorIsVisited_ThenItemsSizeShouldBe1() {
		Door door = new Door();
		door.accept(auditLogItemVisitor);
		assertEquals(1, auditLogItemVisitor.getItems().size());
	}

	@Test
	public void visit_GivenRoomHas1Door_WhenRoomIsVisited_ThenItemsSizeShouldBe1() {
		Room room = new Room();
		room.add(new Door());
		room.accept(auditLogItemVisitor);
		assertEquals(1, auditLogItemVisitor.getItems().size());
	}

	@Test
	public void run_GivenItemsIsEmpty_WhenAddedItemsEquals3_ThenNewItemsListSizeShouldBe3() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date startDate = dateFormat.parse("2015/03/12 00:00:00");

		Room room = new Room();
		room.add(new Door());
		room.add(new Chair());
		room.add(new Window());
		room.accept(auditLogItemVisitor);

		auditLogItemVisitor.run(startDate);
		assertEquals(3, auditLogItemVisitor.getNewItems().size());
	}

	@Test
	public void run_GivenItemsIsEmpty_WhenModifiedItemsEquals3_ThenModifiedItemsListSizeShouldBe3() throws InterruptedException, ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date startDate = dateFormat.parse("2015/03/12 00:00:00");

		Window modifiedWindow = new Window();
		Chair modifiedChair = new Chair();
		Door modifiedDoor = new Door();
		Room room = new Room();
		room.add(modifiedWindow);
		room.add(modifiedChair);
		room.add(modifiedDoor);

		Thread.sleep(20l);

		modifiedWindow.setModified(new Date());
		modifiedChair.setModified(new Date());
		modifiedDoor.setModified(new Date());

		room.accept(auditLogItemVisitor);

		auditLogItemVisitor.run(startDate);
		assertEquals(3, auditLogItemVisitor.getModifiedItems().size());
	}
}
