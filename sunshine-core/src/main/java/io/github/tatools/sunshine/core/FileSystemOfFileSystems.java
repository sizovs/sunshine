package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@link FileSystemOfFileSystems} class allows to represent several fileSystems as an instance of
 * {@link FileSystem} interface.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
@EqualsAndHashCode
final class FileSystemOfFileSystems implements FileSystem {

    private final FileSystem[] fileSystems;

    FileSystemOfFileSystems(List<FileSystem> fileSystems) {
        this(fileSystems.toArray(new FileSystem[]{}));
    }

    FileSystemOfFileSystems(FileSystem... fileSystems) {
        this.fileSystems = fileSystems;
    }

    @Override
    public List<FsPath> files() throws FileSystemException {
        List<FsPath> files = new ArrayList<>();
        for (FileSystem fileSystem : fileSystems) {
            files.addAll(fileSystem.files());
        }
        return files;
    }
}