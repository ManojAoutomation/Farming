package com.farm.farmertests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.farm.dao.AdvertisementJpaDao;
import com.farm.dao.FarmerJpaDao;
import com.farm.model.Farmer;
import com.farm.service.FarmerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FarmerServiceTest {

	
	@Autowired
	private FarmerService farmerService;
	
	@MockBean
	private FarmerJpaDao farmerRepo;
	
	@MockBean
	private AdvertisementJpaDao adRepo;
	
	
	
	@Test
	public void testRegisterFarmer()
	{

		Farmer farmer = new Farmer();
		farmer.setFarmerId(1);
		farmer.setFarmerName("Manoj");
		farmer.setContactNo("8493024025");
		farmer.setEmailId("manojc435@gmail.com");
		farmer.setPassword("manojc435");
		farmer.setLocation("Thane");

		
		Mockito.when(farmerRepo.save(farmer)).thenReturn(farmer);
		
		assertThat(farmerService.registerFarmer(farmer)).isEqualTo(farmer);
		
	}
	
	
	  @Test public void testDeleteFarmer() { Farmer farmer = new Farmer();
	  farmer.setFarmerId(1); farmer.setFarmerName("Manoj");
	  farmer.setContactNo("8493024025");
	  farmer.setEmailId("manojc435@gmail.com"); farmer.setPassword("manojc435");
	  farmer.setLocation("Thane");
	  
	  
	  Mockito.when(farmerRepo.getOne((int) 4)).thenReturn(farmer);
	  Mockito.when(farmerRepo.existsById(farmer.getFarmerId())).thenReturn(false);
	  assertFalse(farmerRepo.existsById(farmer.getFarmerId()));
	  
	  }
	  
	  @Test public void testFailedToDeleteFarmer() { Farmer farmer = new Farmer();
	  farmer.setFarmerId(1); farmer.setFarmerName("Manoj");
	  farmer.setContactNo("8493024025");
	  farmer.setEmailId("manojc435@gmail.com"); farmer.setPassword("manojc435");
	  farmer.setLocation("Thane");
	  
	  
	  Mockito.when(farmerRepo.getOne((int) 4)).thenReturn(farmer);
	  Mockito.when(farmerRepo.existsById(farmer.getFarmerId())).thenReturn(true);
	  assertTrue(farmerRepo.existsById(farmer.getFarmerId()));
	  
	  }
	 
	
}
