package PSO;
/**
 * @author Bilal BOUALEM
 */
import java.util.ArrayList;

public class Swarm {
	public int nbrParticule;
	public int dim;
	public Position gBest;
	public int igBest;
	public double fgBest;
	public ArrayList<Particule> particules;
	public Fitness fit;
	/** 
	 *  Constructeur d'un essaim de particule
	 * @param n nombre de particules
	 * @param d dimension du probleme
	 * @param inf limite infereur du probleme
	 * @param sup limite superieur du probleme
	 */
	Swarm(Fitness f, int n,int d, double inf, double sup)
	{
		this.nbrParticule = n;
		this.dim = d;
		this.fit = f;
		particules = new ArrayList<Particule>();
		this.gBest = new Position(this.dim);
		this.fgBest = Math.pow(1, 8);
		for (int i=0;i<this.nbrParticule;i++)
		{
			particules.add(new Particule(fit,this.dim,inf,sup));
			if (particules.get(i).fBest< this.fgBest)
			{
				this.fgBest =particules.get(i).fBest;
				
				this.gBest.setPosition(particules.get(i).pBest);
			}
		}
	}
	/** 
	 *  Constructeur d'un essaim de particule
	 * @param n nombre de particules
	 * @param inf les limites infereur du probleme
	 * @param sup les limites superieur du probleme
	 */
	Swarm(Fitness f, int n, double[] inf, double[] sup)
	{
		this.nbrParticule = n;
		this.dim = inf.length;
		this.fit = f;
		particules = new ArrayList<Particule>();
		this.fgBest = Math.pow(1, 8);
		for (int i=0;i<this.nbrParticule;i++)
		{
			particules.add(new Particule(fit,inf,sup));
			if (particules.get(i).fBest< this.fgBest)
			{
				this.fgBest =particules.get(i).fBest;
				this.gBest.setPosition(particules.get(i).pBest);
			}
		}
	}
	
	public void updateVitesseupdateVitess(double w,double c1,double c2)
	{
		for (int i=0;i<this.nbrParticule;i++)
		{
			particules.get(i).updateVitess(w, c1, c2, this.gBest);
		}
	}
	public void updateVitesseupdateVitess(double[] w,double[] c1,double[] c2)
	{
		for (int i=0;i<this.nbrParticule;i++)
		{
			particules.get(i).updateVitess(w[i], c1[i], c2[i], this.gBest);
		}
	}
	
	public void updatePosition()
	{
		for (int i=0;i<this.nbrParticule;i++)
		{
			particules.get(i).updatePosition();
		}
	}
	
	public void updategBest()
	{
		double m = particules.get(0).fBest;
		if (this.fgBest>particules.get(0).fBest)
		{
			this.gBest.setPosition(particules.get(0).pBest); 
			this.fgBest = particules.get(0).fBest;
		}
		for (int i=1;i<this.nbrParticule;i++)
		{
			if (m>particules.get(i).fBest)
			{
				m = particules.get(i).fBest;
				if (this.fgBest>particules.get(i).fBest)
				{
					this.gBest.setPosition(particules.get(i).pBest); 
					this.fgBest = particules.get(i).fBest;
				}
			}
		}
	}

}
