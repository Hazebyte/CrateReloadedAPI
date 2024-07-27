package com.hazebyte.crate.api;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServerVersionTest {

    @Nested
    class Of {

        @Test
        public void successfullyParses() {
            ServerVersion version = ServerVersion.of("1.8.3");
            assertNotNull(version);
            assertEquals(1, version.getMajor());
            assertEquals(8, version.getMinor());
            assertEquals(3, version.getRevision());
        }

        @Test
        public void successfullyParses_whenRevisionIsMissing() {
            ServerVersion version = ServerVersion.of("1.21");
            assertNotNull(version);
            assertEquals(1, version.getMajor());
            assertEquals(21, version.getMinor());
            assertEquals(0, version.getRevision());
        }

        @Test
        public void throwsErrorOnIllegalNumberPattern() {
            assertThrows(IllegalArgumentException.class, () -> ServerVersion.of("1.2.3.4"));
        }

    }

    @Nested
    class Equals {

        @Test
        public void itReturnsTrueIfEqual() {
            ServerVersion a = ServerVersion.v1_8_R1;
            ServerVersion b = ServerVersion.v1_8_R1;
            assertTrue(a.equals(b));
            assertTrue(b.equals(a));
        }

        @Test
        public void itReturnsFalseIfDifferent() {
            ServerVersion a = ServerVersion.v1_8_R1;
            ServerVersion b = ServerVersion.v1_8_R2;
            assertTrue(!a.equals(b));
            assertTrue(!b.equals(a));
        }

    }

    @Nested
    class Comparator {

        @Test
        public void itReturnsOnGreaterMajor() {
            ServerVersion a = ServerVersion.of("2.0.0");
            ServerVersion b = ServerVersion.of("1.0.0");
            assertTrue(a.gt(b));
            assertTrue(a.gte(b));
            assertFalse(a.lt(b));
            assertFalse(a.lte(b));
        }

        @Test
        public void itReturnsOnGreaterMinor() {
            ServerVersion a = ServerVersion.of("1.1.0");
            ServerVersion b = ServerVersion.of("1.0.0");
            assertTrue(a.gt(b));
            assertTrue(a.gte(b));
            assertFalse(a.lt(b));
            assertFalse(a.lte(b));
        }

        @Test
        public void itReturnsOnGreaterRevision() {
            ServerVersion a = ServerVersion.of("1.0.1");
            ServerVersion b = ServerVersion.of("1.0.0");
            assertTrue(a.gt(b));
            assertTrue(a.gte(b));
            assertFalse(a.lt(b));
            assertFalse(a.lte(b));
        }

        @Test
        public void itReturnsOnEqual() {
            ServerVersion a = ServerVersion.of("1.0.0");
            ServerVersion b = ServerVersion.of("1.0.0");
            assertFalse(a.gt(b));
            assertTrue(a.gte(b));
            assertFalse(a.lt(b));
            assertTrue(a.lte(b));
        }

        @Test
        public void itReturnsOnLessThanMajor() {
            ServerVersion a = ServerVersion.of("1.0.0");
            ServerVersion b = ServerVersion.of("2.0.0");
            assertFalse(a.gt(b));
            assertFalse(a.gte(b));
            assertTrue(a.lt(b));
            assertTrue(a.lte(b));
        }

        @Test
        public void itReturnsOnLessThanMinor() {
            ServerVersion a = ServerVersion.of("1.0.0");
            ServerVersion b = ServerVersion.of("1.1.0");
            assertFalse(a.gt(b));
            assertFalse(a.gte(b));
            assertTrue(a.lt(b));
            assertTrue(a.lte(b));
        }

        @Test
        public void itReturnsOnLessThanRevision() {
            ServerVersion a = ServerVersion.of("1.0.0");
            ServerVersion b = ServerVersion.of("1.0.1");
            assertFalse(a.gt(b));
            assertFalse(a.gte(b));
            assertTrue(a.lt(b));
            assertTrue(a.lte(b));
        }

    }

}