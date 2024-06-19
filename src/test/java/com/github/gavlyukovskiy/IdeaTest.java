package com.github.gavlyukovskiy;

import com.github.gavlyukovskiy.subpackage.AnotherPackage;
import org.assertj.core.api.Assertions;
import org.jspecify.annotations.NullUnmarked;
import org.junit.jupiter.api.Test;

class IdeaTest {

    @Test
    void nullMarkedTest() {
        // Correct: a warning for the package annotated with @NullMarked
        NullMarkedPackageClass.method(null); // IDEA: Passing 'null' argument to parameter annotated as @NotNull

        // Correct: no warning for the package not annotated with @NullMarked
        AnotherPackage.method(null);

        // Incorrect: a warning for the 3rd party package not annotated with @NullMarked or @NotNull
        Assertions.assertThat((Object) null).isNull(); // IDEA: Passing 'null' argument to parameter annotated as @NotNull
    }

    @Test
    @NullUnmarked
    void nullUnmarkedTest() {
        // Correct: @NullUnmarked on this test has no influence on the package annotated with @NullMarked
        NullMarkedPackageClass.method(null); // IDEA: Passing 'null' argument to parameter annotated as @NotNull

        // Correct: @NullUnmarked on this test has no influence on the package not annotated with @NullMarked
        AnotherPackage.method(null);

        // Weird: @NullUnmarked on this test method somehow cancels the nullability annotation of the 3rd party package,
        //  which was incorrectly added there by having @NullMarked on the current package
        Assertions.assertThat((Object) null).isNull();
    }
}
