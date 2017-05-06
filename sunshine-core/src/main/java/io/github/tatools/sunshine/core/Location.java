package io.github.tatools.sunshine.core;

import java.util.List;

/**
 * The interface declares a place to search tests classes.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @see LocationException
 * @since 16.03.2017
 */
public interface Location {

    /**
     * Returns a list of files paths. Any implementation has to support recursive search by defined place.
     *
     * @return a list of paths
     */
    List<FsPath> files();


    class Fake implements Location {
        private final List<FsPath> files;

        Fake(List<FsPath> files) {
            this.files = files;
        }

        @Override
        public List<FsPath> files() {
            return files;
        }
    }
}
