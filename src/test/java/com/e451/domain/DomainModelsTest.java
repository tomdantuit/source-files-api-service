package com.e451.domain;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import org.junit.Before;
import org.junit.Test;

public class DomainModelsTest {
    private Validator validator;
    private final PojoClassFilter filterTestClasses = new FilterTestClasses();

    @Before
    public void setUp() {
        validator = ValidatorBuilder.create()
                .with(new GetterMustExistRule())
                .with(new SetterMustExistRule())
                .with(new SetterTester())
                .with(new GetterTester())
                .build();
    }

    @Test
    public void allPojosShouldBeWiredCorrectly() {
        String packageName = "com.e451.domain";
        validator.validate(packageName, filterTestClasses);
    }

    private static class FilterTestClasses implements PojoClassFilter {
        public boolean include(PojoClass pojoClass) { return !pojoClass.getSourcePath().contains("test-classes"); }
    }
}