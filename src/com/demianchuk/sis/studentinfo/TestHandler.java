package com.demianchuk.sis.studentinfo;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 *
 * @author Nick
 */
public class TestHandler extends Handler {
    private LogRecord record;
    
    @Override
    public void flush() {}

    @Override
    public void close() {}

    @Override
    public void publish(LogRecord record) {
        this.record = record;
    }
    
    String getMessage(){
        return record.getMessage();
    }
}
