package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @RequestMapping(path = "/time-entries", method = RequestMethod.POST)
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {
        ResponseEntity<TimeEntry> result = new ResponseEntity(timeEntryRepository.create(timeEntryToCreate), HttpStatus.CREATED);
        return result;
    }

    @RequestMapping(path = "/time-entries/{timeEntryId}", method = RequestMethod.GET)
    public ResponseEntity<TimeEntry> read(@PathVariable long timeEntryId) {
        TimeEntry entry = timeEntryRepository.find(timeEntryId);
        if (null == entry) return new ResponseEntity(HttpStatus.NOT_FOUND);
        ResponseEntity<TimeEntry> result = new ResponseEntity(entry, HttpStatus.OK);
        return result;
    }

    @RequestMapping(path = "/time-entries/{timeEntryId}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable long timeEntryId, @RequestBody TimeEntry timeEntry) {
        TimeEntry updateEntry = timeEntryRepository.update(timeEntryId, timeEntry);
        if (null == updateEntry) return new ResponseEntity(HttpStatus.NOT_FOUND);
        ResponseEntity<TimeEntry> result = new ResponseEntity(updateEntry, HttpStatus.OK);
        return result;
    }

    @RequestMapping(path = "/time-entries/{timeEntryId}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable long timeEntryId) {
        timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(path = "/time-entries", method = RequestMethod.GET)
    public ResponseEntity<List<TimeEntry>> list() {
        ResponseEntity<List<TimeEntry>> result = new ResponseEntity(timeEntryRepository.list(), HttpStatus.OK);
        return result;
    }
}
