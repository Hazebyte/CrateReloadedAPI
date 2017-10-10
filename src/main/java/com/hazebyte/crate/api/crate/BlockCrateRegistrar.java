package com.hazebyte.crate.api.crate;

import org.bukkit.Location;

import java.util.List;

public interface BlockCrateRegistrar {

    boolean setCrate(Location location, Crate crate);

    boolean setCrate(Location location, Crate crate, boolean save);

    boolean removeCrate(Location location, Crate crate);

    boolean removeCrate(Location location, Crate crate, boolean save);

    boolean save();

    Crate getCrate(Location location, Crate crate);

    Crate getCrate(Location location, String crateName);

    List<Crate> getCrates(Location location);

    Crate getFirstCrate(Location location);

    String getSaveKey(Location location, Crate crate);

}
