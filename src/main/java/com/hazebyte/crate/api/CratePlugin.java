package com.hazebyte.crate.api;

import com.hazebyte.crate.api.crate.BlockCrateRegistrar;
import com.hazebyte.crate.api.crate.CrateRegistrar;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public interface CratePlugin extends Plugin {

    boolean isReady();

    CrateRegistrar getCrateRegistrar();

    BlockCrateRegistrar getBlockCrateRegistrar();
}
