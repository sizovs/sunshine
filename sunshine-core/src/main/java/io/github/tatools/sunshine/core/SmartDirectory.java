package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 19.04.2017
 */
@EqualsAndHashCode
public final class SmartDirectory implements Directory {

    private final Directory directory;

    public SmartDirectory(String path) {
        this(new RegularDirectory(path));
    }

    public SmartDirectory(Path path) {
        this(new RegularDirectory(path));
    }

    public SmartDirectory(Property property) {
        this(property.value());
    }


    public SmartDirectory(FsPath path) {
        this(new RegularDirectory(path));
    }

    public SmartDirectory(Directory directory) {
        this.directory = directory;
    }

    @Override
    public void create() throws IOException {
        if (!directory.exist()) {
            directory.create();
        }
    }

    @Override
    public void remove() throws IOException {
        if (directory.exist()) {
            directory.remove();
        }
    }

    @Override
    public boolean exist() {
        return directory.exist();
    }

    @Override
    public Path path() {
        return directory.path();
    }
}
