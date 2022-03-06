package general.domain;


import general.domain.valueObjects.LogId;
import kernel.Entity;

import java.util.Objects;

public final class Log implements Entity<LogId> {
    private final LogId logId;
    private final String message;

    private Log(LogId logId, String message) {
        this.logId = logId;
        this.message = message;
    }
    
    public static Log of(LogId logId, String message) {
        return Log.of(logId, message);
    }

    @Override
    public LogId id() {
        return logId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return Objects.equals(logId, log.logId) && Objects.equals(message, log.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logId, message);
    }

    @Override
    public String toString() {
        return "Log{" +
                "logid=" + logId +
                ", message='" + message + '\'' +
                '}';
    }
}
