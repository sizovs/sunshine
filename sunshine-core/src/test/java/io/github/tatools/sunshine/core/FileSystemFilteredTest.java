package io.github.tatools.sunshine.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Collections;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FileSystemFilteredTest {
    @Test
    public void files() throws FileSystemException {
        MatcherAssert.assertThat(
                new FileSystemFiltered(
                        new FileSystem.Fake(Collections.singletonList(new FileSystemPath.Fake())),
                        new Condition.Fake(false)
                ).files(),
                Matchers.hasSize(0)
        );
    }
}