package Domain.GameObjects.Atoms.Shields;


import Domain.GameObjects.Atoms.Throwable;

public class LotaShield extends ShieldDecorator {
	private double updatedEfficiency;
	private static double LOTA_EFF = 0.1;
	public LotaShield(Throwable atom) {
		super(atom);
		this.updatedEfficiency=atom.getEfficiency();
	}

	@Override
	public double getEfficiency() {
		return this.updatedEfficiency;	
	}
	
	private void setEfficiency(double eff) {
		this.updatedEfficiency = eff;
	}

	@Override
	public void addShield(int type) {
		System.out.println("before"+ this.updatedEfficiency);
		double effFactor = (1 - this.updatedEfficiency) * LOTA_EFF;
		double speedFactor = 0.07;
		setEfficiency(this.updatedEfficiency+this.updatedEfficiency*effFactor);
		this.setSpeed(this.getSpeed()*(1-speedFactor));
		System.out.println("after"+ this.updatedEfficiency);
	}

}