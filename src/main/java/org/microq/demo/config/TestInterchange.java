package org.microq.demo.config;

import org.microq.support.auditor.Interchange;
import org.springframework.context.annotation.ComponentScan;


public class TestInterchange extends Interchange {
    @Override
    protected String interchangeName() {
        return "Test-Interchange";
    }
}
