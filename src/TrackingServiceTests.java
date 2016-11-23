import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

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
        //        assertEquals( "Protein amount was not correct", 10, trackservice.getTotal() );
        //        assertThat( trackservice.getTotal(), is( 10 ) );

        assertThat( trackservice.getTotal(), allOf( is( 10 ), instanceOf( Integer.class ) ) );

    }

    @Test
    @Category(GoodTestsCategory.class)
    public void WhenRemovingProteinTotalRemainsZero() {

        for( int i = 0; i < 10000000; i++ ) {
            trackservice.addProtein( 1 );
        }

        trackservice.removeProtein( 5 );
        assertEquals( "Protein amount cannot be negative", 0, trackservice.getTotal() );
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = InvalidGoalException.class)
    @Category(BadTestsCategory.class)

    public void WhenGoalIsSetToLessThanZeroExceptionIsTHrown() throws InvalidGoalException {

        trackservice.setGoal( -5 );
        thrown.expect( InvalidGoalException.class );
        thrown.expectMessage( containsString( "goal" ) );
        //thrown.expectMessage( "Goal was less than zero" );

    }

    @Rule
    public Timeout timeout = new Timeout( 20 );

    @Test
    @Category(BadTestsCategory.class)
    public void BadTest() {

        for( int i = 0; i < 10000000; i++ ) {
            trackservice.addProtein( 1 );
        }
    }
}
