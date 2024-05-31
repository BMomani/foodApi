package org.bmomani.foodapi.dto;

import java.util.ArrayList;

public class Ingredient{
    public int id;
    public String name;
    public double amount;
    public String unit;
    public ArrayList<Nutrient> nutrients = new ArrayList<>();
    public String localizedName;
    public String image;
}
