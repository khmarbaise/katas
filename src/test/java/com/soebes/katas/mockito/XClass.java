package com.soebes.katas.mockito;

public class XClass
{
    private long counter;

    public XClass()
    {
        this.counter = 0;
    }

    public void theMethodToCall( String parameters )
    {
        System.out.println( "counter:" + counter + " theMethodToCall:" + parameters );
    }

    public long getCounter()
    {
        return counter;
    }

    public void setCounter( long counter )
    {
        this.counter = counter;
    }
}
