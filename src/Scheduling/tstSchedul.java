package Scheduling;
/**
 * @author Bilal BOUALEM
 */
import PSO.*;

public class tstSchedul {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int dim = 2;// dimension du Probleme
			int nbrPart = 20;//nombre de Particule
			int inf = -2;// Bonde inferieur
			int sup=2;//Bonde Superieur
			double[] w = {0.4};//
			double c1=2;
			double c2=2;
			ObjectFunc of = new ObjectFunc();
			Solver s = new Solver (w,c1,c2);
			s.maxIter = 50;
			Position x = s.PSO(of, nbrPart, dim, inf, sup);
			System.out.println(x);
			System.out.println(of.F(x));
	}
}
