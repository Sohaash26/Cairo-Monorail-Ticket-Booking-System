import java.util.ArrayList;

public class Time {
	private int hour1;
	private int hour2;
	public static int countTimeSlots = 0;
	public ArrayList <Time> time_slots = new ArrayList<>(); // 10 time slots
	
	public Time()
	{
		hour1 = 0;
		hour2 = 0;
		countTimeSlots++;
	}
	
	public void time_slots()
	{
		System.out.println("Available time slots!");
		for(int i =0; i<time_slots.size();i++)
		{
			System.out.println(time_slots.get(i).getHour1() + " | " + time_slots.get(i++).getHour2());
		}
	}
	
	public static void Add_time_slots()
	{
		Time t;
		for(int i = 1; i<24;i++)
		{
			t = new Time(i , ++i);
			t.time_slots.add(t);
			t.time_slots();
		}
	}
	
	public void viewTimeSlot()
	{
		for(int i =0; i<time_slots.size();i++)
		{
			System.out.println("From: " + time_slots.get(i).getHour1() + " to: " + time_slots.get(i++).getHour2());
		}
	}
	
	public Time(int hour1 , int hour2)
	{
		if(this.hour1 <= 24 && this.hour1 >=0 && this.hour2 <= 24 && this.hour2 >=0)
			{
			this.hour1 = hour1;
			this.hour2 = hour2;
			}
			countTimeSlots++;
	}
	
	

	
	public int getHour1() {
		return hour1;
	}

	public void setHour1(int hour1) {
		this.hour1 = hour1;
	}

	public int getHour2() {
		return hour2;
	}

	public void setHour2(int hour2) {
		this.hour2 = hour2;
	}

	@Override
	public String toString() {
		return "From "+ hour1 + "to " + hour2;
	}

	
}
