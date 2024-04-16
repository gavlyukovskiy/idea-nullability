package com.github.gavlyukovskiy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void testNullIsNull() {
        Assertions.assertThat((Object) null).isNull();

        System.out.println("unreachable?");
    }
}
