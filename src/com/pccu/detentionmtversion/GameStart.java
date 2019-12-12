package com.pccu.detentionmtversion;

public class GameStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IntelligenceCenter infoCenterA = new IntelligenceCenter();
		
		Scene sceneA = new Scene() {
			@Override
			public Events getEvent(int cnt) {
				// TODO Auto-generated method stub
				int event_types = 3; 
				Events e = new Events();
				switch (cnt % event_types) { 
					case 0:
						e.EventDescription = "drinking";
						break;
					case 1:
						e.EventDescription = "Eating";
						break;
					case 2:
						e.EventDescription = "Reading";
						break;
				}
				return e;
			}
		};
		
		IntelligenceOfficer informerA 	= new IntelligenceOfficer("Agent", "Spy A");
		SceneInstance sceneInstanceA 	= new SceneInstance("Worker Office", sceneA, informerA, infoCenterA);
		Thread seceneInstanceAThread 	= new Thread (sceneInstanceA);
		seceneInstanceAThread.start();
		
		
		Scene sceneB = new Scene() {
			@Override
			public Events getEvent(int cnt) {
				// TODO Auto-generated method stub
				int event_types = 3; 
				Events e = new Events();
				switch (cnt % event_types) { 
					case 0:
						e.EventDescription = "Playing";
						break;
					case 1:
						e.EventDescription = "Discussing";
						break;
					case 2:
						e.EventDescription = "Hosting";
						break;
				}
				return e;
			}
		};
		
		IntelligenceOfficer informerB 	= new IntelligenceOfficer("Agent", "Spy B");
		SceneInstance sceneInstanceB 	= new SceneInstance("Student Club", sceneB, informerB, infoCenterA);
		Thread seceneInstanceBThread 	= new Thread (sceneInstanceB);
		seceneInstanceBThread.start();
		
		IntelligenceOfficer monitorA = new IntelligenceOfficer("Monitor", "Military Instructor");
		while (true) {
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			infoCenterA.dequeuEvent(monitorA);
		}
	
	}
}
