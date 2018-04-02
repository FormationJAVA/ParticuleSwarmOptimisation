package PSO;
/**
 * @author Bilal BOUALEM
 */
public class Solver {
	public double[] w;
	public double c1;
	public double c2;
	public int maxIter=30;
	
	public Solver (double[] w,double c1,double c2,int maxIter)
	{
		this.w= w;
		this.c1=c1;
		this.c2= c2;
		this.maxIter= maxIter;
		
	}
	public Solver (double[] w,double c1,double c2)
	{
		this.w= w;
		this.c1=c1;
		this.c2= c2;		
	}

	/**
	 * 
	 * @param fit
	 * @param n
	 * @param d
	 * @param inf
	 * @param sup
	 * @return
	 */
	public Position PSO(Fitness fit, 
			int n,
			int d, 
			double inf, 
			double sup)
	{
		
		Swarm myswarm = new Swarm(fit,n,d, inf, sup);

		for (int i=0;i<maxIter;i++)
		{
			if (w.length==maxIter)
				myswarm.updateVitesseupdateVitess(w[i], c1, c2);
			else
				myswarm.updateVitesseupdateVitess(w[0], c1, c2);
			
			myswarm.updatePosition();
			myswarm.updategBest();
		}
		return myswarm.gBest;
	}
	/**
	 * 
	 * @param fit
	 * @param n
	 * @param inf
	 * @param sup
	 * @return Solution Optimale
	 */
	public static Position PSO(Fitness fit, int n,double[] inf, double[] sup)
	{
		Swarm myswarm = new Swarm(fit,n, inf, sup);
		
		return myswarm.gBest;
	}

}
