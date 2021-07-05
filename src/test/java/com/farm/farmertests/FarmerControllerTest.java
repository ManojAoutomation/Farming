package com.farm.farmertests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.farm.dao.FarmerJpaDao;
import com.farm.model.Farmer;
import com.farm.service.FarmerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FarmerControllerTest {

	@Autowired
	private FarmerService farmerService;

	@MockBean
	private FarmerJpaDao farmerRepo;

	@Test
	public void testRegisterFarmer() {

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

	
	  @SuppressWarnings("deprecation")
	  
	  @Test public void testGetIdByFarmer() {
	  
	  Farmer farmer = new Farmer(); farmer.setFarmerId(1);
	  farmer.setFarmerName("Manoj"); farmer.setContactNo("8493024025");
	   farmer.setEmailId("manojc435@gmail.com");
	  farmer.setPassword("manojc435"); farmer.setLocation("Thane");
	  Mockito.when(farmerRepo.getOne((Integer) 4)).thenReturn(farmer);
	  Mockito.when(farmerRepo.existsById(farmer.getFarmerId())).thenReturn(false);
	  assertFalse(farmerRepo.existsById(farmer.getFarmerId()));
	  
	  }
	 
	@Test
	public void testUpdateFarmer() {

		Farmer farmer = new Farmer();
		farmer.setFarmerId(1);
		farmer.setFarmerName("Vinod");
		farmer.setContactNo("7040760465");
		farmer.setEmailId("vi45@gmail.com");
		farmer.setPassword("vinod75");
		farmer.setLocation("Thane");

		Mockito.when(farmerRepo.save(farmer)).thenReturn(farmer);
		assertThat(farmerService.registerFarmer(farmer)).isEqualTo(farmer);
	}

}
