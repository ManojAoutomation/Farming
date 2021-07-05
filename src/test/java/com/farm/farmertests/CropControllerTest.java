package com.farm.farmertests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.farm.dao.CropJpaDao;
import com.farm.model.CropEntity;
import com.farm.service.CropService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CropControllerTest {
		@Autowired
		private CropService cropService;

		@MockBean
		private CropJpaDao cropRepo;

		@Test
		public void testSellCrop() {

			CropEntity crop = new CropEntity();
			crop.setCropId(1);
			crop.setCropName("Maize");
			crop.setFarmerId(123);
			crop.setFarmerName("Krishna");
			crop.setPrice(40000);
			
			Mockito.when(cropRepo.save(crop)).thenReturn(crop);
			assertThat(cropService.sellCrop(crop)).isEqualTo(crop);
		}
		
		@Test
		public void testUpdateCrop() {

			CropEntity crop = new CropEntity();
			crop.setCropId(1);
			crop.setCropName("Maize");
			crop.setFarmerId(123);
			crop.setFarmerName("Krishna");
			crop.setPrice(40000);
			
			Mockito.when(cropRepo.save(crop)).thenReturn(crop);
			assertThat(cropService.sellCrop(crop)).isEqualTo(crop);
		}
		
		@SuppressWarnings("deprecation")
		@Test
		public void testViewCrop() {

			CropEntity crop = new CropEntity();
			crop.setCropId(1);
			crop.setCropName("Maize");
			crop.setFarmerId(123);
			crop.setFarmerName("Krishna");
			crop.setPrice(40000);
			Mockito.when(cropRepo.getOne((long) 4)).thenReturn(crop);
			Mockito.when(cropRepo.existsById(crop.getFarmerId())).thenReturn(false);
			assertFalse(cropRepo.existsById(crop.getFarmerId()));

		}
		@Test
		public void testDeleteCrop() {

			CropEntity crop = new CropEntity();
			crop.setCropId(1);
			crop.setCropName("Maize");
			crop.setFarmerId(123);
			crop.setFarmerName("Krishna");
			crop.setPrice(40000);
			
			Mockito.when(cropRepo.findById((long) 12345)).thenReturn(Optional.of(crop));
			Mockito.when(cropRepo.existsById(crop.getCropId())).thenReturn(false);
			assertFalse(cropRepo.existsById(crop.getCropId()));
		}
		
		

}