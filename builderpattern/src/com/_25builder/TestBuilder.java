package com._25builder;

public class TestBuilder {
	public static void main(String[] args) {
    

        // Note: You can use a factory pattern here.

        InsuranceBuilder nyBenz = new Auto();
        //IInsuranceBuilder caBoat = new Boat();

        // Pass the auto specification to the engineer
        EngineerDirector engineer = new EngineerDirector(nyBenz);
        //EngineerDirector engineer = new EngineerDirector(caBoat);

        // Tell the engineer to construct the insurance using the specifications
        // of the Auto class

        engineer.constructInsurance();

        // The engineer builds the insurance based on the spec

        Insurance insurance = engineer.returnInsurance();

        System.out.println("Insurance object created \n " + insurance);

    }

}
