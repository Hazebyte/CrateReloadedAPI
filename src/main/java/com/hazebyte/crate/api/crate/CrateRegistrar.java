package com.hazebyte.crate.api.crate;

import com.hazebyte.crate.api.request.CreateCrateEffectRequest;
import com.hazebyte.crate.api.request.GenerateCrateRewardRequest;
import com.hazebyte.crate.api.request.GiveCrateRequest;
import com.hazebyte.crate.api.request.OpenCrateRequest;
import com.hazebyte.crate.api.request.PreviewCrateRequest;
import com.hazebyte.crate.api.response.CreateCrateEffectResponse;
import com.hazebyte.crate.api.response.GenerateCrateRewardResponse;
import com.hazebyte.crate.api.response.GiveCrateResponse;
import com.hazebyte.crate.api.response.OpenCrateResponse;
import com.hazebyte.crate.api.response.PreviewCrateResponse;
import java.util.List;
import org.bukkit.inventory.ItemStack;

/** Contains methods used to manipulate and retrieve a crate. */
public interface CrateRegistrar {

  /**
   * Retrieves the specified {@link Crate} with a item.
   *
   * @param item ItemStack
   * @return {@link Crate}
   */
  Crate getCrate(ItemStack item);

  /**
   * Retrieves the specified {@link Crate} given the crate identifier name.
   *
   * @param str Crate Identifier
   * @return {@link Crate}
   */
  Crate getCrate(String str);

  /**
   * Returns a list of crates
   *
   * @return a list of crates
   */
  List<Crate> getCrates();

  /**
   * Checks if the item represents a crate.
   *
   * @param item {@link ItemStack}
   * @return true if the item is a crate, false otherwise.
   */
  boolean isCrate(ItemStack item);

  /**
   * Adds a crate to the plugin. This registers the crate and makes it available to use.
   *
   * <p>todo List Requirements
   *
   * @param crate The crate that you want to add
   */
  void add(Crate crate);

  /**
   * Removes a crate from the plugin. This unregisters the crate from the plugin. Actions will no
   * longer be handled by this crate if you do so.
   *
   * @param crate The crate that you will remove
   */
  void remove(Crate crate);

  OpenCrateResponse openCrate(OpenCrateRequest request);

  PreviewCrateResponse previewCrate(PreviewCrateRequest request);

  GenerateCrateRewardResponse generateRewards(GenerateCrateRewardRequest request);

  GiveCrateResponse giveCrate(GiveCrateRequest request);

  CreateCrateEffectResponse createEffect(CreateCrateEffectRequest request);

  String getCrateString();
}
