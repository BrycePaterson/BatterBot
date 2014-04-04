package jars;

public class Expecting {
	/**
	 * Boolean for expecting a certain response to a question
	 */
	private boolean expecting = false;
	
	/**
	 * Set expecting to true
	 */
	public void set(){
		expecting = true;
	}
	
	/**
	 * Set expecting to false
	 */
	public void unset(){
		expecting = false;
	}
	
	/**
	 * Return status of expecting
	 * @return
	 */
	public boolean get(){
		return expecting;
	}
}
