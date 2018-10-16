package com._25builder;

public class EngineerDirector
{
    private InsuranceBuilder insuranceBuilder;

    public EngineerDirector(InsuranceBuilder insuranceBuilder)
    {
        this.insuranceBuilder = insuranceBuilder;
    }

    public Insurance returnInsurance()
    {
        return this.insuranceBuilder.getInsurance();
    }

    public void constructInsurance()
    {
        // the order in which to build the various components of the complex object
        this.insuranceBuilder.buildLocation();
        this.insuranceBuilder.buildVehicle();
        this.insuranceBuilder.buildDriver();

    }
}
