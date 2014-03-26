package mar19;

public final class Animal 
{
    private String _type;
    private String _id;
    private int _time_arrived;
    
    public Animal(String type, String id)
    {
        _type = type;
        _id = id;
        _time_arrived = Integer.MIN_VALUE;
    }
    
    public boolean is_type_Dog()
    {
        return this.get_type().compareToIgnoreCase("dog") == 0;
    }
    
    public boolean is_type_Cat()
    {
        return this.get_type().compareToIgnoreCase("cat") == 0;
    }
    
    public String get_type()
    {
        return this._type;
    }
    
    public String get_id()
    {
        return this._id;
    }
    
    public int get_time_arrived()
    {
        return this._time_arrived;
    }
    
    public void set_time_arrived(int time)
    {
        if (time > 0) {
            _time_arrived = time;
        }
    }
    
    public boolean is_earlier_than(Animal a)
    {
        return this.get_time_arrived() < a.get_time_arrived();
    }
    
    public String toString()
    {
        return (this.is_type_Cat() ? "Cat" : "Dog") + " " + get_id() + " " + get_time_arrived();
    }
}
