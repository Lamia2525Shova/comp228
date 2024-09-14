//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

       Singers singer1 = new Singers();
       Singers singer2 = new Singers();
       Singers singer3 = new Singers();



       //assigning the value
        //for singer 1
       singer1.setSinger_id(1);
       singer1.setSinger_name("Pritom Hassan");
       singer1.setSinger_address("Dhaka-Bangladesh");
       singer1.setSinger_dob("1st jan, 1990");
       singer1.setSinger_NumOfAlbum(5);
       singer1.setSinger_AllTogether(1,
               "Pritom Hassan","Dhaka-Bangladesh",
               "1st jan, 1990", 5);

       // for singer 2
        singer2.setSinger_id(2);
        singer2.setSinger_name("Habib Wahid");
        singer2.setSinger_address("Chittagong-Bangladesh");
        singer2.setSinger_dob("17th Feb, 1995");
        singer2.setSinger_NumOfAlbum(6);
        singer2.setSinger_AllTogether(2,
                "Habib Wahid","Chittagong-Bangladesh",
                "17th Feb, 1995",6 );

        //for singer 3
        singer3.setSinger_id(3);
        singer3.setSinger_name("Porshi");
        singer3.setSinger_address("Sylhet-Bangladesh");
        singer3.setSinger_dob("25th Mar, 1995");
        singer3.setSinger_NumOfAlbum(13);
        singer3.setSinger_AllTogether(3,
                "Porshi","Sylhet-Bangladesh",
                "25th Mar, 1995",13 );

       //printing them on screen:
        System.out.println("Singer 1" );
        System.out.println("Singer's Id : " + singer1.GetSingerId());
        System.out.println("Name : " + singer1.GetSingername());
        System.out.println("Address : " + singer1.GetSingeraddress());
        System.out.println("Date of Birth : " + singer1.GetSingerDob());
        System.out.println("Number of Album Published : " + singer1.GetSingerNumOfAlbum());

        System.out.println("Singer 2" );
        System.out.println("Singer's Id : " + singer2.GetSingerId());
        System.out.println("Name : " + singer2.GetSingername());
        System.out.println("Address : " + singer2.GetSingeraddress());
        System.out.println("Date of Birth : " + singer2.GetSingerDob());
        System.out.println("Number of Album Published : " + singer2.GetSingerNumOfAlbum());

        System.out.println("Singer 3" );
        System.out.println("Singer's Id : " + singer3.GetSingerId());
        System.out.println("Name : " + singer3.GetSingername());
        System.out.println("Address : " + singer3.GetSingeraddress());
        System.out.println("Date of Birth : " + singer3.GetSingerDob());
        System.out.println("Number of Album Published : " + singer3.GetSingerNumOfAlbum());

    }
}