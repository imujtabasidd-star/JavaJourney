public class CarpetCostCalculator {
public static void main (String[] args)
{
double li=120;
double bi=240;
double lf=li/12;
double bf=bi/12;
double asf=lf*bf;
double psf=200;
double csp=asf*psf;
System.out.println("Cost before discount: Rs" + csp);
double d=10;
double da=csp/d;
double dsp=csp-da;
System.out.println("Cost after discount: Rs" + dsp);
     }
}
