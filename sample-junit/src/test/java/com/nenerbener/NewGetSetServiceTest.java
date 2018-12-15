package com.nenerbener;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.*;
import com.nenerbener.api.GetSetDataStub;

/**
 * Unit test for simple App.
 */
public class NewGetSetServiceTest 
{
	NewGetSetService ngss = null;
	@Before
	public void initialize() {
		GetSetDataStub gsStub = new GetSetDataStub();
		ngss = new NewGetSetService(gsStub);
	}
    /**
     * test NewGetSetService.filterQueryListToReturnName
     */
//	@Ignore
	@Test
    public void filterQueryListToReturnNameStubTest()
    {
		List<String> list = ngss.filterQueryListToReturnName("anything", "marc");
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			assertEquals("marc",iterator.next());
		}

    }
	
	@Test
	public void countQueryListTest()
	{
		List<String> list = ngss.filterQueryListToReturnName("anything", "marc");
		Integer count = ngss.countQueryList("marc");
		assertEquals(7,count.intValue());
	}
	
	
	@After
	public void finalize() {
		ngss = null;
	}
}
