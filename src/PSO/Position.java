package PSO;
/**
 * @author Bilal BOUALEM
 */
import java.util.Random;
import java.util.stream.DoubleStream;

public class Position {
	
	public double[] P;
	
	public Position ()
	{
		P = new double [1];
	}
	
	public Position (double[] infBound, double[] supBound)
	{
		int n =  supBound.length;
		Random r = new Random();
		double[] dist = new double [n];
		P = new double [n];
		if (infBound.length==supBound.length)
		{
			for (int i =0; i<n; i++)
			{
				dist [i] = supBound[i] - infBound[i];
				P[i] =infBound[i] + ( r.nextDouble()* dist[i]);
			}
		}
	}
	
	public Position (int n, double infBound, double supBound)
	{
		Random r = new Random();
		double dist = supBound - infBound;
		P = new double [n];
		for (int i =0; i<n; i++)
		{
			
			P[i] =infBound + ( r.nextDouble()* dist);
		}
	}
	
	public Position (int n)
	{
		P = new double [n];
		for (int i =0; i<n; i++)
		{
			
			P[i] =0;
		}
	}
	
	public void setPosition(Position P)
	{
		int n=this.P.length;
		if (n==P.P.length)
		{
			for (int i =0; i<n; i++)
			{
				
				this.P[i] =P.P[i];
			}
		}
	}
	public void add(Position P)
	{
		int n=this.P.length;
		Position out = new Position (n);
		if (n==P.P.length)
		{
			for (int i =0; i<n; i++)
			{
				
				this.P[i] +=P.P[i] ;
			}
		}

	}
	public static Position add(Position P1,Position P2)
	{
		int n=P2.P.length;
		Position out = new Position (n);
		if (n==P1.P.length)
		{
			for (int i =0; i<n; i++)
			{
				
				out.P[i] =P1.P[i]+P2.P[i] ;
			}
		}
		return out;
	}
	public static Position sous(Position P1,Position P2)
	{
		int n=P2.P.length;
		Position out = new Position (n);
		if (n==P1.P.length)
		{
			for (int i =0; i<n; i++)
			{
				
				out.P[i] =P1.P[i]-P2.P[i] ;
			}
		}
		return out;
	}
	public static Position mul(Position P1,Position P2)
	{
		int n=P2.P.length;
		Position out = new Position (n);
		if (n==P1.P.length)
		{
			for (int i =0; i<n; i++)
			{
				
				out.P[i] =P1.P[i]*P2.P[i] ;
			}
		}
		return out;
	}
	public static Position mul(Position P1,double a)
	{
		int n=P1.P.length;
		Position out = new Position (n);

			for (int i =0; i<n; i++)
			{
				
				out.P[i] =P1.P[i]*a ;
			}
		return out;
	}
	public void mul(Position P)
	{
		int n=this.P.length;

		if (n==P.P.length)
		{
			for (int i =0; i<n; i++)
			{
				
				this.P[i]*=P.P[i] ;
			}
		}

	}
	
	public void mul(double a)
	{
		int n=this.P.length;
		
		for (int i =0; i<n; i++)
		{		
			this.P[i]*=a ;
		}

	}
	
	public double sum ()
	{
		double s=0;
		int n=this.P.length;
		for (int i =0; i<n; i++)
		{		
			s +=this.P[i] ;
		}
		return s;
	}
	public double sum (double [] a)
	{
		double s=0;
		int n=this.P.length;
		for (int i =0; i<n; i++)
		{		
			s +=a[i]*this.P[i] ;
		}
		return s;
	}
	public String toString()
	{
		String message="[ ";
		for (int i=0;i<P.length;i++)
		{
			message+= P[i]+" ";
		}
		message+= "]";
		return message;
	}

}
