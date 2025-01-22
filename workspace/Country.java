// Name: Eren;
// Date: 1/22/25
// Description: This defines the class of every country which is used to create instances of the Country class in the Main.java file

public class Country
{
  private String language="";
  private String imageFile="";
  private String name="";
  private String capital="";

  public Country() {
    name = "United States";
    capital = "Washington, D.C";
    language = "English";
    imageFile = "US.jpg";
  }

  public Country(String name, String capital, String language, String imageFile) 
  {
    this.name = name;
    this.capital = capital;
    this.language = language;
    this.imageFile = imageFile;
  }

  public String toString() {

    return name+"'s capital is " + capital + " and its primary language is " + language;
  }

  public String getCapital() {
    return capital;
  }

  



   public String getLanguage() {
    return language;
  }
  public String getName() {
    return name;
  }

  public String getImageFile() {
    return imageFile;
  }
 

 


  
}
