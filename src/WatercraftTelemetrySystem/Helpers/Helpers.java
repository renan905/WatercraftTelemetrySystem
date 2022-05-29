package WatercraftTelemetrySystem.Helpers;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Helpers {
	public static String getStringTimestamp() {
		Timestamp ts = Timestamp.valueOf(LocalDateTime.now());
		return ts.toString();
	}
}
