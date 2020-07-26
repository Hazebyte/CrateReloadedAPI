package com.hazebyte.crate.api;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ServerVersionTest {

    @Test
    public void equals() {
        assertTrue("1_8_R1 = 1_8_R1", ServerVersion.v1_8_R1.equals(ServerVersion.v1_8_R1));
    }

    @Test
    public void gt() {
        assertTrue("1_8_R2 > 1_8_R1", ServerVersion.v1_8_R2.gt(ServerVersion.v1_8_R1));
        assertTrue("1_15_R2 > 1_8_R1", ServerVersion.v1_15_R1.gt(ServerVersion.v1_8_R1));
        assertTrue("1_15_R1 > 1_10_R1", ServerVersion.v1_15_R1.gt(ServerVersion.v1_10_R1));
    }

    @Test
    public void gte() {
        assertTrue("1_8_R1 = 1_8_R1", ServerVersion.v1_8_R1.gte(ServerVersion.v1_8_R1));
        assertTrue("1_15_R1 > 1_10_R1", ServerVersion.v1_15_R1.gte(ServerVersion.v1_10_R1));
    }

    @Test
    public void lt() {
        assertTrue("1_8_R2 < 1_8_R1", ServerVersion.v1_8_R2.gt(ServerVersion.v1_8_R1));
        assertTrue("1_15_R2 < 1_8_R1", ServerVersion.v1_15_R1.gt(ServerVersion.v1_8_R1));
        assertTrue("1_15_R1 < 1_10_R1", ServerVersion.v1_15_R1.gt(ServerVersion.v1_10_R1));
    }

    @Test
    public void lte() {
        assertTrue("1_8_R1 = 1_8_R1", ServerVersion.v1_8_R1.lte(ServerVersion.v1_8_R1));
        assertTrue("1_15_R1 < 1_10_R1", ServerVersion.v1_10_R1.lte(ServerVersion.v1_15_R1));
    }

    @Test
    public void of() {
        ServerVersion v1_17_R1 = ServerVersion.of("1_17_R1");
        assertNotNull(v1_17_R1);
        assertTrue(v1_17_R1.gt(ServerVersion.v1_16_R1));
    }

}