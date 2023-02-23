package com.swaggerwith.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.swaggerwith.spring.Repository.LocationRepository;
import com.swaggerwith.spring.model.Location;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApplicationTests {

	

	@MockBean
	LocationRepository repository;
	
	
	@Test
	
	
	public void getlocation() {
		
		
		Location location1=new Location(1, "22,3,,4,3,5", ",2,3,45,,45", "USA");

		Location location2=new Location(2, "22,3,,4,3,5", ",2,3,45,,45", "ET");

		Location location3=new Location(3, "22,3,,4,3,5", ",2,3,45,,45", "DA");
		
		
    List<Location> list=new  ArrayList<>();
    list.add(location1);
    list.add(location2);
    list.add(location3);
    
    
    when(repository.findAll()).thenReturn(list);
    
    
    assertEquals(3, repository.findAll().size());
   
	}
	
	
	@Test
	
	public void getlocatiobByid() {
		
		Location location1=new Location(1, "22,3,,4,3,5", ",2,3,45,,45", "USA");

		
		when(repository.findById(location1.getMapId())).thenReturn(Optional.of(location1));
		
		assertEquals( "USA" , location1.getMapLocation() );
		
		
		
		
	}
	
	
	
	@Test
	public void addlocation() {
		
		Location location1=new Location(1, "22,3,,4,3,5", ",2,3,45,,45", "USA");

		
		when(repository.save(location1)).thenReturn(location1);
		
		assertEquals(location1, repository.save(location1));
		
		
		
		
		
		
		
		
	}
	
	@Test
	public void deletelocation() {
		
		
		  
		Location location1=new Location(1, "22,3,,4,3,5", ",2,3,45,,45", "USA");

		repository.deleteAll();
		
		verify(repository, times(1)).deleteAll();
		
		
		
		
	}
	

	@Test
 
	public void testcal() {
		
		Calculator calculator= new Calculator();
		
		assertEquals( 0, calculator.clacadd(2, 0));
		
	}

	
}     
