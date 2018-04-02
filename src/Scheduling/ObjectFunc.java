package Scheduling;
/**
 * @author Bilal BOUALEM
 */
import PSO.Fitness;
import PSO.Position;

public class ObjectFunc implements Fitness {

	@Override
	public double F(Position P) {
		/*double[] a = {3,4};
		return P.sum(a);*/

		return Math.pow(P.P[0]-1 , 2) + 
				(10 * Math.pow(Math.pow(P.P[0],2)-P.P[1], 2));
	}

}
