package site.persipa.bark.converter;

import com.fasterxml.jackson.databind.util.StdConverter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author persipa
 */
public class TimeStampConverter extends StdConverter<Long, LocalDateTime> {

    @Override
    public LocalDateTime convert(Long value) {
        if (value == null) return null;
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(value), ZoneId.systemDefault());
    }
}
