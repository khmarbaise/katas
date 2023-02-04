package com.soebes.versions;

import org.apache.maven.artifact.versioning.ComparableVersion;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class ComparableVersionTest {

  private final String VERSIONS = "0.0.1576817712//0.0.3//0.0.4//0.0.4.//0.0.4.1//0.0.4.2//0.0.4.3//0.0.4.4//0.0.4.5//0.0.5//0.0.5.1//0.0.5.2//0.0.5.3//0.0.5.4//0.0.6//0.0.7//0.0.8//0.1.0//0.1.2//0.1.2.1//0.1.2.2//0.1.2.3//0.1.2.4//0.1.2.5//0.1.2.6//0.1.2.7//0.1.2.8//0.1.3//0.1.3.1//0.1.3.2//0.1.3.3//0.1.4//0.1.4.1//0.1.4.2//0.1.4.3//0.1.4.4//0.1.4.5//0.1.4.6//0.1.4.7//0.1.4.8//0.1.4.9//0.1.5//0.1.7//0.1.7.1//0.1.7.2//0.1.7.3//0.1.7.4//0.1.7.5//0.1.7.6//0.1.7.7//0.1.8//0.1.9//0.1.9.1//0.1.9.11//0.1.9.12//0.1.9.13//0.1.9.2//0.1.9.3//0.1.9.8//0.1.9.9//0.1.9.9.1//1.0.0.1//1.0.0.2//1.0.0.3//1.0.0.3.1//1.0.0.4//1.0.0.5//0.0.0.1-SNAPSHOT//0.0.11-SNAPSHOT//0.0.1576066498-SNAPSHOT//0.0.1576066912-SNAPSHOT//0.0.1576209616-SNAPSHOT//0.0.1576677646-SNAPSHOT//0.0.1576722159-SNAPSHOT//0.0.1576732580-SNAPSHOT//0.0.1576737990-SNAPSHOT//0.0.1576757185-SNAPSHOT//0.0.1576812388-SNAPSHOT//0.0.1576817712-SNAPSHOT//0.0.1576821661-SNAPSHOT//0.0.1576821977-SNAPSHOT//0.0.1576825998-SNAPSHOT//0.0.1577182101-SNAPSHOT//0.0.1577266235-SNAPSHOT//0.0.1577267400-SNAPSHOT//0.0.1577268933-SNAPSHOT//0.0.2-SNAPSHOT//0.0.3-SNAPSHOT//0.0.4-SNAPSHOT//0.0.4.1-SNAPSHOT//0.0.4.2-SNAPSHOT//0.0.4.4-SNAPSHOT//0.0.4.5-SNAPSHOT//0.0.5-SNAPSHOT//0.0.5.11151113-SNAPSHOT//0.0.5.2-SNAPSHOT//0.0.5.2.1-SNAPSHOT//0.0.5.20180829-SNAPSHOT//0.0.5.20181115-SNAPSHOT//0.0.5.4-SNAPSHOT//0.0.5.4.181113-SNAPSHOT//0.0.5.5-SNAPSHOT//0.0.6-SNAPSHOT//0.0.7-SNAPSHOT//0.0.8-SNAPSHOT//0.0.9-SNAPSHOT//0.0.91576063257-SNAPSHOT//0.0.91576066026-SNAPSHOT//0.1.0-SNAPSHOT//0.1.1-SNAPSHOT//0.1.2-SNAPSHOT//0.1.2.2-SNAPSHOT//0.1.2.3-SNAPSHOT//0.1.2.4-SNAPSHOT//0.1.2.5-SNAPSHOT//0.1.2.6-SNAPSHOT//0.1.2.7-SNAPSHOT//0.1.3-SNAPSHOT//0.1.3.1-SNAPSHOT//0.1.3.3-SNAPSHOT//0.1.3.4-SNAPSHOT//0.1.4-SNAPSHOT//0.1.4.1-SNAPSHOT//0.1.4.4-SNAPSHOT//0.1.4.5-SNAPSHOT//0.1.4.6-SNAPSHOT//0.1.4.7-SNAPSHOT//0.1.4.9-SNAPSHOT//0.1.4.l-SNAPSHOT//0.1.4.y-SNAPSHOT//0.1.4.yl-SNAPSHOT//0.1.4.yy-SNAPSHOT//0.1.5-push-SNAPSHOT//0.1.5-SNAPSHOT//0.1.5.1-SNAPSHOT//0.1.5.2-SNAPSHOT//0.1.5.3-SNAPSHOT//0.1.5.4-SNAPSHOT//0.1.5.5-SNAPSHOT//0.1.5.6-SNAPSHOT//0.1.5.l-SNAPSHOT//0.1.5.testpush-SNAPSHOT//0.1.5.y-SNAPSHOT//0.1.5.yl-SNAPSHOT//0.1.6-SNAPSHOT//0.1.7-SNAPSHOT//0.1.7.1-SNAPSHOT//0.1.7.2-SNAPSHOT//0.1.7.3-SNAPSHOT//0.1.7.4-SNAPSHOT//0.1.7.6.1-SNAPSHOT//0.1.8-SNAPSHOT//0.1.9.15-SNAPSHOT//0.1.9.16-SNAPSHOT//0.1.9.2-SNAPSHOT//0.1.9.6-SNAPSHOT//0.1.9.7-SNAPSHOT//0.1.9.9.2-SNAPSHOT//0.1.9.9.3-SNAPSHOT//0.2.0-SNAPSHOT//1.0.0.0-SNAPSHOT//1.0.0.1-SNAPSHOT//1.0.0.2-SNAPSHOT//1.0.0.3-lv-SNAPSHOT//1.0.0.3-SNAPSHOT//1.0.0.4-SNAPSHOT//1.0.0.5-SNAPSHOT//1.0.0.6-SNAPSHOT//1.0.0.7-SNAPSHOT//1.0.0.8-SNAPSHOT//1.0.0.9-SNAPSHOT//1.0.1-SNAPSHOT//1.0.1.0-SNAPSHOT//1.0.1.1-SNAPSHOT//1.0.1.2-SNAPSHOT//1.0.1.3-SNAPSHOT";

  @Test
  void name() {
    String[] versions = VERSIONS.split("//");
    List<ComparableVersion> comparableVersions = Arrays.stream(versions).map(ComparableVersion::new).collect(Collectors.toList());
    Collections.sort(comparableVersions);
  }
}
