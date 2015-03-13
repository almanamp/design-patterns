package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import models.AuditLogItemVisitor;
import models.Chair;
import models.Door;
import models.Room;
import models.StatisticsItemVisitor;
import models.Window;

public class Main {

	public static void main(String[] args) throws ParseException, InterruptedException {
		Room room = new Room();
		room.add(new Door());
		room.add(new Chair());
		room.add(new Window());

		Thread.sleep(200l);
		Window modifiedWindow = new Window();
		Chair modifiedChair = new Chair();
		Door modifiedDoor = new Door();
		Thread.sleep(900l);
		modifiedWindow.setModified(new Date());
		modifiedChair.setModified(new Date());
		modifiedDoor.setModified(new Date());
		room.add(modifiedWindow);
		room.add(modifiedChair);
		room.add(modifiedDoor);

		System.out.println("\nTESTING AuditLogItemVisitor...");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date startDate = dateFormat.parse("2015/03/12 00:00:00");
		AuditLogItemVisitor auditLogItemVisitor = new AuditLogItemVisitor();
		room.accept(auditLogItemVisitor);
		auditLogItemVisitor.run(startDate);
		auditLogItemVisitor.print();

		System.out.println("\nTESTING AuditLogItemVisitor...");
		StatisticsItemVisitor statisticsItemVisitor = new StatisticsItemVisitor();
		room.accept(statisticsItemVisitor);
		statisticsItemVisitor.print();
	}

}
