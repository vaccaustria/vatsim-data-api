package de.zilchinger.vatsimdatamanager;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import de.zilchinger.vatsimdatamanager.model.VatsimAirport;
import de.zilchinger.vatsimdatamanager.model.VatsimController;
import de.zilchinger.vatsimdatamanager.model.VatsimPilot;
import de.zilchinger.vatsimdatamanager.model.VatsimServer;

/**
 * @author Stefan Zilch
 * 
 */
public class VatsimDataManagerTest {

	private static final String VATSIM_STATUS_URL = "http://usa-s1.vatsim.net/data/status.txt";

	@Test
	public void testVatsimDataManger() {
		VatsimDataManager manager = new VatsimDataManager();
		manager.init(VATSIM_STATUS_URL);
		manager.addVatsimDataUpdateListener(new VatsimDataUpdate() {
			
			public void update(ArrayList<VatsimPilot> pilots,
					ArrayList<VatsimServer> servers,
					ArrayList<VatsimController> controller,
					ArrayList<VatsimAirport> airports) {
				Assert.assertNotNull(servers);
				Assert.assertNotNull(pilots);
				Assert.assertNotNull(controller);
			}
		});
		manager.update(new VatsimProgressUpdate() {
			
			public void updateProgress(int progress, int state) {
			}
		});
	}
}