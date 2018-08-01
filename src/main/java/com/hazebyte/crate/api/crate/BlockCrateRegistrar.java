package com.hazebyte.crate.api.crate;

import org.bukkit.Location;

import java.util.List;

/**
 * Contain methods used to retrieve and manipulate location based crates.
 */
public interface BlockCrateRegistrar {

    /**
     * {@code save} defaults to {@code true}.
     *
     * @see BlockCrateRegistrar#setCrate(Location, Crate, boolean)
     */
    boolean setCrate(Location location, Crate crate);

    /**
     * Sets a location to listen for crate events. This activates holograms
     * and starts effects.
     *
     * @param location the location to activate events for
     * @param crate the crate that handles the events
     * @param save true to save to file storage, otherwise false.
     * @return true if the crate is set, otherwise false.
     */
    boolean setCrate(Location location, Crate crate, boolean save);

    /**
     * {@code save} defaults to {@code true}
     *
     * @see BlockCrateRegistrar#removeCrate(Location, Crate, boolean)
     */
    boolean removeCrate(Location location, Crate crate);

    /**
     * Removes a location from listening for crate events. This removes
     * holograms and effects.
     *
     * @param location the location that has a listener
     * @param crate the crate that is handling events
     * @param save  true to save to file storage, otherwise false
     * @return true if the crate is removed, otherwise false
     */
    boolean removeCrate(Location location, Crate crate, boolean save);

    /**
     * Saves the list of block crates to a file storage.
     * @return true if written, otherwise false
     */
    boolean save();

    /**
     * Returns the crate if it exists at the location.
     *
     * @param location the location where the crate is at.
     * @param crate the crate to search for
     * @return the crate if it exists, otherwise null
     */
    Crate getCrate(Location location, Crate crate);

    /**
     * Returns the crate with the crate name at the location.
     *
     * @param location the location where the crate is at.
     * @param crateName the crate name to search for
     * @return the crate if the crate name matches a crate, otherwise false.
     */
    Crate getCrate(Location location, String crateName);

    /**
     * Returns the list of crates at a given location.
     *
     * @param location the location to search for
     * @return a non-null list of crates. If there are no crates,
     * it'll return the null.
     */
    List<Crate> getCrates(Location location);

    /**
     * Returns the first crate, if it exists, at the location.
     *
     * @param location the location to search for.
     * @return the crate if it exist, otherwise null
     */
    Crate getFirstCrate(Location location);

    /**
     * Returns true if the crate exists at the location.
     *
     * @param location the location to search for.
     * @param crate the crate to check.
     * @return true if it exists, false otherwise.
     */
    boolean hasCrate(Location location, Crate crate);

    /**
     * Returns true if there are crates at the location.
     *
     * @param location the location to search for.
     * @return true if there are crates set.
     */
    boolean hasCrates(Location location);

    List<Location> getLocations();
}
