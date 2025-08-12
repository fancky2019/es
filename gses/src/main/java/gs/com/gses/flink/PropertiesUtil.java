package gs.com.gses.flink;

import java.util.Properties;

public class PropertiesUtil {
    public static Properties createDebeziumProperties() {
        Properties props = new Properties();
        props.setProperty("database.history.skip.unparseable.ddl", "true");
        props.setProperty("schema.history.internal.store.only.captured.tables.ddl", "true");
        props.setProperty("include.schema.changes", "false");
        props.setProperty("database.history.file.filename", "/tmp/flink-dbhistory.dat");
        props.setProperty("snapshot.mode", "schema_only"); // 对于时间戳恢复很重要
        return props;
    }
}
