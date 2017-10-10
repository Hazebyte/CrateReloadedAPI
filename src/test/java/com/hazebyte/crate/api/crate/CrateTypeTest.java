package com.hazebyte.crate.api.crate;

import org.junit.Test;

public class CrateTypeTest {

    @Test
    public void getSupplyCrate() {
        CrateType type = CrateType.getType(0);
        assert CrateType.getType("SUPPLY") == type;
    }

    @Test
    public void getMysteryCrate() {
        CrateType type = CrateType.getType(1);
        assert CrateType.getType("MYSTERY") == type;
    }

    @Test
    public void getKeyCrate() {
        CrateType type = CrateType.getType(2);
        assert CrateType.getType("KEY") == type;
    }

    @Test
    public void getMenuCrate() {
        CrateType type = CrateType.getType(3);
        assert CrateType.getType("MENU") == type;
    }

    @Test
    public void testSupplyCrateAnimations() {
        CrateType type = CrateType.SUPPLY;
        assert type.getAnimation() == null;
    }

    @Test
    public void testMysteryCrateAnimations() {
        CrateType type = CrateType.MYSTERY;
        assert type.getAnimation().size() > 0;
    }

    @Test
    public void testKeyCrateAnimations() {
        CrateType type = CrateType.KEY;
        assert type.getAnimation().size() > 0;
    }

    @Test
    public void testMenuCrateAnimations() {
        CrateType type = CrateType.MENU;
        assert type.getAnimation() == null;
    }

}