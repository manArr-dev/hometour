package game;

public class Item {
	
	private String description;

    private double weight;

    //constructor with parameters

    public Item(String desc,double weight)

    {

         this.weight=weight;

         this.description= desc;

    }

    //constructor with parameters

    public Item()

    {

         this.weight=0.0;

         this.description= "";

    }

    //getter methods for instance variables

    String getDescription()

    {

         return this.description;

    }

    double getWeight()

    {

         return this.weight;

    }

    //setter methods

    void setDescription(String desc)

    {

         this.description=desc;

    }

    void setWeight(double weight)

    {

         this.weight=weight;

    }

    public String toString()

    {

         return description+ " "+ weight+"\n";

    }

}
