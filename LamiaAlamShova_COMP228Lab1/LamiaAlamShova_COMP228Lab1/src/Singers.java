public class Singers {

  private int singer_id;
  private String singer_name;
  private String singer_address;
  private String  date_of_birth;
  private int num_of_albums_published;
  //constructor with zero arguments
    public void Singers()
    {

    }
    //constructor with 1 arguments

    public void Singers(int a)
    {
        this.singer_id = a;
    }
    //constructor with 2 arguments
    public void Singers(int a,String b)
    {
        this.singer_id = a;
        this.singer_name  = b;
    }
    //constructor with 3 arguments
    public void Singers(int a,String b,String c)
    {
        this.singer_id = a;
        this.singer_name  = b;
        this.singer_address = c;
    }
    //constructor with 4 arguments
  public void Singers(int a,String b,String c, String d)
     {
        this.singer_id = a;
        this.singer_name  = b;
        this.singer_address = c;
        this.date_of_birth = d;
     }
     //constructor with 5 arguments
  public void Singers(int a,String b,String c, String d,int e)
  {
      this.singer_id = a;
      this.singer_name  = b;
      this.singer_address = c;
      this.date_of_birth = d;
      this.num_of_albums_published = e;

  }
 public void setSinger_id (int sing_Id)
 {
     this.singer_id=sing_Id;

 }
    public void setSinger_name (String sing_name)
    {
        this.singer_name=sing_name;

    }
    public void setSinger_address (String sing_address)
    {
        this.singer_address = sing_address;

    }
    public void setSinger_dob (String sing_dob)
    {
        this.date_of_birth = sing_dob;

    }
    public void setSinger_NumOfAlbum(int sing_NumOfAlb)
    {
        this.num_of_albums_published = sing_NumOfAlb;

    }
  public void setSinger_AllTogether(int sing_Id,String sing_name,String sing_address,String sing_dob, int sing_NumOfAlb)
  {
      this.singer_id = sing_Id;
      this.singer_name = sing_name;
      this.singer_address = sing_address;
      this.date_of_birth = sing_dob;
      this.num_of_albums_published = sing_NumOfAlb;
  }

  //Getters

    public int GetSingerId()
    {
        return singer_id;
    }
    public String GetSingername()
    {
        return singer_name;
    }
    public String GetSingeraddress()
    {
        return singer_address;
    }
    public String GetSingerDob()
    {
        return date_of_birth;
    }
    public int GetSingerNumOfAlbum()
    {
        return num_of_albums_published;
    }

}
