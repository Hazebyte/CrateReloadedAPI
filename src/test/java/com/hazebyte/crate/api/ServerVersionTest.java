package com.hazebyte.crate.api;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ServerVersionTest {

  @Nested
  class Of {

    @Test
    public void itRemovesAnyNonDigits() {
      assertDoesNotThrow(() -> ServerVersion.of("RELEASE1_8_3"));
    }

    @Test
    public void itSuccessfullyParses() {
      ServerVersion version = ServerVersion.of("R1_8_3");
      assertNotNull(version);
      assertEquals(1, version.getMajor());
      assertEquals(8, version.getMinor());
      assertEquals(3, version.getRevision());
    }

    @Test
    public void throwsErrorOnIllegalNumberPattern() {
      assertThrows(IllegalArgumentException.class, () -> ServerVersion.of("1_2_3_4"));
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
      ServerVersion a = ServerVersion.of("2_0_0");
      ServerVersion b = ServerVersion.of("1_0_0");
      assertTrue(a.gt(b));
      assertTrue(a.gte(b));
      assertFalse(a.lt(b));
      assertFalse(a.lte(b));
    }

    @Test
    public void itReturnsOnGreaterMinor() {
      ServerVersion a = ServerVersion.of("1_1_0");
      ServerVersion b = ServerVersion.of("1_0_0");
      assertTrue(a.gt(b));
      assertTrue(a.gte(b));
      assertFalse(a.lt(b));
      assertFalse(a.lte(b));
    }

    @Test
    public void itReturnsOnGreaterRevision() {
      ServerVersion a = ServerVersion.of("1_0_1");
      ServerVersion b = ServerVersion.of("1_0_0");
      assertTrue(a.gt(b));
      assertTrue(a.gte(b));
      assertFalse(a.lt(b));
      assertFalse(a.lte(b));
    }

    @Test
    public void itReturnsOnEqual() {
      ServerVersion a = ServerVersion.of("1_0_0");
      ServerVersion b = ServerVersion.of("1_0_0");
      assertFalse(a.gt(b));
      assertTrue(a.gte(b));
      assertFalse(a.lt(b));
      assertTrue(a.lte(b));
    }

    @Test
    public void itReturnsOnLessThanMajor() {
      ServerVersion a = ServerVersion.of("1_0_0");
      ServerVersion b = ServerVersion.of("2_0_0");
      assertFalse(a.gt(b));
      assertFalse(a.gte(b));
      assertTrue(a.lt(b));
      assertTrue(a.lte(b));
    }

    @Test
    public void itReturnsOnLessThanMinor() {
      ServerVersion a = ServerVersion.of("1_0_0");
      ServerVersion b = ServerVersion.of("1_1_0");
      assertFalse(a.gt(b));
      assertFalse(a.gte(b));
      assertTrue(a.lt(b));
      assertTrue(a.lte(b));
    }

    @Test
    public void itReturnsOnLessThanRevision() {
      ServerVersion a = ServerVersion.of("1_0_0");
      ServerVersion b = ServerVersion.of("1_0_1");
      assertFalse(a.gt(b));
      assertFalse(a.gte(b));
      assertTrue(a.lt(b));
      assertTrue(a.lte(b));
    }
  }
}
