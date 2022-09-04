package com.hazebyte.crate.api;

import com.hazebyte.crate.api.claim.ClaimRegistrar;
import com.hazebyte.crate.api.crate.BlockCrateRegistrar;
import com.hazebyte.crate.api.crate.CrateRegistrar;
import org.bukkit.plugin.Plugin;

public interface CratePlugin extends Plugin {

    boolean isReady();

    CrateRegistrar getCrateRegistrar();

    BlockCrateRegistrar getBlockCrateRegistrar();

    ClaimRegistrar getClaimRegistrar();

    ServerVersion getServerVersion();

    String getMessage(String key);
}
