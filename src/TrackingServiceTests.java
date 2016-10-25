import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.simpleprogrammer.proteintracker.TrackingService;

public class TrackingServiceTests {

    private TrackingService trackservice;

    @Before
    public void Setup() {

        trackservice = new TrackingService();
    }

    @After
    public void TearDown() {

    }

    @Test
    public void NewTrackingServiceTotalIsZero() {

        assertEquals( "Tracking Service total is not 0", 0, trackservice.getTotal() );

    }

    @Test
    public void WhenAddingProteinTotalIncreasesByThatAmount() {

        trackservice.addProtein( 10 );
        assertEquals( "Protein amount was not correct", 10, trackservice.getTotal() );

    }

    @Test
    public void WhenRemovingProteinTotalRemainsZero() {

        trackservice.removeProtein( 5 );
        assertEquals( "Protein amount cannot be negative", 0, trackservice.getTotal() );
    }

}
