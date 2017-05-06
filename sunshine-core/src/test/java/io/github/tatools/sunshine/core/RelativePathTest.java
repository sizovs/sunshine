package io.github.tatools.sunshine.core;

import org.hamcrest.CustomTypeSafeMatcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public class RelativePathTest {

    @Test
    public void asStringForParentWithSlashInTheEnd() {
        MatcherAssert.assertThat(
                new RelativePath("/a/b/", "/a/b/c").path(),
                Matchers.is(new PathMatcher("c"))
        );
    }

    @Test
    public void asStringForParentWithoutSlashInTheEnd() {
        MatcherAssert.assertThat(
                new RelativePath("/a/b", "/a/b/c").path(),
                Matchers.is(new PathMatcher("c"))
        );
    }

    @Test
    public void asStringWhenParentIsEqualsToFull() {
        MatcherAssert.assertThat(
                new RelativePath("/a/b/c", "/a/b/c").path(),
                Matchers.is(new PathMatcher("/a/b/c"))
        );
    }

    @Test
    public void asStringForRelativeParentWithSlashInTheEnd() {
        MatcherAssert.assertThat(
                new RelativePath("a/b/", "a/b/c").path(),
                Matchers.is(new PathMatcher("c"))
        );
    }

    @Test
    public void asStringForRelativeParentWithoutSlashInTheEnd() {
        MatcherAssert.assertThat(
                new RelativePath("a/b", "a/b/c").path(),
                Matchers.is(new PathMatcher("c"))
        );
    }

    private final class PathMatcher extends CustomTypeSafeMatcher<Path> {

        private final String expected;

        PathMatcher(String expected) {
            super(expected);
            this.expected = expected;
        }

        @Override
        protected boolean matchesSafely(Path item) {
            return item.equals(Paths.get(expected));
        }
    }
}