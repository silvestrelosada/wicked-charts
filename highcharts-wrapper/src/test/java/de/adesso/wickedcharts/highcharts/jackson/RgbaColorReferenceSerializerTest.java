/*
 * Copyright 2012-2019 Wicked Charts (tom.hombergs@gmail.com)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package de.adesso.wickedcharts.highcharts.jackson;

import de.adesso.wickedcharts.highcharts.options.color.ColorReference;
import de.adesso.wickedcharts.highcharts.options.color.RgbaColor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RgbaColorReferenceSerializerTest {

  @Test
  void test() {
    // given
    ColorReference color = new RgbaColor(1, 2, 3, 0.5f);
    JsonRenderer renderer = new JsonRenderer();

    // when
    String json = renderer.toJson(color);

    // then
    assertEquals("\"rgba(1,2,3,0.50)\"", json);
  }

  @Test
  void testWithBrightness() {
    // given
    ColorReference color = new RgbaColor(1, 2, 3, 0.5f);
    color = color.brighten(0.1f);
    JsonRenderer renderer = new JsonRenderer();

    // when
    String json = renderer.toJson(color);

    // then
    assertEquals(
        "Highcharts.Color(\"rgba(1,2,3,0.50)\").brighten(0.10).get()", json);
  }
}
