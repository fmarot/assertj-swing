/*
 * Created on Feb 24, 2008
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * 
 * Copyright @2008-2013 the original author or authors.
 */
package org.assertj.swing.driver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.swing.test.core.CommonAssertions.failWhenExpectingException;

import org.junit.Test;

/**
 * Tests for {@link JListDriver#requireSelection(javax.swing.JList, int)}.
 * 
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class JListDriver_requireSelectionByIndex_Test extends JListDriver_TestCase {
  @Test
  public void should_pass_if_selection_is_equal_to_expected() {
    selectFirstItem();
    driver.requireSelection(list, 0);
  }

  @Test
  public void should_fail_if_there_is_no_selection() {
    clearSelection();
    thrown.expectAssertionError("property:'selectedIndex'");
    thrown.expectMessageToContain("No selection");
    driver.requireSelection(list, 0);
  }

  @Test
  public void should_fail_if_selection_is_not_equal_to_expected() {
    select(1);
    thrown.expectAssertionError("property:'selectedIndex'");
    thrown.expectMessageToContain("expected:<[0]> but was:<[1]>");
    driver.requireSelection(list, 0);
  }
}