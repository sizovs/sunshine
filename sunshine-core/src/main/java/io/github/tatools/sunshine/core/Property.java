package io.github.tatools.sunshine.core;

/**
 * The {@link Property} interface declares a contract to work with a property.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 21.04.2017
 */
public interface Property {
    /**
     * Allows to get a value of current property if it exists.
     *
     * @return a value of this property
     */
    String value();

    /**
     * Allows to check is this property set or not.
     *
     * @return <i>true</i> if this property exists otherwise <i>false</i>.
     */
    boolean present();
}
