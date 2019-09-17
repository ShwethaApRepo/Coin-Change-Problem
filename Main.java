import java.util.Scanner;
import java.lang.Math;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;
class Main {
  public static class KeyValue
  {
    double Value;
    String Key;
    
    KeyValue(double v, String k)
    {
      this.Value=v;
      this.Key=k;
    }
  }
  
  public static class Wrapper
  {
    KeyValue currency[];
    
    Wrapper()
    {
      this.currency = new KeyValue[12];
      this.currency[0] = new KeyValue(.01,"One Pence");
      this.currency[1] = new KeyValue(.02,"Two Pence");
      this.currency[2] = new KeyValue(.05,"Five Pence");
      this.currency[3] = new KeyValue(.10,"Ten Pence");
      this.currency[4] = new KeyValue(.20,"Twenty Pence");
      this.currency[5] = new KeyValue(.50,"Fifty Pence");
      this.currency[6] = new KeyValue(1,"One Pound");
      this.currency[7] = new KeyValue(2,"Two Pounds");
      this.currency[8] = new KeyValue(5,"Five Pounds");
      this.currency[9] = new KeyValue(10,"Ten Pounds");
      this.currency[10] = new KeyValue(20,"Twenty Pounds");
      this.currency[11] = new KeyValue(50,"Fifty Pounds");
    }

    void MinCoins(double change)
    {
      double AmtLeft=change;
      String track="";
      
      for(int i=this.currency.length-1;i>=0;i--)
      { System.out.println("start"+AmtLeft);
        AmtLeft = Math.round(AmtLeft*100.0)/100.0;
        if(this.currency[i].Value>AmtLeft)
        {
          System.out.println("skipped");
          continue;
          
        }
        else if(this.currency[i].Value==AmtLeft)
         {
           track=track+", "+this.currency[i].Key;
           break;
         }
         else if(AmtLeft!=0)
         {
          AmtLeft=AmtLeft-this.currency[i].Value;
          while(AmtLeft>this.currency[i].Value)
          {
            AmtLeft=AmtLeft-this.currency[i].Value;
            track=track+this.currency[i].Key;
          }
          
          System.out.println("last"+AmtLeft);
          if (track=="")
          {
              track=track+this.currency[i].Key;
          }
          else
          track=track+", "+this.currency[i].Key;
          System.out.println("loop"+i+" "+ track);
         }
      }
      if (track=="")
      {
        System.out.println("No Combination found");
      }
      else
      System.out.println(track);
    }
    }
  public static void main(String[] args) {
     Wrapper wap=new Wrapper();
    //System.out.println("Enter price");
    double price,pay,change;
   // Scanner scan=new Scanner(System.in);
    price=8.75;
    //System.out.println("Enter Payment");
    pay=50;
    change=pay-price;
    if(change<0)
    System.out.println("ERROR");
    else
    {
      wap.MinCoins(change);
    }
  }
}
