package edu.pitt.cmpinf401.lab8;

public class StudentScore 
{
	private String name;
	private double score;
	
	public StudentScore(String name, double score) 
	{
		this.name = name;
		this.score = score;
	}
	public String getName() 
	{
		return this.name;
	}
	public double getScore() 
	{
		return this.score;
	}
}