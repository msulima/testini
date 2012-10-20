package com.github.pushman.testini.runner;

import com.github.pushman.testini.data.TestKit;
import com.github.pushman.testini.xml.data.TestKitData;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.fest.assertions.Assertions.assertThat;

@RunWith(TestiniTestRunner.class)
public class TestiniTestRunnerTest {

    @Test
    public void testMarker() {
    }

    @Test
    public void shouldConvertToUppercase(String actual, String expected) {
        assertThat(actual.toUpperCase()).isEqualTo(expected);
    }

    public List<? extends TestKit> parametersForShouldConvertToUppercase() {
        return newArrayList(
                new TestKitData(newArrayList("Hello, world", "HELLO, WORLD")),
                new TestKitData(newArrayList("foo", "FOO"))
        );
    }
}
