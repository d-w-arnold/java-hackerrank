package InterviewPreparationKit.Sorting.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 27/07/2021
 */
class FraudulentActivityNotificationsTest
{

    @BeforeEach
    void setUp()
    {
    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    void activityNotifications_1()
    {
        assertEquals(1, FraudulentActivityNotifications.activityNotifications(Arrays.asList(10, 20, 30, 40, 50), 3));
    }

    @Test
    void activityNotifications_2()
    {
        assertEquals(2, FraudulentActivityNotifications.activityNotifications(Arrays.asList(2, 3, 4, 2, 3, 6, 8, 4, 5), 5));
    }

    @Test
    void activityNotifications_3()
    {
        assertEquals(0, FraudulentActivityNotifications.activityNotifications(Arrays.asList(1, 2, 3, 4, 4), 4));
    }
}