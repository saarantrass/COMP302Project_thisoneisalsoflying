package Domain.GameObjects.Atoms.Shields;

import Domain.GameObjects.Atoms.Atom;

public class LotaShield extends AtomDecorator {
	private double updatedEfficiency;
	private static double LOTA_EFF = 0.1;
	public LotaShield(Atom atom) {
		super(atom);
		this.updatedEfficiency=atom.getEfficiency();
		updateEfficiency();
	}

	@Override 
	public double getEfficiency() {
		return this.updatedEfficiency;	
	}
	@Override
	public void setEfficiency(double eff) {
		eff = eff*100;
		eff = Math.round(eff);
		eff = eff /100;
		this.updatedEfficiency = eff;
	}

	@Override
	public void updateEfficiency() {
		double effFactor = (1 - this.updatedEfficiency) * LOTA_EFF;
		double speedFactor = 0.07;
		this.setEfficiency(this.updatedEfficiency+this.updatedEfficiency*effFactor);
		this.setSpeed(this.getSpeed()*(1-speedFactor));
	}

}
