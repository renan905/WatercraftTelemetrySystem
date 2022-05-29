package WatercraftTelemetrySystem.Database;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ext.*;

public class DatabaseConnection {
    static private final String DB4OFILENAME  = "WatercraftTelemetrySystemDatabase";
    private ObjectContainer Database;

    public ObjectContainer getDatabase() {
        if (Database == null) {
            openConnection();
        }
        return Database;
    }
    public void closeDatabaseConnection() {
        closeConnection();
    }

    private void openConnection() {
        try {
            Database = Db4oEmbedded.openFile(DB4OFILENAME);
        } catch (Db4oIOException e) {
            throw new RuntimeException(e);
        }
    }

    private void closeConnection() {
        try {
            Database.close();
        } catch (Db4oIOException e) {
            throw new RuntimeException(e);
        }
    }
}
