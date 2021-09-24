package entities;

import org.junit.Assert;
import org.junit.Test;

public class HolderTest {

    @Test
    public void createHolder (){
        Holder holder = new Holder(1, "Alain Bernard");
        Assert.assertEquals(1, holder.getId());
        Assert.assertEquals("Alain Bernard", holder.getHolderName());
    }
}
