package com.umkc.simulated.annealing.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.umkc.simulated.annealing.models.Item;
import com.umkc.simulated.annealing.models.Vehicle;

@Service
public class SimulatedAnnealingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SimulatedAnnealingService.class);

	public String process(MultipartFile file, String delimeter,double maxWeight) {

		try {

			List<Item> items = this.mapFileToList(file, delimeter);

			Vehicle vehicle=new Vehicle(maxWeight);
			double val= this.findBestSolution(items,vehicle.getTotalWeight());
			
			
			LOGGER.info("MaxUtility: "+val);
			
			return String.format("MaxUtility: %.3g%n", val);


		} catch (Exception ex) {

			LOGGER.error("Error:" + ex.getMessage());

			return null;
		}

	}

	private List<Item> mapFileToList(MultipartFile file, String delimeter) throws IOException {
		BufferedReader br;
		List<Item> result = new ArrayList<>();

		String line;
		InputStream is = file.getInputStream();
		br = new BufferedReader(new InputStreamReader(is));
		while ((line = br.readLine()) != null) {
			Item item = new Item();
			item.setUtility(Double.parseDouble(line.split(delimeter)[0]));
			item.setWeight(Double.parseDouble(line.split(delimeter)[1]));
			item.setSelected(false);
			result.add(item);
		}
		return result;

	}

	private double findBestSolution(List<Item> items, double totalWeight) {

		 int n=items.size();

		 if (items.size() == 0 || totalWeight == 0) {
	            return 0;
		 }
		 LOGGER.info(""+items.get(n-1).getWeight()+" "+items.get(n-1).getUtility());

		 if(items.get(n-1).getWeight() >totalWeight) {
			 items.remove(n-1);
			 return findBestSolution(items,totalWeight);
		 }
		 
		 else {
			 double w=items.get(n-1).getWeight();
			 double utility=items.get(n-1).getUtility();
			 items.remove(n-1);
			 return max(utility+findBestSolution(items,totalWeight-w),findBestSolution(items,totalWeight),totalWeight);
		 }
		
	    }
		/*
		
		Vehicle tempVehicle = new Vehicle();
		for (int i = 0; i < items.size(); i++) {
			double w=tempVehicle.getTotalWeight()+items.get(i).getWeight();
			if(w<=tempVehicle.getMaxWeight()) {
				
				//items.get(i).setSelected(true);
				tempVehicle.getItemsToTake().add(items.get(i));
				tempVehicle.setTotalWeight(w);
				tempVehicle.setTotalUtility(tempVehicle.getTotalUtility()+items.get(i).getUtility());
			
				
			}else {
				
				if(tempVehicle.getTotalUtility()>vehicle.getTotalUtility()) {
					vehicle=tempVehicle;
					
					LOGGER.info(tempVehicle.toString());

					tempVehicle=new Vehicle();

					
				}
				
			}

		}

		return items;

	}
	*/
	
	private double max(double a, double b,double weight) 
    { 
      LOGGER.info("Util "+a+" "+b+ "Weight "+ weight);
      return (a > b) ? a : b; 
    }
	
}
