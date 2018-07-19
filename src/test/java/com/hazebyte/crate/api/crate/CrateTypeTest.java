package com.hazebyte.crate.api.crate;

import org.junit.Test;

public class CrateTypeTest {

    @Test
    public void getSupplyCrate() {
        assert CrateType.getType("SUPPLY") == CrateType.SUPPLY;
    }

    @Test
    public void getMysteryCrate() {
        assert CrateType.getType("MYSTERY") == CrateType.MYSTERY;
    }

    @Test
    public void getKeyCrate() {
        assert CrateType.getType("KEY") == CrateType.KEY;
    }

    @Test
    public void getMenuCrate() {
        assert CrateType.getType("MENU") == CrateType.MENU;
    }

}