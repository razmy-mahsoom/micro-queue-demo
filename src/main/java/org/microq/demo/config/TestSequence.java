package org.microq.demo.config;

import org.microq.support.auditor.Sequence;

public class TestSequence extends Sequence {
    @Override
    protected String sequenceName() {
        return "Default-Sequence";
    }
}
