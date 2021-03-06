package com.simpleprogrammer.proteintracker.tests;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@IncludeCategory(GoodTestsCategory.class)
@ExcludeCategory(BadTestsCategory.class)
@Suite.SuiteClasses({ HelloJunitTest1.class, TrackingServiceTests.class })
public class GoodTestsSuite {

}
