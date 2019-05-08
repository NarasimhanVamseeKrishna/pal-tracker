package io.pivotal.pal.tracker;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTimeEntryRepository implements TimeEntryRepository {
    private JdbcTemplate jdbcTemplate;

    public JdbcTimeEntryRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        KeyHolder holder = new GeneratedKeyHolder();
        timeEntry.setId(holder.getKey().longValue());
        jdbcTemplate.execute("INSERT INTO time_entries (id, project_id, user_id, date, hours) " +
                "VALUES (?, ?, ?, ?, ?)");
        return null;
    }

    @Override
    public TimeEntry find(long timeEntryId) {
        return null;
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        return null;
    }

    @Override
    public void delete(long timeEntryId) {

    }

    @Override
    public List<TimeEntry> list() {
        return null;
    }
}
