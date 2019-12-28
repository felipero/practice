using System;

public static class ReverseString
{
    public static string Reverse(string input)
    {
	    string reverse = "";
	    foreach (char c in input.ToCharArray()){
	    	reverse = c.ToString() + reverse;
	    }
	    return reverse;
    }
}
