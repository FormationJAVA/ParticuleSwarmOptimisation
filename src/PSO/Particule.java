package PSO;
/**
 * @author Bilal BOUALEM
 */
import java.util.Random;

public class Particule {
	public int dim;	
	public Position Pos;
	public Position pBest;
	public Position vitess;
	public double fBest;
	public Fitness fit;
	
	
	Particule(Fitness f,int n, double inf, double sup)
	{
		this.dim = n;
		Pos = new Position (n,inf,sup);
		vitess=new Position (this.dim );
		pBest=new Position (this.dim );
		pBest.setPosition(this.Pos);
		fit = f;
		this.fBest = fit.F(pBest);
	}
	
	
	Particule(Fitness f,double[] inf, double[] sup)
	{
		this.dim = inf.length;
		Pos = new Position (inf,sup);
		vitess=new Position (this.dim );
		pBest=new Position (this.dim );
		pBest.setPosition(this.Pos);
		fit = f;
		this.fBest = fit.F(pBest);
	}
	
	
	Particule(Fitness f,int n)
	{
		this.dim = n;
		pBest=new Position (this.dim );
		vitess=new Position (this.dim );
		Pos = new Position (n);
		pBest.setPosition(this.Pos);
		fit = f;
		this.fBest = fit.F(pBest);
	}
	
	
	
	public void updateVitess(double w,double c1,double c2, Position gBest)
	{
		Random r  =new Random();
		double rand = r.nextDouble();
		try {
		this.vitess.mul(w);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		Position influence = Position.sous(this.pBest, this.Pos);
		influence.mul(c1*rand);
		this.vitess.add(influence);

		influence = Position.sous(gBest, this.Pos);
		influence.mul(c2*rand);
		this.vitess.add(influence);
		
	}
	
	
	
	public void updatePosition()
	{
		this.Pos.add(this.vitess);
		ispBest();
	}
	
	
	public boolean ispBest()
	{

		if (fit.F(this.pBest)<fit.F(this.Pos))
			return false;
		else 
		{
			this.pBest.setPosition(this.Pos);
			this.fBest = this.fit.F(this.pBest);
		}
		
		return true;
		
	}
}
