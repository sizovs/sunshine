package io.github.tatools.sunshine.core;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 21.04.2017
 */
public final class FilterableSuite implements SunshineSuite {

    private final SunshineSuite suite;
    private final Rule filter;

    public FilterableSuite(SunshineSuite suite, Rule filter) {
        this.suite = suite;
        this.filter = filter;
    }

    @Override
    public List<SunshineTest> tests() {
        return suite.tests().stream().filter(classTest -> classTest.match(filter)).collect(Collectors.toList());
    }
}