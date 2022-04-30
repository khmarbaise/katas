package com.soebes.versions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VersionTest {

  @Test
  void first() {
    var versionFirst = new Version(1, 2, 3);
    var versionSecond = new Version(1, 3, 3);

    assertThat(versionFirst).isLessThan(versionSecond);
  }
}