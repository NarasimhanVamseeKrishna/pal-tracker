package io.pivotal.pal.tracker;

import java.util.*;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private long id = 1;
    private Map<Long, TimeEntry> inMemoryDb = new HashMap<>();

    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry entry =  new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        inMemoryDb.put(id, entry);
        incrementId();
        return entry;
    }

    public TimeEntry find(long timeEntryId) {
        return inMemoryDb.get(timeEntryId);
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        if (!inMemoryDb.containsKey(id)) return null;
        TimeEntry entry =  new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        inMemoryDb.put(id , entry);
        return entry;
    }

    public List<TimeEntry> list() {
        List<TimeEntry> timeEntries = new ArrayList(inMemoryDb.values());
        return timeEntries;
    }

    public void delete(long id) {
        if (inMemoryDb.containsKey(id)) inMemoryDb.remove(id);
    }

    private void incrementId() {
        id++;
    }
}
