import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.simpleprogrammer.proteintracker.InvalidGoalException;
import com.simpleprogrammer.proteintracker.TrackingService;

public class TrackingServiceTests {

    private TrackingService trackservice;

    @BeforeClass
    public static void before() {

        System.out.println( "Before class" );
    }

    @AfterClass
    public static void after() {

        System.out.println( "After class" );
    }

    @Before
    public void Setup() {

        trackservice = new TrackingService();

    }

    @After
    public void TearDown() {

    }

    @Test
    @Category(GoodTestsCategory.class)
    public void NewTrackingServiceTotalIsZero() {

        assertEquals( "Tracking Service total is not 0", 0, trackservice.getTotal() );

    }

    @Test
    @Category({ GoodTestsCategory.class, BadTestsCategory.class })
    public void WhenAddingProteinTotalIncreasesByThatAmount() {

        trackservice.addProtein( 10 );
        assertEquals( "Protein amount was not correct", 10, trackservice.getTotal() );

    }

    @Test
    @Category(GoodTestsCategory.class)
    public void WhenRemovingProteinTotalRemainsZero() {

        trackservice.removeProtein( 5 );
        assertEquals( "Protein amount cannot be negative", 0, trackservice.getTotal() );
    }

    @Test(expected = InvalidGoalException.class)
    @Category(BadTestsCategory.class)
    public void WhenGoalIsSetToLessThanZeroExceptionIsTHrown() throws InvalidGoalException {

        trackservice.setGoal( -5 );

    }

    @Test(timeout = 200)
    @Category(BadTestsCategory.class)
    public void BadTest() {

        for( int i = 0; i < 10000000; i++ ) {
            trackservice.addProtein( 1 );
        }
    }
}
