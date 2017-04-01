package be.nielsdelestinne.goldenempire;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
@RunWith(MockitoJUnitRunner.class)
public abstract class UnitTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

}
